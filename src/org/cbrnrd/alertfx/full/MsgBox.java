package org.cbrnrd.alertfx.full;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

/**
 * Created by Carter on 5/26/17.
 */
public class MsgBox {

    String msg;
    Alert.AlertType type = Alert.AlertType.NONE;
    String header = "Info";
    public StageStyle style = StageStyle.DECORATED;

    Alert dialog;

    /**
     * Show a message box with context <code>msg</code>
     * @param msg The message to display
     */
    public MsgBox(String msg){
        this.msg = msg;
    }

    /**
     * Show a message box with context <code>msg</code>
     * and type <code>type</code>
     * @param msg The message to display
     * @param type The alert type of the org.cbrnrd.alertfx.full.MsgBox
     */
    public MsgBox(String msg, Alert.AlertType type){
        this.msg = msg;
        this.type = type;
    }

    /**
     * Show a message box with context <code>msg</code>
     * and type <code>type</code>
     * @param msg The message to display
     * @param type The alert type of the org.cbrnrd.alertfx.full.MsgBox
     * @param header The header to display (default: "Info")
     */
    public MsgBox(String msg, Alert.AlertType type, String header){
        this.msg = msg;
        this.type = type;
        this.header = header;
    }

    public void setHeader(String head){
        dialog.setHeaderText(head);
    }

    public void setSize(double x, double y){
        dialog.setX(x);
        dialog.setY(y);
    }
    public void show(){

        dialog = new Alert(type);
        dialog.setTitle("Alert");
        dialog.setContentText(msg);
        dialog.setResizable(false);
        dialog.initStyle(style);
        dialog.showAndWait();
    }

}
