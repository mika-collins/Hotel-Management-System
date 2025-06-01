/**
 * PROGRAM PURPOSE: Program to serve as a controller for the CurrentHotelGuests.fxml page to display all current hotel guest information
 * @author Mika Collins
 * Date: 4/17/25
 * Section: CSC 331-001
 */

package com.example.hotelmanagementsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class CurrentHotelGuestsController {

    // initialize FXMl's

    @FXML private TableView<HotelGuestInformation> tableView_GuestsTable;
    @FXML private TableColumn<HotelGuestInformation, String> tableColumn_FirstName;
    @FXML private TableColumn<HotelGuestInformation, String> tableColumn_LastName;
    @FXML private TableColumn<HotelGuestInformation, String> tableColumn_Email;
    @FXML private TableColumn<HotelGuestInformation, String> tableColumn_PhoneNumber;
    @FXML private Button button_Back;

    /**
     * Method to display and manage removal of the list of current hotel guests to the TableView
     *
     * @params none
     * @return void
     */

    @FXML
    public void initialize() {
        // Assign the columns of the table to specified attributes
        tableColumn_FirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tableColumn_LastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tableColumn_Email.setCellValueFactory(new PropertyValueFactory<>("emailAddress"));
        tableColumn_PhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        // Take the currentGuestList and display its values to the table
        ArrayList<HotelGuestInformation> currentGuestList = HotelGuestInformationController.getCurrentGuestList();
        ObservableList<HotelGuestInformation> guestsList = FXCollections.observableArrayList(currentGuestList);
        tableView_GuestsTable.setItems(guestsList);
    }

    /**
     * Method to create and show a pop-up alert in case of an error
     *
     * @param title The title to be displayed with the alert pop-up
     * @param content The content to specify the error that occured
     * @return void
     */

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR); // create alert object
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    /**
     * Method to remove the selected guest from the GUI and current guest list upon clicking the Remove Selected Guest button
     *
     * @param event the action of pressing the remove guest button
     * @return void
     */

    @FXML
    private void buttonRemoveSelectedGuest(ActionEvent event) {
        HotelGuestInformation selectedGuest = tableView_GuestsTable.getSelectionModel().getSelectedItem();

        if (selectedGuest != null) {
            // Remove the guest object from the current guest list
            tableView_GuestsTable.getItems().remove(selectedGuest);
            HotelGuestInformationController.getCurrentGuestList().remove(selectedGuest);

            String guestName = selectedGuest.getLastName();

            ArrayList<HotelGuestReservation> currentReservations = HotelGuestReservationController.getCurrentReservationList();

            // Remove the specific reservation that is associated with the guest
            for (int i=0; i < currentReservations.size(); i++) {
                HotelGuestReservation reservation = currentReservations.get(i);

                if (reservation.getGuestInfo().equals(guestName)) {
                    currentReservations.remove(i);
                }
            }

        } else {
            showAlert("Error", "Please select a guest to remove.");
        }
    }

    /**
     * Method to navigate back to the HotelHomePage upon clicking the back button
     * @param event the action of pressing the back button
     * @return void
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

