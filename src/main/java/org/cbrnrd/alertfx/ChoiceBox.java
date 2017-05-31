package org.cbrnrd.alertfx;

import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.DialogPane;
import javafx.stage.StageStyle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


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


    public ChoiceBox(String... choices){
        Collections.addAll(this.choices, choices);
    }


    public void addChoice(String choice){
        choices.add(choice);
    }

    public void setHeader(String header){
        alert.setHeaderText(header);
    }


    public String show(){
        alert = new ChoiceDialog<>(null, choices);
        alert.initStyle(style);
        Optional<String> result = alert.showAndWait();
        return result.orElse(null);  // God bless intellij help
    }



}
