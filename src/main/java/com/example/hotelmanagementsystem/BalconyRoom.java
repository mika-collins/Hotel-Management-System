/**
 * BalconyRoom.java
 *
 * This is the class for balcony rooms, a subclass of rooms.
 *
 * @author Tyler Gwiazdowski and Ty Whitley
 * Date: 4-21-2025
 * Section: CSC 331-003
 *
 * Purpose: this is the class for balcony rooms, a subclass of rooms.
 */

package com.example.hotelmanagementsystem;

public class BalconyRoom extends Rooms {  // Since BalconyRoom is a subclass of Rooms,
                                          // it must extend rooms to inherit its attributes

    /**
     * Purpose: this is the constructor for the BalconyRoom class.
     * its attributes are inherited from Rooms.
     *
     * @param roomNumber = the room number of the balcony room
     * @param floorNumber = the floor number of the balcony room
     * @param bedQuantity = the number of beds in the balcony room
     * @return void
     */

    //Constructor

    public BalconyRoom(int roomNumber, int floorNumber, int bedQuantity) {
        super(roomNumber, 150.00, floorNumber, bedQuantity);
        // BalconyRoom inherits roomNumber, floorNumber, roomPrice, bedQuantity from Rooms.
        // the room price of balcony rooms is hardcoded at $150.00.
    }
}


