package org.cbrnrd.alertfx;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.stage.StageStyle;
import org.cbrnrd.alertfx.exceptions.AlertNotEditableException;

import java.util.Optional;

/**
 * Display a Yes/No question box
 */
public class QuestionBox {

    private String question;
    private Alert alert;

    /**
     * The style of the stage
     */
    public StageStyle style = StageStyle.DECORATED;

    /**
     * Display a confirmation dialog to the end user
     * @param question The information to give to the end user
     * <code>false</code> if the "Cancel button is pressed
     */
    public QuestionBox(String question){
        this.question = question;
    }

    /**
     * Sets the header of the alert
     * @param head The header to display
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
     * @return <code>true</code> if "Yes" was pressed, else return false
     */
    public boolean show(){
        alert = new Alert(Alert.AlertType.CONFIRMATION, question, ButtonType.YES, ButtonType.NO);
        alert.initStyle(style);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) if (result.get() == ButtonType.YES) return true;
        return false;
    }
}
