/**
 * StandardRoom.java
 *
 * This is the class for standard rooms, a subclass of Rooms.
 *
 * @author Tyler Gwiazdowski and Ty Whitley
 * Date: 4-21-2025
 * Section: CSC 331-003 and 001
 *
 * Purpose: this is the class for standard rooms, a subclass of Rooms.
 */

package com.example.hotelmanagementsystem;

public class StandardRoom extends Rooms { // as a subclass of Rooms, StandardRoom must extend Rooms
                                          // to inherit is attributes.

    /**
     * Purpose: this is the constructor for the StandardRoom class.
     * all attributes are inherited from Rooms.
     *
     * @param roomNumber = the room number of the guest's room
     * @param floorNumber = the floor number of the guest's room
     * @param bedQuantity = the number of beds the guest's room has
     * @return void
     */

    // Constructor

    public StandardRoom(int roomNumber, int floorNumber, int bedQuantity) {
        super(roomNumber, 100.00, floorNumber, bedQuantity);

        // StandardRooms inherits roomNumbr. floorNumber, roomPrice and bedQuantity from Rooms
        // RoomPrice is hard coded at $100.00
    }
}

