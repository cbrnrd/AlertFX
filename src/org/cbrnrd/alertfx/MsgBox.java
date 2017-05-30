package org.cbrnrd.alertfx;

import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.stage.StageStyle;


public class MsgBox {

    String msg;
    Alert.AlertType type = Alert.AlertType.INFORMATION;
    String header = "Info";

    /**
     * The style of the stage
     */
    public StageStyle style = StageStyle.DECORATED;

    Alert dialog;

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

    public void setHeader(String head){
        dialog.setHeaderText(head);
    }

    public void setSize(double x, double y){
        dialog.setX(x);
        dialog.setY(y);
    }

    /**
     * Applies a custom css file to the alert
     * @param path The full path of the css file
     */
    public void applyCss(String path){
        DialogPane dialogPane = dialog.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource(path).toExternalForm());
        dialogPane.getStyleClass().add(path.replace(".css", ""));  // Shouldn't have extension
    }

    public void show(){

        dialog = new Alert(type);
        dialog.setTitle("Alert");
        dialog.setContentText(msg);
        dialog.setResizable(false);
        dialog.initStyle(style);
        dialog.showAndWait();
    }

    public void showNonblock(){
        dialog = new Alert(type);
        dialog.setTitle("Alert");
        dialog.setContentText(msg);
        dialog.setResizable(false);
        dialog.initStyle(style);
        dialog.show();
    }

}
