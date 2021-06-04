package sample;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Group: 7
 * Author: Justen Latcau
 */


public class searchItemPage implements DataStorage {
    private JFrame f = new JFrame("Search Page");
    private JPanel rootpanel;
    private JTextField searchText;
    private JButton Searchbtn;

    public searchItemPage() {
        Searchbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(searchProfile() == -1){
                    JOptionPane.showMessageDialog(null,
                            "Text box is empty ");
                }
                else if(searchProfile() == -2){
                    JOptionPane.showMessageDialog(null,
                            "Item Profile does not exist ");
                }
                else{
                    int index = searchProfile();
                    JOptionPane.showMessageDialog(null,
                            "Name: " + ItemList.get(index).getFullName() + "\n" +
                                    "Item ID: " + ItemList.get(index).getRandomNumberString() + "\n" +
                                    "Vendor ID: " +ItemList.get(index).getVendorID() + "\n" +
                                    "Item Type: " +ItemList.get(index).itemType()+ "\n" +
                                    "Purchase Price: " +ItemList.get(index).purchasePrice() + "\n" +
                                    "Item Name: " +ItemList.get(index).getFullName() + "\n" +
                                    "Sell Price: " +ItemList.get(index).getSell() + "\n" +
                                    "Item Quantity: " +ItemList.get(index).getItemQuantity() + "\n");
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

    private int searchProfile() {
        // checks for empty string
        if(this.searchText.getText().trim().equals("")){
            return -1;
        }
        String searchElement = this.searchText.getText().trim();
        for (int i = 0; i < ItemList.size(); i++) {
            if(searchElement.equals(ItemList.get(i).getFullName())){
                return i;
            }
            else if(searchElement.equals(String.valueOf(ItemList.get(i).getItemid()))) {
                return i;
            }
        }
        //if unable to find results
        return -2;
    }
}
