package sample;

import java.util.Date;
import java.util.Random;

/**
 * Author: Athar Bakth
 * Date: 04/17/2021
 * Group number: 7
 */

public class CustomerInvoice {
    private String CustomerName;
    private int invoiceID = getRandomNumberInt();
    private Date invoiceDate;
    private Date orderDate;
    private int customerOrderNumber;
    private double totalInvoiceAmount;
    private Items itemDetails;

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getCustomerOrderNumber() {
        return customerOrderNumber;
    }

    public void setCustomerOrderNumber(int customerOrderNumber) {
        this.customerOrderNumber = customerOrderNumber;
    }

    public double getTotalInvoiceAmount() {
        return totalInvoiceAmount;
    }

    public void setTotalInvoiceAmount(double totalInvoiceAmount) {
        this.totalInvoiceAmount = totalInvoiceAmount;
    }

    public Items getItemDetails() {
        return itemDetails;
    }

    public void setItemDetails(Items itemDetails) {
        this.itemDetails = itemDetails;
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
