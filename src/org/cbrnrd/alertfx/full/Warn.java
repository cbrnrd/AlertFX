package org.cbrnrd.alertfx.full;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

/**
 * TODO javadoc
 */
public class Warn {

    String warning;
    Alert alert;
    String header = "Warning!";

    /**
     * The style of the stage
     */
    public StageStyle style = StageStyle.DECORATED;


    public Warn(String warning){
        this.warning = warning;
    }

    public void setHeader(String head){
        alert.setHeaderText(head);
    }

    public void setSize(double x, double y){
        alert.setX(x);
        alert.setY(y);
    }

    public void show(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.initStyle(style);
        alert.setContentText(warning);
        alert.setHeaderText(header);
        alert.showAndWait();
    }

    public void showNonblock(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.initStyle(style);
        alert.setContentText(warning);
        alert.setHeaderText(header);
        alert.show();
    }

}
