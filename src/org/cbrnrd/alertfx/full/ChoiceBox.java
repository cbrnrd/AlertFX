package org.cbrnrd.alertfx.full;

import javafx.scene.control.ChoiceDialog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


public class ChoiceBox {

    private List<String> choices = new ArrayList<>();
    private ChoiceDialog<String> alert;

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
        Optional<String> result = alert.showAndWait();
        return result.orElse(null);  // God bless intellij help

    }

}
