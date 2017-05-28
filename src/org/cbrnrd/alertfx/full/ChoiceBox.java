package org.cbrnrd.alertfx.full;

import javafx.scene.control.ChoiceDialog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ChoiceBox {

    List<String> choices = new ArrayList<>();

    public ChoiceBox(String... choices){
        Collections.addAll(this.choices, choices);
    }


    public void addChoice(String choice){
        choices.add(choice);
    }

    public void show(){
        ChoiceDialog<String> alert = new ChoiceDialog<>(null, choices);

    }

}
