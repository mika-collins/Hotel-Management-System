/**
 * PROGRAM PURPOSE: The controller for the HotelGuestReservation.fxml page to handle and create a new guest reservation
 * @author Mika Collins and Tyler Gwiazdowski
 * Date: 4/19/25
 * Section: CSC 331-001 and 003
 *
 */

package com.example.hotelmanagementsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class HotelGuestReservationController {
    // initialize FXML
    @FXML private TextField textField_PartySize;
    @FXML private TextField textField_NumBeds;
    @FXML private TextField textField_NumDaysStaying;
    @FXML private TextField textField_TotalCost;
    @FXML private ChoiceBox<String> choiceBox_RoomType;
    @FXML private CheckBox checkbox_BreakfastPackage;
    @FXML private Button button_CheckIn;


    // List of possible room types to be initialized in the choice box
    ObservableList<String> roomTypeList = FXCollections.observableArrayList("Standard", "Handicap Accessible", "Balcony");

    // Creating an empty array list to handle the current reservations
    private static ArrayList<HotelGuestReservation> currentReservationList = new ArrayList<>();

    // Creating an array list to handle the room numbers that are already occupied
    private static ArrayList<String> occupiedRoomsList = new ArrayList<>();
    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();

    Rooms room=null;

    /**
     * Getter method for the array list of current hotel reservations
     * @params none
     * @return the array list of current hotel reservations
     */

    public static ArrayList<HotelGuestReservation> getCurrentReservationList() {
        return currentReservationList;
    }

    /**
     * Method to create and show a pop-up alert in case of an error
     * @param title The title to be displayed with the alert pop-up
     * @param content The content to specify the error that occurred
     * @return void
     */

    @FXML
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR); // create new Error object
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    /**
     * Method to initialize the choice box to a defaulted standard room upon loading the reservation page
     *
     * @params none
     * @return void
     */

    @FXML
    private void initialize() { // default the drop down menu for room type to standard
        choiceBox_RoomType.setItems(roomTypeList);
        choiceBox_RoomType.setValue("Standard");
    }

    /**
     * Helper method to randomly generate a room and floor # for the guest and add it to a list of occupied rooms
     *
     * @params none
     * @return The string combination of the floor and room numbers in the format (ex. 2,4)
     */

    public String randomNumberGenerator() {
        Random random = new Random();
        int roomNumber;
        int floorNumber;
        String floorAndRoomNumber;

        do {
            // Randomly generate a room # between 1-99 and a floor # between 1-4
            roomNumber = random.nextInt(100) + 1;
            floorNumber = random.nextInt(4) + 1;

            floorAndRoomNumber = floorNumber + "," + roomNumber;

            // Check the list to see if the floor and room # combo is already occupied
        } while (occupiedRoomsList.contains(floorAndRoomNumber));
        occupiedRoomsList.add(floorAndRoomNumber);

        return floorAndRoomNumber;
    }

    /**
     * Helper method to create a new instance of a room depending on the selected room type
     *
     * @param roomType the string room type chosen by the guest
     * @param roomNumber the integer room number
     * @param floorNumber the integer floor number
     * @param numBeds the number of beds requested by the guest
     * @return void
     */
    private Rooms roomSelection(String roomType, int roomNumber, int floorNumber, int numBeds) {
        switch (roomType) {
            case "Standard":
                return new StandardRoom(roomNumber, floorNumber, numBeds);
            case "Handicap Accessible":
                return new HandicappedAccessibleRoom(roomNumber, floorNumber, numBeds);
            case "Balcony":
                return new BalconyRoom(roomNumber, floorNumber, numBeds);
        }
        return null;
    }

    /**
     * Helper method to retrieve the last name of the guest requesting the reservation
     *
     * @params none
     * @return the string last name of the guest filling out the reservation
     */

    public String getGuestLastName() {
        // Retrieve current guest list, index to last guest, and get their last name
        ArrayList<HotelGuestInformation> guestList = HotelGuestInformationController.getCurrentGuestList();
        HotelGuestInformation mostRecentGuest = guestList.get(guestList.size() - 1);
        return mostRecentGuest.getLastName();
    }

    /**
     * Method to take user input, create a new reservation, and add it to an array list of current reservations upon clicking the check in button
     *
     * @param event the action of pressing the check in button
     * @return void
     */

    @FXML
    private void buttonCheckIn(ActionEvent event) {
        if (textField_TotalCost.getText().isEmpty()) {
            showAlert("Error", "Please calculate the total cost before checking in.");
            return;
        }

        try {
            // try to retrieve user input
            int numDaysStaying = Integer.parseInt(textField_NumDaysStaying.getText());
            int partySize = Integer.parseInt(textField_PartySize.getText());
            int numBeds = Integer.parseInt(textField_NumBeds.getText());
            boolean breakfastPackage = checkbox_BreakfastPackage.isSelected();
            String roomType = choiceBox_RoomType.getValue();

            // Error handling - pop-up alert in case the user left a text field blank or with invalid input
            if (numDaysStaying <= 0 || partySize <= 0 || numBeds <= 0) {
                showAlert("Error", "Please make sure to fill all required information.");
                return;
            }

            // Retrieve and split up the room and floor numbers for the reservation
            String floorAndRoomNumber = randomNumberGenerator();
            String[] floorAndRoom = floorAndRoomNumber.split(",");
            int floorNumber = Integer.parseInt(floorAndRoom[0]);
            int roomNumber = Integer.parseInt(floorAndRoom[1]);

            // Create a new room based on the room type selected
            room = roomSelection(roomType, roomNumber, floorNumber, numBeds);

            // Retrieve the last name of the guest filling the reservation
            String guestLastName = getGuestLastName();

            // Create a new reservation object
            HotelGuestReservation newReservation = new HotelGuestReservation(guestLastName, roomType, partySize, numDaysStaying, breakfastPackage, room);
            currentReservationList.add(newReservation);

            // Navigate back to the home page after checking in
            try {
                Parent root = FXMLLoader.load(getClass().getResource("HotelHomePage.fxml"));
                Stage stage = (Stage) button_CheckIn.getScene().getWindow();
                stage.setScene(new Scene(root));

            } catch (IOException error) { // catch input output exception error and display error message
                showAlert("Error", "Unable to navigate back to home page.");
            }

        } catch (NumberFormatException error) { // catch number format exception error and display error message
            showAlert("Error", "Please enter integers for Party Size, Number of Beds, and Number of Days Staying.");
        }
    }

    /**
     * Method to calculate the cost of the reservation based on party size, days staying, room type, and breakfast package
     * @param event the action event of clicking the calculate total button
     */
    @FXML
    private void buttonCalculateTotal(ActionEvent event) {

        try {
            // Retrieve the user provided information from the GUI
            BigDecimal partySize = new BigDecimal(textField_PartySize.getText());
            BigDecimal numDays = new BigDecimal(textField_NumDaysStaying.getText());

            // Create a temporary room in order to gain the proper room price for total calculation
            String roomType = choiceBox_RoomType.getValue();
            int numBeds = Integer.parseInt(textField_NumBeds.getText());
            int temporaryRoomNumber = 0;
            int temporaryFloorNumber = 0;
            Rooms tempRoomForPrice = roomSelection(roomType, temporaryRoomNumber, temporaryFloorNumber, numBeds);

            // Calculate the total cost for the reservation
            BigDecimal total = new BigDecimal(1);

            total = total.multiply(partySize);
            total = total.multiply(numDays);
            total = total.multiply(BigDecimal.valueOf(tempRoomForPrice.getRoomPrice()));

            // if breakfast package is selected, add $100.00 to the total
            if (checkbox_BreakfastPackage.isSelected()) {
                double breakfastPackage = 100.00; // cost for breakfast package is $100.00
                total = total.add(BigDecimal.valueOf(breakfastPackage));
            }

            // Display the total cost to the GUI text box
            textField_TotalCost.setText(currency.format(total));

        } catch (Exception error) { // catch errors if textboxes are left empty
            showAlert("Error", "Unable to calculate cost, please make sure all inputs are filled.");
        }
    }
}
