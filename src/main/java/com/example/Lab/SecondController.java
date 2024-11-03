package com.example.Lab;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SecondController {

    @FXML
    private CheckBox ch1;

    @FXML
    private CheckBox ch2;

    @FXML
    private CheckBox ch3;

    @FXML
    private Button btn;

    @FXML
    private Label label;

    @FXML
    private TextField textField;

    @FXML
    public void initialize() {
        // Set widgets to be invisible by default
        btn.setVisible(false);
        label.setVisible(false);
        textField.setVisible(false);
    }

    // Method to toggle Button visibility based on ch1
    @FXML
    private void toggleButton() {
        btn.setVisible(ch1.isSelected());
    }

    // Method to toggle Label visibility based on ch2
    @FXML
    private void toggleLabel() {
        label.setVisible(ch2.isSelected());
    }

    // Method to toggle TextField visibility based on ch3
    @FXML
    private void toggleTextField() {
        textField.setVisible(ch3.isSelected());
    }
}
