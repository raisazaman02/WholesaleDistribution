package sample;
/**
 * Author: Raisa Zaman
 * Date: 03/20/2021
 * Group number: 7
 */
import java.util.ArrayList;

public class PurchaseOrder {
    String purchaseID;
    String vendorName;
    ArrayList<String> date = new ArrayList<String>();
    ArrayList<String> quantity = new ArrayList<String>();
    ArrayList<String> items = new ArrayList<String>();
    double costOfAllItems;

    public PurchaseOrder(String vendorName, String purchaseID, String date, String quantity, String items, double costOfAllItems) {
        this.vendorName = vendorName;
        this.purchaseID = purchaseID;
        this.date.add(date);
        this.quantity.add(quantity);
        this.items.add(items);
        this.costOfAllItems = costOfAllItems;
    }

    public double getCostOfAllItems() {
        return costOfAllItems;
    }

    public void setCostOfAllItems(double costOfAllItems) {
        this.costOfAllItems = costOfAllItems;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public PurchaseOrder() {
    }

    public String getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(String purchaseID) {
        this.purchaseID = purchaseID;
    }

    public ArrayList<String> getNeedDate() {
        return date;
    }

    public void setDateNeed(String date) {
        this.date.add(date);
    }

    public ArrayList<String> getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity.add(quantity);
    }

    public ArrayList<String> getItemList() {
        return items;
    }

    public void setItemList(String items) {
        this.items.add(items);
    }

}
