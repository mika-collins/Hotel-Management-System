/**
 * PROGRAM PURPOSE: Program to serve as a controller for the HotelGuestInformation.fxml page and error handle
 * @author Mika Collins
 * Date: 4/17/25
 * CSC 331-001
 */
package com.example.hotelmanagementsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

public class HotelGuestInformationController {

    @FXML private TextField textField_FirstName;
    @FXML private TextField textField_LastName;
    @FXML private TextField textField_PhoneNumber;
    @FXML private TextField textField_EmailAddress;
    @FXML private TextField textField_CardNumber;
    @FXML private Button button_Next;
    @FXML private Button button_Back;

    // Array list of current hotel guests
    private static final ArrayList<HotelGuestInformation> currentGuestsList = new ArrayList<>();

    /**
     * Getter for the current guest list
     * @return the current list of guests in the hotel management system
     */
    public static ArrayList<HotelGuestInformation> getCurrentGuestList() {
        return currentGuestsList;
    }

    /**
     * Method to create and show a pop-up alert in case of an error
     * @param title The title to be displayed with the alert pop-up
     * @param content The content to specify the error that occurred
     * @return
     */
    private void showAlert(String title, String content) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    /**
     * Method to submit entered guest credentials and navigate to the HotelGuestReservation page upon clicking the next button
     * @param event the action of pressing the Next button
     */
    @FXML
    private void buttonNext(ActionEvent event) {
        String firstName = textField_FirstName.getText();
        String lastName = textField_LastName.getText();
        String phoneNumber = textField_PhoneNumber.getText();
        String emailAddress = textField_EmailAddress.getText();
        String cardNumber = textField_CardNumber.getText();

        // Error handling - pop-up alert in case the user left a text field blank
        if (firstName.isEmpty() || lastName.isEmpty() || phoneNumber.isEmpty() || emailAddress.isEmpty() || cardNumber.isEmpty()) {
            showAlert("Error", "Please make sure to fill all required information.");
            return;
        }

        // Create a new guest object with entered information
        HotelGuestInformation newGuest = new HotelGuestInformation(firstName, lastName, phoneNumber, emailAddress, cardNumber);

        // Add the new guest to the guest list
        currentGuestsList.add(newGuest);

        // Navigate to the next page being HotelGuestReservation
        try {
            Parent root = FXMLLoader.load(getClass().getResource("HotelGuestReservation.fxml"));
            Stage stage = (Stage) button_Next.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException error) {
            showAlert("Error", "Unable to navigate to the next page.");
        }
    }

    /**
     * Method to navigate back to the HotelHomePage upon clicking the back button
     * @param event the action event of clicking the back button
     */
    @FXML
    private void buttonBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("HotelHomePage.fxml"));
            Stage stage = (Stage) button_Back.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException error) {
            showAlert("Error", "Unable to navigate back to home page.");
        }
    }
}
