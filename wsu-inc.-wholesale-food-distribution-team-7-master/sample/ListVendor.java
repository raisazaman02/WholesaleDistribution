package sample;
/**
 * Author: Raisa Zaman
 * Date: 03/20/2021
 * Group number: 7
 */
import sample.DataStorage;

import javax.swing.*;

public class ListVendor  implements DataStorage {
    private JFrame window = new JFrame("list of vendors");
    private JPanel rootpanel;
    private JList vendorList;
    private JScrollPane vendorScroll;
    private DefaultListModel vendor = new DefaultListModel();

    public void setWindow(){
        window.setContentPane(rootpanel);
        window.pack();
        window.setSize(500, VendorList.size()*35);
        window.setVisible(true);
    }
    public void initVendor(){
        System.out.println("List vendor start");
        vendorScroll.setViewportView(vendorList);
        vendorList.setModel(vendor);
        for (int i = 0; i < VendorList.size();i++)
        {
            // Add Name Text Field
            vendor.addElement("Name: " + VendorList.get(i).getFullName()
                    + ", Phone: " + VendorList.get(i).getPhoneNumber() + ", Balance:  $" + VendorList.get(i).getBalance() +", Last Balance: $"
                    + VendorList.get(i).getLastBalance() + ", Last Order: " + VendorList.get(i).getLastOrder());
        }
        System.out.println("List vendor end");
    }
}
