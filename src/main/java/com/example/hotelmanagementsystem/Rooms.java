/**
 * Rooms.java
 *
 *  this is the Rooms class for the hotel management program.
 *
 * @author Tyler Gwiazdowski
 * Date: 4-21-2025
 * Section: CSC 331-003
 *
 * Purpose: this is the Rooms class for the hotel management program, containing the
 * attributes, constructor, and getter/setter methods for the class.
 */

package com.example.hotelmanagementsystem;

// attributes: room number, roomPrice, floorNumber, bedQuantity.

public class Rooms {
private int roomNumber;
private double roomPrice;
private int floorNumber;
private int bedQuantity;

    /**
     * Purpose: this is the constructor for the Rooms class
     *
     * @param roomNumber = the room number
     * @param roomPrice = the total cost of the room
     * @param floorNumber = the number of the floor the room is on.
     * @param bedQuantity = the number of beds the room has
     * @return void
     */

    // Constructor

    public Rooms(int roomNumber, double roomPrice, int floorNumber, int bedQuantity){
        this.roomNumber = roomNumber;
        this.roomPrice = roomPrice;
        this.floorNumber = floorNumber;
        this.bedQuantity = bedQuantity;
    }

    // Getters/accessors

    /**
     * Purpose: this is the getter method that returns the room number.
     *
     * @params none
     * @return roomNumber = the guest's room number
     */

    public int getRoomNumber(){
        return roomNumber;
    }

    /**
     * Purpose: this is the getter method that returns the room price.
     *
     * @params none
     * @return RoomPrice = the total cost of the guest's room
     */

    public double getRoomPrice(){
        return roomPrice;
    }

    /**
     * Purpose: this is the getter method that returns the floor number of the guest's room
     *
     * @params none
     * @return floorNumber = the floor number of the guest's room.
     */

    public int getFloorNumber(){
        return floorNumber;
    }

    /**
     * Purpose: this is the getter method that returns the number of beds in the guest's room.
     *
     * @params none
     * @return bedQuantity = the number of beds the guest's room has
     */

    public int getBedQuantity(){
        return bedQuantity;
    }

    // Setters/mutators

    /**
     * Purpose: this is the setter method that sets the room number of the guest's room
     *
     * @param roomNumber = the room number of the guest's room
     * @return void
     */

    public void setRoomNumber(int roomNumber){
        this.roomNumber=roomNumber; // set room number
    }

    /**
     * Purpose: this is the setter method that sets the total cost of the guest's room
     *
     * @param roomPrice = the total cost of the guest's room as a double
     * @return void
     */

    public void setRoomPrice(double roomPrice){
        this.roomPrice=roomPrice; // set room price
    }

    /**
     * Purpose: this is the setter method that sets the floor number of the guest's room
     *
     * @param floorNumber = the floor number of the guest's room
     * @return void
     */

    public void setFloorNumber(int floorNumber){
        this.floorNumber=floorNumber; // set floor number
    }

    /**
     * Purpose: this is the setter method that sets the number of beds the guest's room has.
     *
     * @param bedQuantity = the number of beds the guest's room has
     * @return void
     */

    public void setBedQuantity(int bedQuantity){
        this.bedQuantity=bedQuantity; // set the bed quantity
    }
}
