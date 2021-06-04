package sample;
/**
 * Author: Raisa Zaman
 * Date: 03/20/2021
 * Group number: 7
 */
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.Window;
import sample.DataStorage;
import sample.Vendor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class UpdateVendor implements DataStorage {
    private JFrame window = new JFrame("Update vendor information");
    private JPanel rootpanel;
    private JList vendorUpdateList;
    private JScrollPane updateVendorScroll;
    private JButton updateVendor;
    private JTextField id;
    private JTextField name;
    private JTextField street;
    private JTextField city;
    private JComboBox state;
    private JTextField phone;
    private JTextField balance;
    private JTextField lastPaid;
    private JTextField lastOrder;
    private JTextField seasonalDate;
    private JButton submitUpdate;
    private int i;
    private DefaultListModel vendor = new DefaultListModel();

    public void setWindow() {
        window.setContentPane(rootpanel);
        window.pack();
        window.setSize(600, VendorList.size()*110);
        window.setVisible(true);
    }

    public void initVendor() {
        System.out.println("List vendor start");
        updateVendorScroll.setViewportView(vendorUpdateList);
        vendorUpdateList.setModel(vendor);
        for (int i = 0; i < VendorList.size();i++)
        {
            // Add Name Text Field
            vendor.addElement("Name: " + VendorList.get(i).getFullName()
                    + ", Phone: " + VendorList.get(i).getPhoneNumber() + ", Balance:  $" + VendorList.get(i).getBalance() +", Last Balance: $"
                    + VendorList.get(i).getLastBalance() + ", Last Order: " + VendorList.get(i).getLastOrder());
        }
        System.out.println("List vendor end");
    }
    private int searchProfileInList() {
        for (int i = 0; i < VendorList.size(); i++) {
            if(i == vendorUpdateList.getSelectedIndex()){
                return i;
            }
        }
        //if search failed returns -1
        return -1;
    }

    public UpdateVendor() {
        updateVendor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!vendorUpdateList.isSelectionEmpty()) {
                    i = searchProfileInList();
                    id.setText(String.valueOf(VendorList.get(i).getVendorID()));
                    id.setEditable(false);
                    name.setText(VendorList.get(i).getFullName());
                    street.setText(VendorList.get(i).getAddress());
                    city.setText(VendorList.get(i).getCity());
                    state.setSelectedItem(VendorList.get(i).getState());
                    phone.setText(VendorList.get(i).getPhoneNumber());
                    balance.setText(String.valueOf(VendorList.get(i).getBalance()));
                    lastPaid.setText(String.valueOf(VendorList.get(i).getLastBalance()));
                    lastOrder.setText(VendorList.get(i).getLastOrder());
                    seasonalDate.setText(VendorList.get(i).getSeasonalDiscount());
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Please select a vendor from the list.");
                }
            }
        });
        submitUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (name.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null,
                            "Your company name can be at most 20.");
                    return;
                }
                if (street.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null,
                            "Your address can be at most 20.");
                    return;
                }

                if (!phone.getText().matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) {
                    JOptionPane.showMessageDialog(null,
                            "Your phone number must be formatted like this xxx-xxx-xxxx.");
                    return;
                }
                if (!balance.getText().matches("\\d+\\.\\d{1,2}")) {
                    JOptionPane.showMessageDialog(null,
                            "Your phone number must be formatted like this 0.00.");
                    return;
                }
                Boolean found = false;
                System.out.println("Vendor removal started");
                        VendorList.remove(i);
                        PrintWriter myWriter = null;
                        try {
                            myWriter = new PrintWriter(new FileWriter(data_path));
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int i= 0;  i < VendorList.size(); i++){
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
                for (int i = 0; i < VendorList.size(); i++) {
                    if (name.getText().equals(VendorList.get(i).getFullName())) {
                        found = false;
                    } else {
                        found = true;
                    }
                }
                if (found == true) {

                    try {
                        myWriter = new PrintWriter(new FileWriter(data_path, true));
                        myWriter.write(System.lineSeparator() + id.getText() + "," + name.getText() + "," +
                                street.getText() + "," + city.getText() + "," +
                                state.getSelectedItem() + "," + phone.getText() + "," +
                                lastOrder.getText() + "," + seasonalDate.getText() + "," +
                                balance.getText() + "," + lastPaid.getText());
                        myWriter.close();
                        System.out.println("Successfully wrote to the file.");
                        Vendor vendor = new Vendor(id.getText(), name.getText(),
                                street.getText(), city.getText(),
                                String.valueOf(state.getSelectedItem()), phone.getText(),
                                lastOrder.getText(), seasonalDate.getText(),
                                balance.getText(), lastPaid.getText());
                        VendorList.add(vendor);
                        JOptionPane.showMessageDialog(null,
                                "Welcome" + name.getText());
                        JOptionPane.showMessageDialog(null,
                                "Inserted Successfully");
                    } catch (IOException name) {
                        System.out.println("An error occurred.");
                        name.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null,
                            "The vendor already exists.");
                }

            }
        });
    }
}
