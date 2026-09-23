package org.example.csc311_mod3assignment1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class StartController {

    @FXML
    private TextField rateField;

    @FXML
    private TextField yearsField;

    @FXML
    private TextField amountField;

    @FXML
    private TextField paymentField;

    @FXML
    private TextField totalField;

    @FXML
    private TextField rateUsedField;

    @FXML
    private TextField yearsUsedField;

    @FXML
    private TextField amountUsedField;

    @FXML
    private TextField paymentUsedField;

    @FXML
    private void calculateLoan(ActionEvent event) {

        try {
            double rate = Double.parseDouble(
                    rateField.getText().replace("%", "").trim()
            );
            //this gets the interest rate, removes the % symbol and converts it to a number

            double years = Double.parseDouble(yearsField.getText());
            double amount = Double.parseDouble(amountField.getText());
            //turns the number of years and the amount of the loan to numbers (doubles)

            double monthlyRate = rate / 100 / 12;
            double numberOfPayments = years * 12;
            //this calculates the annual interest rate to a monthly rate and the total of monthly payments

            double monthlyPayment =
                    amount * (monthlyRate * Math.pow(1 + monthlyRate, numberOfPayments))
                            / (Math.pow(1 + monthlyRate, numberOfPayments) - 1);

            double totalPayment = monthlyPayment * numberOfPayments;
            //calculates monthly loan payment and the total payment

            paymentField.setText(String.format("$%.2f", monthlyPayment));
            totalField.setText(String.format("$%.2f", totalPayment));

            rateUsedField.setText(String.format("%.2f%%", rate));
            yearsUsedField.setText(String.format("%.0f", years));
            amountUsedField.setText(String.format("$%.2f", amount));
            paymentUsedField.setText(String.format("$%.2f", monthlyPayment));
            //displays the monthly payment and the inputted values used to calculate the total

        } catch (NumberFormatException e) {
            totalField.setText("Invalid Input");
        }
    }
}