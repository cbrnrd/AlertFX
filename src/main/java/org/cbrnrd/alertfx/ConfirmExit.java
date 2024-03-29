package org.cbrnrd.alertfx;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.stage.StageStyle;
import org.cbrnrd.alertfx.exceptions.AlertNotEditableException;

import java.util.Optional;

/**
 * Custom alert to confirm the exiting of a program
 */
public class ConfirmExit {

    /**
     * Default blank constructor
     */
    public ConfirmExit(){}

    /**
     * The style of the stage
     */
    public StageStyle style = StageStyle.DECORATED;

    private Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Would you like to exit?", ButtonType.YES, ButtonType.NO);

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
     * @return true if the user clicks "Yes", false if otherwise
     */
    public boolean show(){

        alert.initStyle(style);
        alert.setHeaderText("Exit");
        setGraphicToError(alert);
        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == ButtonType.YES;
    }

    private void setGraphicToError(Alert alert){
        Label label = new Label();
        label.getStyleClass().addAll("alert", "error", "dialog-pane");
        alert.setGraphic(label);
    }

}
