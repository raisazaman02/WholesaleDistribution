package sample;

import javax.swing.*;
import java.util.*;

/**
 * Author: Athar Bakth
 * Date: 04/17/2021
 * Group number: 7
 */


public class Customer {
    /*
    5.	The system shall restrict adding duplicate Customer names.
    6.	The system shall restrict invalid or empty inputs from the users for all required fields
    7.	The system shall restrict adding past date values
    8.	The system shall allow owner users to update any customer profiles
    9.	The system shall allow owner users to delete any customer profiles only when balance is 0.
    10.	The system shall allow owner users to search for a customer profile by customer id or name.
    11.	The search result shall show the customer profile details of the searched customer.
    12.	The system shall display appropriate message when a customer profile is not found by the search.
    13.	The system shall allow owner users to see a list of customers in the system. The list should show the full name, phone number, balance, and last amount paid.
    14.	When deleting a customer profile, the system shall warn the users that all associated invoices will be deleted. If the users accept deletion, then the system shall automatically delete all invoices associated with the deleted customer.
     */



    private int customerid;
    private String fullName;
    private String streetAddress;
    private String city;
    private String state;
    private String phone;
    private double balance;
    private double lastPaidAmount;
    private Date lastOrderDate;

    public Customer(){};
    public Customer(String fullName, String streetAddress, String city, String state, String phone) {
        this.customerid = getRandomNumberString();
        this.fullName = fullName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.phone = phone;
        this.balance = 0;
        this.lastPaidAmount = 0;
    }

    public Customer(int customerid, String fullName, String streetAddress, String city, String state, String phone, double balance, double lastPaidAmount, Date lastOrderDate) {
        this.customerid = getRandomNumberString();
        this.fullName = fullName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.phone = phone;
        this.balance = balance;
        this.lastPaidAmount = lastPaidAmount;
        this.lastOrderDate = lastOrderDate;
    }



    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getLastPaidAmount() {
        return lastPaidAmount;
    }

    public void setLastPaidAmount(double lastPaidAmount) {
        this.lastPaidAmount = lastPaidAmount;
    }

    public Date getLastOrderDate() {
        return lastOrderDate;
    }

    public void setLastOrderDate(Date lastOrderDate) {
        this.lastOrderDate = lastOrderDate;
    }

    //will set customerID with generated number
    public static int getRandomNumberString() {
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        return number;
    }

}

