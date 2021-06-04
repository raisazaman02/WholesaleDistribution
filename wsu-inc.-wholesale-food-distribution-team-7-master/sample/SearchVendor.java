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

public class SearchVendor implements DataStorage {
    private JFrame window = new JFrame("Search vendor:");
    private JPanel rootpanel;
    private JTextField searchVendor;
    private JButton searchButton;
    private JTextField searchResults;
    private JScrollPane scrollSearch;
    boolean found = false;
    public void setWindow() {
        window.setContentPane(rootpanel);
        window.pack();
        window.setSize(500, VendorList.size()*35);
        window.setVisible(true);
    }
    public SearchVendor() {
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scrollSearch.setViewportView(searchResults);
                for (int i = 0; i < VendorList.size();i++) {
                    if (searchVendor.getText().equals(VendorList.get(i).getFullName()) || searchVendor.getText().equals(String.valueOf(VendorList.get(i).getVendorID())))
                    {
                        found = true;
                        // Add Name Text Field
                        searchResults.setText("Name: " + VendorList.get(i).getFullName()
                                + ", Phone: " + VendorList.get(i).getPhoneNumber() + ", Balance:  $" + VendorList.get(i).getBalance() + ", Last Balance: $"
                                + VendorList.get(i).getLastBalance() + ", Last Order: " + VendorList.get(i).getLastOrder());
                        return;
                    }
                    else {
                        found = false;
                    }

                }
                if (found == false){
                    JOptionPane.showMessageDialog(null,
                            "The vendor you searched for doesn't exist.");
                }
            }
        });

    }
}
