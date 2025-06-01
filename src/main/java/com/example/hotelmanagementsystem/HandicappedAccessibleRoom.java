/**
 * HandicappedAccessibleRoom.java
 *
 * This is the class for handicapped accessible rooms, a subclass of Rooms.
 *
 * @author Tyler Gwiazdowski and Ty Whitley
 * Date: 4-21-2025
 * Section: CSC 331-003
 *
 * Purpose: This is the class for handicapped accessible rooms, a subclass of Rooms.
 */

package com.example.hotelmanagementsystem;

public class HandicappedAccessibleRoom extends Rooms {  // as a subclass of Rooms, HandicapedAccessibleRoom must extend Rooms
                                                        // to inherit its attributes

    /**
     * Purpose: this is the constructor for the HandicappedAccessibleRoom class.
     * Its attributes are inherited from Rooms
     *
     * @param roomNumber = the room number of the handicapped accessible room
     * @param floorNumber = the floor number of the handicapped accessible room
     * @param bedQuantity = the number of beds the handicapped accessible room has
     * @return void
     */

    // Constructor

    public HandicappedAccessibleRoom(int roomNumber, int floorNumber, int bedQuantity) {
        super(roomNumber, 90.00, floorNumber, bedQuantity);

        // HandicappedAccessibleRoom inherits roomNumber, floorNumber, bedQuantity, and roomPrice from Rooms.
        // roomPrice has been hard coded to $90.00
    }
}


