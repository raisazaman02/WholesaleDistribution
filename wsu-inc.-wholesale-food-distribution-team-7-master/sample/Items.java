package sample;
/**
 * Group: 7
 * Author: Justen Latcau
 */

import java.util.*;

public class Items {

    private int getItemID;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    private String itemName;
    private String vendorid;
    private String itemtype;
    private String purprice;
    private String measure;
    private double sellingprice;
    private double quantity;
    private String expdate;

    public Items(){};
    public Items(String fullName, String IDVendor, String type, String purchase, String measurements) {
        this.getItemID = getRandomNumberString();
        this.itemName = fullName;
        this.vendorid = IDVendor;
        this.itemtype = type;
        this.purprice = purchase;
        this.measure = measurements;
        this.sellingprice = 1;
        this.quantity = 12;
    }

    public Items(int itemid, String itemName, String vendorid, String itemtype, String purprice, String measure, double sellingprice, double quantity, String expdate) {
        this.getItemID = getRandomNumberString();
        this.itemName = itemName;
        this.vendorid = vendorid;
        this.itemtype = itemtype;
        this.purprice = purprice;
        this.measure = measure;
        this.sellingprice = sellingprice;
        this.quantity = quantity;
        this.expdate = expdate;
    }



    public int getItemid() {
        return getItemID;
    }

    public void setItemid(int itemid) {
        this.getItemID = itemid;
    }

    public String getFullName() {
        return itemName;
    }

    public void setFullName(String fullName) {
        this.itemName = fullName;
    }

    public String getVendorID() {
        return vendorid;
    }

    public void setVendorID(String vendorID) {
        this.vendorid = vendorID;
    }

    public String itemType() {
        return itemtype;
    }

    public void setType(String type) {
        this.itemtype = type;
    }

    public String purchasePrice() {
        return purprice;
    }

    public void setPurchasePrice(String price) {
        this.purprice = price;
    }

    public String getmeasure() {
        return measure;
    }

    public void setmeasure(String measure) {
        this.measure = measure;
    }

    public double getSell() {
        return sellingprice;
    }

    public void setSell(double selling) {
        this.sellingprice = selling;
    }

    public double getItemQuantity() {
        return quantity;
    }

    public void setItemQuantity(double itemquantity) {
        this.quantity = itemquantity;
    }

    public String getExpirationDate() {
        return expdate;
    }

    public void setExpirationDate(String expirationdate) {
        this.expdate = expirationdate;
    }

    public static int getRandomNumberString() {
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        return number;
    }

}

