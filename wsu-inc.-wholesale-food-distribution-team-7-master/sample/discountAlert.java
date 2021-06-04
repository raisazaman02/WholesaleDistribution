package sample;

import javax.swing.*;

public class discountAlert implements DataStorage {
    private JFrame window = new JFrame("");
    private JPanel rootpanel;
    private JList discountList;
    private JScrollPane vendorScroll;
    private DefaultListModel vendor = new DefaultListModel();

    public void setWindow() {
        window.setContentPane(rootpanel);
        window.pack();
        window.setSize(500, VendorList.size() * 35);
        window.setVisible(true);
    }

    public void initDiscount() {
        System.out.println("List of seasonal deals start");
        System.out.println(VendorList.size());
        vendorScroll.setViewportView(discountList);
        discountList.setModel(vendor);
        for (int i = 0; i < VendorList.size(); i++) {
            // Add Name Text Field
            vendor.addElement("Name: " + VendorList.get(i).getFullName()
                    + ", Discount: " + VendorList.get(i).getSeasonalDiscount());
        }
        System.out.println("List of seasonal deals end");
    }
}
