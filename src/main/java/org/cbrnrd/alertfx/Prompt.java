package org.cbrnrd.alertfx;

import javafx.scene.control.DialogPane;
import javafx.scene.control.TextInputDialog;
import javafx.stage.StageStyle;
import org.cbrnrd.alertfx.exceptions.AlertNotEditableException;

import java.util.Optional;

/**
 * Gets the users input from a TextField
 */
public class Prompt {

    String question;
    String header = "Please enter your info:";
    TextInputDialog alert = new TextInputDialog();

    /**
     * The style of the stage
     */
    public StageStyle style = StageStyle.DECORATED;

    public Prompt(String question){
        this.question = question;
    }

    public Prompt(String question, String header){
        this.question = question;
        this.header = header;
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
     * Set the header of the alert
     * @param head The header to be shown
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
     * Sets the name of the alert window
     * @param s Name of the window
     */
    public void setWindowName(String s){
        if (alert.isShowing()){
            throw new AlertNotEditableException("Alert not editable while it is showing");
        }
        alert.setTitle(s);
    }


    /**
     * Shows the alert
     * @return String - Whatever the user entered. Null if nothing was entered
     */
    public String show(){
        alert.initStyle(style);
        alert.setHeaderText(header);
        alert.setContentText(question);
        Optional<String> result = alert.showAndWait();
        if (result.isPresent()){
            return result.toString();
        } else return null;

    }

}
