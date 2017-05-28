package org.cbrnrd.alertfx.full;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

import java.util.Optional;

/**
 * Created by Carter on 5/27/17.
 */
public class ConfirmExit {

    public ConfirmExit(){}

    public boolean show(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Would you like to exit?", ButtonType.YES, ButtonType.NO);
        alert.setHeaderText("Exit");
        setGraphicToError(alert);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.YES){
            return true;
        } else {
            return false;
        }
    }

    protected static void setGraphicToError(Alert alert){
        Label label = new Label();
        label.getStyleClass().addAll("alert", "error", "dialog-pane");
        alert.setGraphic(label);
    }

}
