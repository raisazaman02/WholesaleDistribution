package sample;

import sample.DataStorage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Author: Athar Bakth
 * Date: 04/17/2021
 * Group number: 7
 */

public class searchCustomerPage implements DataStorage {
    private JFrame f = new JFrame("Search Page");
    private JPanel rootpanel;
    private JTextField searchText;
    private JButton Searchbtn;

    public searchCustomerPage() {
        Searchbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(searchProfile() == -1){
                    JOptionPane.showMessageDialog(null,
                            "Text box is empty ");
                }
                else if(searchProfile() == -2){
                    JOptionPane.showMessageDialog(null,
                            "Customer Profile does not exist ");
                }
                else{
                    int index = searchProfile();
                    JOptionPane.showMessageDialog(null,
                            "Name: " + CustomerList.get(index).getFullName() + "\n" +
                                    "Customer ID: " + CustomerList.get(index).getCustomerid() + "\n" +
                                    "Street Address: " +CustomerList.get(index).getStreetAddress() + "\n" +
                                    "City: " +CustomerList.get(index).getCity()+ "\n" +
                                    "State: " +CustomerList.get(index).getState() + "\n" +
                                    "Phone: " +CustomerList.get(index).getPhone() + "\n" +
                                    "Balance: " +CustomerList.get(index).getBalance() + "\n" +
                                    "Last Paid Amount: " +CustomerList.get(index).getLastPaidAmount() + "\n");
                }
            }
        });
    }

    public void setWindow() {
        f.setContentPane(rootpanel);
        f.setSize(400, 500);
        f.pack();
        f.setVisible(true);
    }

    // serach CustomerLIST returns index from customerList if found
    private int searchProfile() {
        // checks for empty string
        if(this.searchText.getText().trim().equals("")){
            return -1;
        }
        String searchElement = this.searchText.getText().trim();
        for (int i = 0; i < CustomerList.size(); i++) {
            if(searchElement.equals(CustomerList.get(i).getFullName())){
                return i;
            }
            else if(searchElement.equals(String.valueOf(CustomerList.get(i).getCustomerid()))) {
                return i;
            }
        }
        //if unable to find results
        return -2;
    }
}
