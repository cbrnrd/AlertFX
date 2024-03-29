package org.cbrnrd.alertfx;

import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.DialogPane;
import javafx.stage.StageStyle;
import org.cbrnrd.alertfx.exceptions.AlertNotEditableException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Has the user choose between multiple choice buttons (list)
 */
public class ChoiceBox {

    /**
     * The style of the stage
     */
    public StageStyle style = StageStyle.DECORATED;

    private List<String> choices = new ArrayList<>();
    private ChoiceDialog<String> alert;

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
     * Creates a text box with multiple choices
     * @param choices An array of choice strings
     */
    public ChoiceBox(String... choices){
        Collections.addAll(this.choices, choices);
    }


    /**
     * Adds a choice button
     * @param choice The choice to be added
     */
    public void addChoice(String choice){
        choices.add(choice);
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
     * Sets the header of the alert
     * @param header The header to be shown
     */
    public void setHeader(String header){
        if (alert.isShowing()){
            throw new AlertNotEditableException("Alert not editable while it is showing");
        }
        alert.setHeaderText(header);
    }


    /**
     * Shows the alert
     * @return String - Whatever the user selects
     */
    public String show(){
        alert = new ChoiceDialog<>(null, choices);
        alert.initStyle(style);
        Optional<String> result = alert.showAndWait();
        return result.orElse(null);
    }



}
