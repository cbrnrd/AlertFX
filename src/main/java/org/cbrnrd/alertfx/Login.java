package org.cbrnrd.alertfx;


import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

import java.util.Optional;

/**
 * Show a login box
 */

public class Login {

    /**
     * Default blank constructor
     */
    public Login(){}

    /**
     * The login image
     */
    public String image = this.getClass().getResource("login_icon.png").toString();

    /**
     *
     * @param path
     */
    public void setImage(String path){
        this.image = image;
    }

    /**
     * The window title
     */
    public String title = "Login";

    /**
     * Sets {@link Login#title}
     * @param title The title of the window
     */
    public void setTitle(String title){
        this.title = title;
    }

    /**
     * The header of the alert (login to <code>xyz</code>)
     */
    public String header = "Login";

    /**
     * Sets {@link Login#header}
     * @param header The header of the alert
     */
    public void setHeader(String header){
        this.header = header;
    }

    private Dialog<Pair<String, String>> alert;

    /**
     * Sets the size of the alert
     * @param x The size on the x-axis
     * @param y The size on the y-axis
     */
    public void setSize(double x, double y){
        alert.setX(x);
        alert.setY(y);
    }

    /**
     * Shows the dialog and waits
     * @return {@link Optional} - A {@link Pair} that has the structure: <code>username, password</code>
     */
    public Optional<Pair<String, String>> show(){

        alert = new Dialog<>();
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setGraphic(new ImageView(image));

        // Set the buttons
        ButtonType buttonType = new ButtonType("Login", ButtonBar.ButtonData.OK_DONE);
        alert.getDialogPane().getButtonTypes().addAll(buttonType, ButtonType.CANCEL);

        // Create grid and set padding
        GridPane gridpane = new GridPane();
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        gridpane.setPadding(new Insets(20, 150, 10, 10));

        // Create fields
        TextField username = new TextField();
        username.setPromptText("Username");
        PasswordField password = new PasswordField();
        password.setPromptText("Password");

        // Add fields to grid
        gridpane.add(new Label("Username:"), 0, 0);
        gridpane.add(username, 1, 0);
        gridpane.add(new Label("Password:"), 0, 1);
        gridpane.add(password, 1, 1);

        // Enable or disable button depending on
        // whether or not the fields are filled
        Node loginButton = alert.getDialogPane().lookupButton(buttonType);
        loginButton.setDisable(true);

        // Validation
        username.textProperty().addListener((observable, oldValue, newValue) -> {
            loginButton.setDisable(newValue.trim().isEmpty());
        });

        alert.getDialogPane().setContent(gridpane);

        // Focus on username before password
        Platform.runLater(username::requestFocus);

        alert.setResultConverter(dialogButton -> {
            if (dialogButton == buttonType) {
                return new Pair<>(username.getText(), password.getText());
            }
            return null;
        });

        return alert.showAndWait();

    }

}
