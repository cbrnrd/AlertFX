package org.cbrnrd.alertfx.full;

import javafx.scene.control.Alert;

/**
 * TODO javadoc
 */
public class Warn {

    String warning;
    Alert alert;
    String header = "Warning!";

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
        alert.setContentText(warning);
        alert.setHeaderText(header);
        alert.showAndWait();
    }

}
