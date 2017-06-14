package org.cbrnrd.alertfx;

import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.stage.StageStyle;
import org.cbrnrd.alertfx.exceptions.AlertNotEditableException;


/**
 * Shows a general, customizable message box
 */
public class MsgBox{

    private String msg;
    private Alert.AlertType type = Alert.AlertType.INFORMATION;
    private String header = "Info";

    /**
     * The style of the stage
     */
    public StageStyle style = StageStyle.DECORATED;

    private Alert dialog;

    /**
     * Show a message box with context <code>msg</code>
     * @param msg The message to display
     */
    public MsgBox(String msg){
        this.msg = msg;
    }

    /**
     * Show a message box with context <code>msg</code>
     * and type <code>type</code>
     * @param msg The message to display
     * @param type The alert type of the MsgBox
     */
    public MsgBox(String msg, Alert.AlertType type){
        this.msg = msg;
        this.type = type;
    }

    /**
     * Show a message box with context <code>msg</code>
     * and type <code>type</code>
     * @param msg The message to display
     * @param type The alert type of the MsgBox
     * @param header The header to display (default: "Info")
     */
    public MsgBox(String msg, Alert.AlertType type, String header){
        this.msg = msg;
        this.type = type;
        this.header = header;
    }

    /**
     * Sets the header of the alert
     * @param head The header to show
     */
    public void setHeader(String head){
        if (dialog.isShowing()) {
            throw new AlertNotEditableException("Unable to edit alert while it is being shown");
        }
        dialog.setHeaderText(head);
    }

    /**
     * Sets the size of the alert
     * @param x The size on the x-axis
     * @param y The size on the y-axis
     */
    public void setSize(double x, double y){
        if (dialog.isShowing()) {
            throw new AlertNotEditableException("Unable to edit alert while it is being shown");
        }
        dialog.setWidth(x);
        dialog.setHeight(y);
    }

    /**
     * Applies a custom css file to the alert
     * @param path The full path of the css file
     */
    public void applyCss(String path){
        if (dialog.isShowing()) {
            throw new AlertNotEditableException("Unable to edit alert while it is being shown");
        }
        DialogPane dialogPane = dialog.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource(path).toExternalForm());
        dialogPane.getStyleClass().add(path.replace(".css", ""));  // Shouldn't have extension
    }

    /**
     * Shows the alert
     */
    public void show(){
        dialog = new Alert(type);
        dialog.setTitle("Alert");
        dialog.setContentText(msg);
        dialog.setResizable(false);
        dialog.initStyle(style);
        dialog.showAndWait();
    }

    /**
     * Shows the alert, but it isn't always on top
     */
    public void showNonblock(){
        dialog = new Alert(type);
        dialog.setTitle("Alert");
        dialog.setContentText(msg);
        dialog.setResizable(false);
        dialog.initStyle(style);
        dialog.show();
    }

}
