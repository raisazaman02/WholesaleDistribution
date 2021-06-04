package sample;

import sample.DataStorage;

import javax.swing.*;

/**
 * Author: Athar Bakth
 * Date: 04/17/2021
 * Group number: 7
 */

public class ListOfCustomerPage implements DataStorage {
    private JFrame f = new JFrame("list of customer");
    private JPanel rootpanel;
    private JList CustomerName;
    private JScrollPane scrollCustomerName;
    private DefaultListModel name = new DefaultListModel();

    public void setWindow(){
        f.setContentPane(rootpanel);
        f.pack();
        f.setSize(500, CustomerList.size()*35);
        f.setVisible(true);
    }

    // Initialize customers and puts them on the JLIST
    public void initCustomer(){
        scrollCustomerName.setViewportView(CustomerName);
        CustomerName.setModel(name);
        for (int i = 0; i < CustomerList.size(); i++) {
            name.addElement("Name: " + CustomerList.get(i).getFullName() + "\n" +
                    " Phone: " + CustomerList.get(i).getPhone() + "\n" +
                    " Balance: " + CustomerList.get(i).getBalance() + "\n" +
                    " Last Amount Paid: " + CustomerList.get(i).getLastPaidAmount() + "\n");
            System.out.println("Unique ID Test " + CustomerList.get(i).getCustomerid());
        }
    }
}
