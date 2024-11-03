package com.example.Lab;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class CalculatorController {

    @FXML
    private TextField display;

    private double firstOperand = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    @FXML
    private void onDigitPressed(javafx.event.ActionEvent event) {
        String digit = ((Button) event.getSource()).getText();
        if (startNewNumber) {
            display.setText("");
            startNewNumber = false;
        }
        display.setText(display.getText() + digit);
    }

    @FXML
    private void onOperationPressed(javafx.event.ActionEvent event) {
        if (!display.getText().isEmpty()) {
            firstOperand = Double.parseDouble(display.getText());
            operator = ((Button) event.getSource()).getText();
            startNewNumber = true;
        }
    }

    @FXML
    private void onEqualsPressed() {
        if (!display.getText().isEmpty() && !operator.isEmpty()) {
            double secondOperand = Double.parseDouble(display.getText());
            double result;
            switch (operator) {
                case "+":
                    result = firstOperand + secondOperand;
                    break;
                case "-":
                    result = firstOperand - secondOperand;
                    break;
                case "*":
                    result = firstOperand * secondOperand;
                    break;
                case "/":
                    if (secondOperand == 0) {
                        display.setText("Error: Division by Zero");
                        return;
                    }
                    result = firstOperand / secondOperand;
                    break;
                default:
                    return;
            }
            display.setText(String.valueOf(result));
            startNewNumber = true;
            operator = "";
        }
    }

    @FXML
    private void onClearPressed() {
        display.setText("");
        firstOperand = 0;
        operator = "";
        startNewNumber = true;
    }
}
