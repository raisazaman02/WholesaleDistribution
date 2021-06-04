package sample;
/**
 * Author: Raisa Zaman
 * Date: 03/20/2021
 * Group number: 7
 */
import java.time.LocalDate;

public class Vendor {
    private int vendorID;
    private String fullName;
    private String address;
    private String city;
    private String state;
    private String phoneNumber;
    private double balance ;
    private double lastBalance ;
    private String lastOrder;
    private String seasonalDiscount;

    public Vendor(String fullName, String address, String city, String state, String phoneNumber, String lastOrder, String seasonalDiscount) {
        this.fullName = fullName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.phoneNumber = phoneNumber;
        this.balance = 0;
        this.lastBalance = 0;
        this.lastOrder = lastOrder;
        this.seasonalDiscount = seasonalDiscount;
    }

    public Vendor(String id, String fullName, String address, String city, String state, String phoneNumber, String lastOrder, String seasonalDiscount,String balance, String lastBalance) {
        this.vendorID = Integer.valueOf(id);
        this.fullName = fullName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.phoneNumber = phoneNumber;
        this.balance = Double.valueOf(balance);
        this.lastBalance = Double.valueOf(lastBalance);
        this.lastOrder = lastOrder;
        this.seasonalDiscount = seasonalDiscount;
    }
    public Vendor() {
    }


    public int getVendorID() {
        return vendorID;
    }

    public void setVendorID(int vendorID) {
        this.vendorID = vendorID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getLastBalance() {
        return lastBalance;
    }

    public void setLastBalance(double lastBalance) {
        this.lastBalance = lastBalance;
    }

    public String  getLastOrder() {
        return lastOrder;
    }

    public void setLastOrder(String lastOrder) {
        this.lastOrder = lastOrder;
    }

    public String getSeasonalDiscount() {
        return seasonalDiscount;
    }

    public void setSeasonalDiscount(String  seasonalDiscount) {
        this.seasonalDiscount = seasonalDiscount;
    }


}
