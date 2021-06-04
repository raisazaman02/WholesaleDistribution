package sample;

import javax.swing.*;
/**
 * Group: 7
 * Author: Justen Latcau
 */

public class ItemList implements DataStorage {
    private JFrame f = new JFrame("list of Items");
    private JPanel rootpanel;
    private JList ItemName;
    private JScrollPane scrollItemName;
    private DefaultListModel name = new DefaultListModel();

    public void setWindow(){
        f.setContentPane(rootpanel);
        f.pack();
        f.setSize(500, 500);
        f.setVisible(true);
    }

    // Initialize customers and puts them on the JLIST
    public void initItem(){
        scrollItemName.setViewportView(ItemName);
        ItemName.setModel(name);
        for (int i = 0; i < ItemList.size(); i++) {
            name.addElement("Item ID: " + ItemList.get(i).getItemid() + "\n" +
                    " Item Name: " + ItemList.get(i).getFullName() + "\n" +
                    " Sell Price: " + ItemList.get(i).getSell() + "\n" +
                    " Item Quantity: " + ItemList.get(i).getItemQuantity() + "\n" + " Expiration Date: " + ItemList.get(i).getExpirationDate() + "\n");
            System.out.println("Item ID " + ItemList.get(i).getItemid());
            System.out.println(ItemList.get(i).getFullName());
        }
    }
}
