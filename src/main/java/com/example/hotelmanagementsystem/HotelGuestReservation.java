/**
 * @author Tyler Gwiazdowski
 * Date: 4-8-2025
 * Section: CSC 331-003
 *
 * Purpose: the reservation class for the hotel management program
 */
package com.example.hotelmanagementsystem;

public class HotelGuestReservation {
    private String guestInfo;
    private String roomType;
    private int partyNumber;
    private int numDaysStaying;
    private boolean breakfastPackage;
    private Rooms room;

    /**
     * The constructor method for the reservation class
     * @param guestInfo the string guest info for the reservation, specifically the last name
     * @param roomType the string type of room (standard, handicap accessible, balcony)
     * @param partyNumber the integer party size for the reservation
     * @param numDaysStaying the integer number of days for the stay
     * @param breakfastPackage the boolean breakfast package for the reservation
     */
    public HotelGuestReservation(String guestInfo, String roomType, int partyNumber, int numDaysStaying, boolean breakfastPackage, Rooms room) {
        this.guestInfo = guestInfo;
        this.roomType = roomType;
        this.partyNumber = partyNumber;
        this.numDaysStaying = numDaysStaying;
        this.breakfastPackage = breakfastPackage;
        this.room = room;
    }

    /**
     * Getter for the guest info for the reservation
     * @return the string guest info (last name)
     */
    public String getGuestInfo() {
        return guestInfo;
    }

    /**
     * Getter for the room type of the reservation
     * @return the string room type
     */
    public String getRoomType(){
        return roomType;
    }

    /**
     * Getter for the integer party number of the reservation
     * @return the integer party number
     */
    public int getPartyNumber() {
        return partyNumber;
    }

    /**
     * Getter for the integer number of days the guest will be staying
     * @return the integer number of days staying
     */
    public int getNumDaysStaying() {
        return numDaysStaying;
    }

    /**
     * Getter for the boolean breakfast package
     * @return the boolean breakfast package
     */
    public boolean isBreakfastPackage() {
        return breakfastPackage;
    }

    /**
     *
     * @return
     */
    public int getRoomNumber() {
        return room.getRoomNumber();
    }

    /**
     *
     * @return
     */
    public int getFloorNumber() {
        return room.getFloorNumber();
    }

    /**
     * Setter for the guest info for the reservation
     * @param guestInfo string guest info (last name)
     */
    public void setGuestInfo(String guestInfo) {
        this.guestInfo = guestInfo;
    }

    /**
     * Setter for the string room type of the reservation
     * @param roomType the string room type
     */
    public void setRooms(String roomType) {
        this.roomType = roomType;
    }

    /**
     * Setter for the integer party number of the reservation
     * @param partyNumber the integer party number
     */
    public void setPartyNumber(int partyNumber) {
        this.partyNumber = partyNumber;
    }

    /**
     * Setter for the integer number of days staying for the reservation
     * @param numDaysStaying the integer number of days staying
     */
    public void setNumDaysStaying(int numDaysStaying) {
        this.numDaysStaying = numDaysStaying;
    }

    /**
     * Setter for the boolean breakfast package for the reservation
     * @param breakfastPackage the boolean breakfast package
     */
    public void setBreakfastPackage(boolean breakfastPackage) {
        this.breakfastPackage = breakfastPackage;
    }
}




