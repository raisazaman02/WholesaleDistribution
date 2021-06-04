package sample;

import java.util.Date;
import java.util.Random;

/**
 * Author: Athar Bakth
 * Date: 04/17/2021
 * Group number: 7
 */

public class CustomerOrder {
    private String CustomerName;
    private int orderID = getRandomNumberInt();
    private Items[] items = new Items[5];
    private Date needbyDate;
    private Date orderDate;
    private int quantity;
    private double subtotalCost;

    public CustomerOrder(String customerName, int orderID, Items[] items, Date needbyDate, Date orderDate, int quantity, double subtotalCost) {
        CustomerName = customerName;
        this.orderID = orderID;
        this.items = items;
        this.needbyDate = needbyDate;
        this.orderDate = orderDate;
        this.quantity = quantity;
        this.subtotalCost = subtotalCost;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Items[] getItems() {
        return items;
    }

    public void setItems(Items[] items) {
        this.items = items;
    }

    public Date getNeedbyDate() {
        return needbyDate;
    }

    public void setNeedbyDate(Date needbyDate) {
        this.needbyDate = needbyDate;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotalCost() {
        return subtotalCost;
    }

    public void setSubtotalCost(double subtotalCost) {
        this.subtotalCost = subtotalCost;
    }

    private static int getRandomNumberInt() {
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        return number;
    }

}
