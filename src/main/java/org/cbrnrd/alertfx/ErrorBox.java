package org.cbrnrd.alertfx;

import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.StageStyle;
import org.cbrnrd.alertfx.exceptions.AlertNotEditableException;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Display an error message with a stack trace
 */
public class ErrorBox {

    private Throwable error;
    private Alert alert = new Alert(Alert.AlertType.ERROR);

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
     * The style of the stage
     */
    public StageStyle style = StageStyle.DECORATED;

    /**
     * Displays an error box with an optional expandable stack trace.
     * @param e The throwable error to display. (Shows the stack trace of <code>e</code>)
     */
    public ErrorBox(Throwable e){
        error = e;
    }

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
     * Shows the alert
     */
    public void show(){
        alert.initStyle(style);
        alert.setTitle("Exception Caught!");
        alert.setHeaderText("Exception encountered");
        alert.setContentText(error.getMessage());

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        error.printStackTrace(pw);
        String exceptionText = sw.toString();

        Label label = new Label("The exception stacktrace was:");
        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

        // Set expandable Exception into the dialog pane.
        alert.getDialogPane().setExpandableContent(expContent);

        alert.showAndWait();

    }

    /**
     * Shows the alert, but it isn't always on top
     */
    public void showNonblock(){
        alert.initStyle(style);
        alert.setTitle("Exception Caught!");
        alert.setHeaderText("Exception encountered");
        alert.setContentText(error.getMessage());

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        error.printStackTrace(pw);
        String exceptionText = sw.toString();

        Label label = new Label("The exception stacktrace was:");
        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

        // Set expandable Exception into the dialog pane.
        alert.getDialogPane().setExpandableContent(expContent);

        alert.show();
    }

}
