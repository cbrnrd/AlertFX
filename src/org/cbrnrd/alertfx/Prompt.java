package org.cbrnrd.alertfx;

import com.sun.istack.internal.NotNull;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextInputDialog;
import javafx.stage.StageStyle;

import java.util.Optional;

/**
 * TODO make this be a {@link javafx.scene.control.TextArea} for input.
 * This is pretty much a QuestionBox right now
 */
public class Prompt {

    String question;
    String header = "Please enter your info:";
    TextInputDialog alert = new TextInputDialog();

    /**
     * The style of the stage
     */
    public StageStyle style = StageStyle.DECORATED;

    public Prompt(@NotNull String question){
        this.question = question;
    }

    public Prompt(@NotNull String question, String header){
        this.question = question;
        this.header = header;
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
        alert.initStyle(style);
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
