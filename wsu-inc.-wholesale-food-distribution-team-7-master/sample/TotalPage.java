package sample;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author: Raisa Zaman
 * Date: 04/13/2021
 * Group number: 7
 */

public class TotalPage implements DataStorage{
    private JPanel rootPanel;
    private JFrame window = new JFrame("Total Price Page:");
    private JTextField totalCost;
    private JList itemList;
    private JScrollPane scrol;
    private DefaultListModel cost = new DefaultListModel();

    public void setWindow() {
        window.setContentPane(rootPanel);
        window.pack();
        window.setSize(500, 200);
        window.setVisible(true);
    }

    public TotalPage(PurchaseOrder purchaseOrder){
        Double total = 0.0;
        Double price = 0.0;
        Double balance = 0.0;
        System.out.println("List vendor start");
        scrol.setViewportView(itemList);
        itemList.setModel(cost);
        System.out.println(purchaseOrder.getItemList().size());
        for (int i = 0; i < purchaseOrder.getItemList().size(); i++){
            for (int x = 0; x < ItemList.size(); x++){
                if(purchaseOrder.getItemList().get(i).equals(ItemList.get(x).getFullName())) {
                    price = Double.parseDouble(purchaseOrder.getQuantity().get(i)) * (ItemList.get(x).getSell());
                    total += price;
                    cost.addElement("price Of " + purchaseOrder.getQuantity().get(i) + " " + purchaseOrder.getItemList().get(i) + " is $" + price);
                    System.out.println("price Of " + purchaseOrder.getQuantity().get(i) + " " + purchaseOrder.getItemList().get(i) + " is $" + price);
                }

            }
            System.out.println(purchaseOrder.getItemList().get(i));
            System.out.println(purchaseOrder.getNeedDate().get(i));
            System.out.println(purchaseOrder.getQuantity().get(i));
        }
        PrintWriter myWriter = null;
        try {
            myWriter = new PrintWriter(new FileWriter(data_path));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        System.out.println("Total Price is $ " + total);
        for (int i = 0; i< VendorList.size(); i++){
            if (purchaseOrder.getVendorName().equals(VendorList.get(i).getFullName())){
                balance = VendorList.get(i).getBalance() + total;
                VendorList.get(i).setBalance(Math.round(balance*100.0)/100.0);
                System.out.println(purchaseOrder.getVendorName() + " new balance is $" +VendorList.get(i).getBalance());
            }
        }
        for (int i = 0; i < VendorList.size(); i++){
            if (i == 0){
                myWriter.write(VendorList.get(i).getVendorID() + "," + VendorList.get(i).getFullName() + "," +
                        VendorList.get(i).getAddress() + "," +  VendorList.get(i).getCity() + "," +
                        VendorList.get(i).getState() + "," + VendorList.get(i).getPhoneNumber() + "," +
                        VendorList.get(i).getLastOrder()+  "," +VendorList.get(i).getSeasonalDiscount() + ","+
                        VendorList.get(i).getBalance() + "," + VendorList.get(i).getLastBalance());
            }
            else {
                myWriter.write(System.lineSeparator() +VendorList.get(i).getVendorID() + "," + VendorList.get(i).getFullName() + "," +
                        VendorList.get(i).getAddress() + "," +  VendorList.get(i).getCity() + "," +
                        VendorList.get(i).getState() + "," + VendorList.get(i).getPhoneNumber() + "," +
                        VendorList.get(i).getLastOrder()+  "," +VendorList.get(i).getSeasonalDiscount() + ","+
                        VendorList.get(i).getBalance() + "," + VendorList.get(i).getLastBalance());
            }
        }
        myWriter.close();
        System.out.println("Vendor removed");

        totalCost.setText("$" + total);
        purchaseOrder.setCostOfAllItems(total);
        PurchaseVendorList.add(purchaseOrder);
        totalCost.setEditable(false);
        System.out.println("List vendor end");
    }
}

