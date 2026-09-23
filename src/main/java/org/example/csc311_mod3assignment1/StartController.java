package org.example.csc311_mod3assignment1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StartController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
