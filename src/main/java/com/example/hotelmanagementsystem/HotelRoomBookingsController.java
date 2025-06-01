/**
 * PROGRAM PURPOSE: Controller file to display the current hotel reservations in a TableView to the HotelRoomBookings.fxml page
 * @author Mika Collins
 * Date: 4/18/25
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

public class HotelRoomBookingsController {
    // initialize FXML's

    @FXML private Button button_Back;
    @FXML private TableView<HotelGuestReservation> tableView_BookingsTable;
    @FXML private TableColumn<HotelGuestReservation, Integer> tableColumn_FloorNumber;
    @FXML private TableColumn<HotelGuestReservation, Integer> tableColumn_RoomNumber;
    @FXML private TableColumn<HotelGuestReservation, String> tableColumn_LastName;
    @FXML private TableColumn<HotelGuestReservation, Integer> tableColumn_DaysStaying;
    @FXML private TableColumn<HotelGuestReservation, Integer> tableColumn_PartySize;
    @FXML private TableColumn<HotelGuestReservation, String> tableColumn_RoomType;

    /**
     * Method to create and show a pop-up alert in case of an error
     *
     * @param title The title to be displayed with the alert pop-up
     * @param content The content to specify the error that occured
     * @return void
     */
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR); // initialize Error object
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    /**
     * Method to display and manage removal of the list of current hotel guests to the TableView
     *
     * @params none
     * @return void
     */

    @FXML
    public void initialize() {
        // Assign the columns of the table to specified attributes
        tableColumn_FloorNumber.setCellValueFactory(new PropertyValueFactory<>("floorNumber"));
        tableColumn_RoomNumber.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        tableColumn_LastName.setCellValueFactory(new PropertyValueFactory<>("guestInfo"));
        tableColumn_DaysStaying.setCellValueFactory(new PropertyValueFactory<>("numDaysStaying"));
        tableColumn_PartySize.setCellValueFactory(new PropertyValueFactory<>("partyNumber"));
        tableColumn_RoomType.setCellValueFactory(new PropertyValueFactory<>("roomType"));

        // Take the currentGuestList and display its values to the table
        ArrayList<HotelGuestReservation> currentReservationList = HotelGuestReservationController.getCurrentReservationList();
        ObservableList<HotelGuestReservation> reservationList = FXCollections.observableArrayList(currentReservationList);
        tableView_BookingsTable.setItems(reservationList);
    }

    /**
     * Method to navigate back to the HotelHomePage upon clicking the back button
     *
     * @param event the action of clicking the back button
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
