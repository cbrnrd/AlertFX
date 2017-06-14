package org.cbrnrd.alertfx;

import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.stage.StageStyle;
import org.cbrnrd.alertfx.exceptions.AlertNotEditableException;

/**
 * Shows a warning alert
 */
public class Warn {

    String warning;
    Alert alert;
    String header = "Warning!";

    /**
     * The style of the stage
     */
    public StageStyle style = StageStyle.DECORATED;


    public Warn(String warning){
        this.warning = warning;
    }

    /**
    * Changes the header of the alert
    * @param head The header to show
    */
    public void setHeader(String head){
        if (alert.isShowing()){
            throw new AlertNotEditableException("Alert not editable while it is showing");
        }
        alert.setHeaderText(head);
    }

    /**
     * Sets the size of the alert
     * @param x The size on the x-axis
     * @param y The size on the y-axis
     */
    public void setSize(double x, double y){
        if (alert.isShowing()){
            throw new AlertNotEditableException("Alert not editable while it is showing");
        }
        alert.setWidth(x);
        alert.setHeight(y);
    }

    /**
     * Applies a custom css file to the alert
     * @param path The full path of the css file
     */
    public void applyCss(String path){
        if (alert.isShowing()){
            throw new AlertNotEditableException("Alert not editable while it is showing");
        }
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource(path).toExternalForm());
        dialogPane.getStyleClass().add(path.replace(".css", ""));  // Shouldn't have extension
    }

    /**
    * Shows the alert
    */
    public void show(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.initStyle(style);
        alert.setContentText(warning);
        alert.setHeaderText(header);
        alert.showAndWait();
    }

    /**
    * Shows the alert but isn't always on top
    */
    public void showNonblock(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.initStyle(style);
        alert.setContentText(warning);
        alert.setHeaderText(header);
        alert.show();
    }

}
