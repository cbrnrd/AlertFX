package org.cbrnrd.alertfx.full;

import com.sun.istack.internal.NotNull;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

/**
 * Created by Carter on 5/27/17.
 */
public class Prompt {

    String question;
    String header = "Please enter your info:";
    TextInputDialog alert = new TextInputDialog();

    public Prompt(@NotNull String question){
        this.question = question;
    }

    public Prompt(String question, String header){
        this.question = question;
        this.header = header;
    }

    public void setHeader(String head){
        alert.setHeaderText(head);
    }

    public void setSize(double x, double y){
        alert.setX(x);
        alert.setY(y);
    }

    public void setWindowName(String s){
        alert.setTitle(s);
    }



    public String show(){

        alert.setHeaderText(header);
        alert.setContentText(question);
        Optional<String> result = alert.showAndWait();
        if (result.isPresent()){
            return result.toString();
        } else {
            return "";  // TODO this should probably be changed
        }

    }

}
