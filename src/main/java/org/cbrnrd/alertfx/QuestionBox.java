package org.cbrnrd.alertfx;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.stage.StageStyle;

import java.util.Optional;


public class QuestionBox {

    String question;
    Alert alert;

    /**
     * The style of the stage
     */
    public StageStyle style = StageStyle.DECORATED;

    /**
     * Display a confirmation dialog to the end user
     * @param question The information to give to the end user
     * @return boolean <code>True</code> if the "YES" button is pressed,
     * <code>false</code> if the "Cancel button is pressed
     */
    public QuestionBox(String question){
        this.question = question;
    }

    public void setHeader(String head){
        alert.setHeaderText(head);
    }

    public void setSize(double x, double y){
        alert.setX(x);
        alert.setY(y);
    }

    /**
     * Applies a custom css file to the alert
     * @param path The full path of the css file
     */
    public void applyCss(String path){
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource(path).toExternalForm());
        dialogPane.getStyleClass().add(path.replace(".css", ""));  // Shouldn't have extension
    }

    public boolean show(){
        alert = new Alert(Alert.AlertType.CONFIRMATION, question, ButtonType.YES, ButtonType.NO);
        alert.initStyle(style);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) if (result.get() == ButtonType.YES) return true;
        return false;
    }
}
