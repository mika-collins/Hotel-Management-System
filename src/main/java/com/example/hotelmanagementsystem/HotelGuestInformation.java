/**
 * PROGRAM PURPOSE: This is the HotelGuestInformation class containing the attributes, constructor, and behaviors for the guest's personal info.
 *
 * @author Tyler Gwiazdowski
 * Date: 4/15/25
 * Section: CSC 331-003
 */

package com.example.hotelmanagementsystem;

// Attributes

public class HotelGuestInformation {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private String cardNumber;

    /**
     * Constructor for the HotelGuest class
     * @param firstName String first name of the guest
     * @param lastName String last name of the guest
     * @param phoneNumber String phone number of the guest
     * @param emailAddress String email address of the guest
     * @param cardNumber String card number of the guest
     */

    // Constructor

    public HotelGuestInformation(String firstName, String lastName, String phoneNumber, String emailAddress, String cardNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.cardNumber = cardNumber;
    }

    // Getters/accessors

    /**
     * Getter method to return guest's first name
     * @params none
     * @return firstName = the string first name
     */

    public String getFirstName(){
        return firstName;
    }

    /**
     * Getter method to return the guest's last name
     *
     * @params none
     * @return lastName = the string last name
     */

    public String getLastName(){
        return lastName;
    }

    /**
     * Getter method to return the guest's phone number
     *
     * @params none
     * @return phoneNumber = the string phone number
     */

    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * Getter method for the guest's email address
     *
     * @params none
     * @return email address as a string
     */

    public String getEmailAddress(){
        return emailAddress;
    }

    /**
     * Getter method for the guest's card number
     * @return cardNumber as a string
     */
    public String getCardNumber(){
        return cardNumber;
    }

    /**
     * Setter method to set the guest's first name
     * @param firstName = first name of the guest as a string
     * @return void
     */

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    /**
     * Setter method to set the guest's last name
     * @param lastName = last name of the guest as a string
     * @return void
     */

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    /**
     * Setter method for the guest's phone number
     *
     * @param phoneNumber = the guest's phone number as a string
     * @return void
     */

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    /**
     * Setter method for the guest's email address
     *
     * @param emailAddress = the guest's email address as a string
     * @return void
     */

    public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }

    /**
     * Setter method for the guest's card number
     *
     * @param cardNumber = the guest's card number as a string
     * @return void
     */

    public void setCardNumber(String cardNumber){
        this.cardNumber = cardNumber;
    }
}
