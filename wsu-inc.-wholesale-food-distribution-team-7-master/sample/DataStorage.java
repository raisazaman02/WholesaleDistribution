package sample;

import java.util.ArrayList;
/**
 * Author: Raisa Zaman and Athar Bakth
 * Date: 03/20/2021
 * Group number: 7
 */
public interface DataStorage {
    ArrayList <Vendor> VendorList = new ArrayList<Vendor>();
    String data_path = "src/sample/data.txt";
    ArrayList<Customer> CustomerList= new ArrayList<Customer>();
    ArrayList<PurchaseOrder> PurchaseVendorList = new ArrayList<PurchaseOrder>();
    ArrayList<Items> ItemList= new ArrayList<Items>();

    ArrayList<CustomerOrder> OrderList = new ArrayList<CustomerOrder>();
    ArrayList<CustomerInvoice> InvoiceList = new ArrayList<CustomerInvoice>();
}
