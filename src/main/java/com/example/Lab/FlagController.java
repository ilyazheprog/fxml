package com.example.Lab;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;


public class FlagController {

    @FXML
    private ToggleGroup firstColorGroup;

    @FXML
    private ToggleGroup secondColorGroup;

    @FXML
    private ToggleGroup thirdColorGroup;

    @FXML
    private Label resultLabel;

    @FXML
    private void drawFlag() {
        String firstColor = ((RadioButton) firstColorGroup.getSelectedToggle()).getText();
        String secondColor = ((RadioButton) secondColorGroup.getSelectedToggle()).getText();
        String thirdColor = ((RadioButton) thirdColorGroup.getSelectedToggle()).getText();

        String result = firstColor + ", " + secondColor + ", " + thirdColor;
        resultLabel.setText("Цвет флага: " + result);
    }
}
