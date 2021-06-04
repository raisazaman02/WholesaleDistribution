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

public class deleteCustomerPage implements DataStorage {
    private JFrame f = new JFrame("Delete Page");
    private JButton delete;
    private JPanel rootpanel;
    private JList CustomerName;
    private JScrollPane scrollCustomerName;
    private DefaultListModel name = new DefaultListModel();
    private DefaultListModel balance = new DefaultListModel();

    public deleteCustomerPage() {
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!CustomerName.isSelectionEmpty()) {
                    Object[] options = {"OK", "CANCEL"};
                    System.out.println(CustomerName.getSelectedIndex());
                    int index = CustomerName.getSelectedIndex();
                    if (CustomerList.get(index).getBalance() == 0) {
                        int answer = JOptionPane.showOptionDialog(null, "All associated invoices will be deleted. Click OK to continue", "Warning",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                                null, options, options[0]);
                        if (answer == JOptionPane.OK_OPTION) {
                            CustomerList.remove(index);
                            f.dispose();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Balance is more than 0 Please select another Customer");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,
                            "selection empty please choose customer");

                }
            }
        });
    }

    public void setWindow(){

        f.setContentPane(rootpanel);
        f.setSize(CustomerName.getSize());
        f.pack();
        f.setVisible(true);
    }

    public void initCustomer(){
        scrollCustomerName.setViewportView(CustomerName);
        CustomerName.setModel(name);
        for (int i = 0; i < CustomerList.size(); i++) {
            name.addElement("Full Name: " + CustomerList.get(i).getFullName() + " | Balance: " + CustomerList.get(i).getBalance());
            System.out.println("Full Name: " + CustomerList.get(i).getFullName() + " | Balance: " + CustomerList.get(i).getBalance());
        }
        /*
        CustomerBalance.setModel(balance);
        for (int i = 0; i < CustomerList.size(); i++) {
            balance.addElement(CustomerList.get(i).getBalance());
        }

         */
    }


}