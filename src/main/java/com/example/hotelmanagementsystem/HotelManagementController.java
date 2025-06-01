/**
 * PROGRAM PURPOSE: Program to serve as a controller for the buttons on the hotel management system home page
 * @author Mika Collins
 * Date: 4/15/25
 * Section: CSC 331-001
 */

package com.example.hotelmanagementsystem;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.application.Platform;
import java.io.IOException;

public class HotelManagementController {

    /**
     * Method to create and show a pop-up alert in case of an error
     * @param title The title to be displayed with the alert pop-up
     * @param content The content to specify the error that occured
     * @return
     */

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR); // create new Alert object
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    /**
     * Method to open the Hotel Guest Information page upon clicking the Book Now button
     * @param event the action of pressing the Book Now button
     * @return void
     */

    @FXML
    private void buttonBookNow(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("HotelGuestInformation.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException error) { // catch input output exception error and display error message.
            showAlert("Error", "Unable to navigate to the next page.");
        }
    }

    /**
     * Method to open the Current Hotel Guests page upon clicking the View Info button
     *
     * @param event the action of pressing the View Info button
     * @return void
     */

    @FXML
    private void buttonViewInfo(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("CurrentHotelGuests.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException error) {  // catch input output exception error and display error message
            showAlert("Error", "Unable to navigate to the next page.");
        }
    }

    /**
     * Method to open the Hotel Room Bookings page upon clicking the View Bookings button
     * @param event the action of pressing the View Bookings button
     * @return void
     */

    @FXML
    private void buttonViewBookings(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("HotelRoomBookings.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException error) {  // catch input output exception error and display error message
            showAlert("Error", "Unable to navigate to the next page.");
        }
    }

    /**
     * Method to close the program entirely upon clicking the Logout button
     *
     * @param event the action of pressing the logout button
     * @return void
     */

    @FXML
    private void buttonLogOut(ActionEvent event) {
        Platform.exit();
    }
}
