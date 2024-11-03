package com.example.Lab;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FirstController {
    private boolean isLeft = true;

    @FXML
    private Button btn;

    @FXML
    private TextField ta_left;

    @FXML
    private TextField ta_right;

    @FXML
    private void switchText() {
        if (isLeft) {
            ta_right.setText(ta_left.getText()); // Move text to the right field
            ta_left.clear(); // Clear the left field
            ta_left.editableProperty().setValue(false); // Disable editing
            ta_right.editableProperty().setValue(true); // Enable editing
            btn.setText("<--"); // Change button text
        } else {
            ta_left.setText(ta_right.getText()); // Move text back to the left field
            ta_right.clear(); // Clear the right field
            ta_right.editableProperty().setValue(false); // Disable editing
            ta_left.editableProperty().setValue(true); // Enable editing
            btn.setText("-->"); // Reset button text
        }
        isLeft = !isLeft; // Toggle direction
    }
}
