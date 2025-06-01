/**
 * PROGRAM PURPOSE: Program to serve as the entry point for the hotel management home page and application
 * @author Mika Collins
 * Date: 4/15/25
 * Section: CSC 331-001
 */

package com.example.hotelmanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HotelManagement extends Application {

    /**
     * Method to start the Hotel Management JavaFX application and load the FXML file
     *
     * @param stage the main stage for this program
     * @return void
     */

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("HotelHomePage.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("Hotel Management System");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Main method to serve as an entry point and launcher for the program
     *
     * @param args arguments passed to the application
     * @return void
     */

    public static void main(String[] args) {
        launch(args);
    }
}
