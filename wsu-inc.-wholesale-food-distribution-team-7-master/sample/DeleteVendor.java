package sample;
/**
 * Author: Raisa Zaman
 * Date: 03/20/2021
 * Group number: 7
 */
import sample.DataStorage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteVendor implements DataStorage {
    private JFrame window = new JFrame("Delete Vendor");
    private JPanel rootpanel;
    private JScrollPane deleteScrollPane;
    private JList Deletelist;
    private JButton deleteButton;
    private DefaultListModel vendor = new DefaultListModel();

    public void setWindow(){
        window.setContentPane(rootpanel);
        window.pack();
        window.setSize(500, VendorList.size()*35);
        window.setVisible(true);
    }
    public void initVendor(){
        System.out.println("List vendor start");
        deleteScrollPane.setViewportView(Deletelist);
        Deletelist.setModel(vendor);
        for (int i = 0; i < VendorList.size();i++)
        {
            // Add Name Text Field
            vendor.addElement("Name: " + VendorList.get(i).getFullName()
                    + ", Phone: " + VendorList.get(i).getPhoneNumber() + ", Balance:  $" + VendorList.get(i).getBalance() +", Last Balance: $"
                    + VendorList.get(i).getLastBalance() + ", Last Order: " + VendorList.get(i).getLastOrder());
        }
        System.out.println("List vendor end");
    }
    public DeleteVendor() {
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!Deletelist.isSelectionEmpty()) {
                    System.out.println("Vendor removal started");
                    Object[] options = {"OK", "CANCEL"};
                    System.out.println(Deletelist.getSelectedIndex());
                    int index = Deletelist.getSelectedIndex();
                    if (VendorList.get(index).getBalance() == 0) {
                        int answer = JOptionPane.showOptionDialog(null, "All associated invoices will be deleted. Click OK to continue", "Warning",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                                null, options, options[0]);
                        if (answer == JOptionPane.OK_OPTION) {
                            VendorList.remove(index);
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
                            window.dispose();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Please select a vendor with a balance of 0.00.");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,
                            "Please pick a vendor you would like to delete.");

                }
            }
        });
    }
}
