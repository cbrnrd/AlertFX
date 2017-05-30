package org.cbrnrd.alertfx;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.StageStyle;

import java.util.Optional;

/**
 * Created by Carter on 5/27/17.
 */
public class ConfirmExit {

    public ConfirmExit(){}

    /**
     * The style of the stage
     */
    public StageStyle style = StageStyle.DECORATED;

    public boolean show(){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Would you like to exit?", ButtonType.YES, ButtonType.NO);
        alert.initStyle(style);
        alert.setHeaderText("Exit");
        setGraphicToError(alert);
        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == ButtonType.YES;
    }

    protected static void setGraphicToError(Alert alert){
        Label label = new Label();
        label.getStyleClass().addAll("alert", "error", "dialog-pane");
        alert.setGraphic(label);
    }

}
