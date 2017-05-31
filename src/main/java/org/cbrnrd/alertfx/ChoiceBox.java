package org.cbrnrd.alertfx;

import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.DialogPane;
import javafx.stage.StageStyle;

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
     * Sets the header of the alert
     * @param header The header to be shown
     */
    public void setHeader(String header){
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
        return result.orElse(null);  // God bless intellij help
    }



}
