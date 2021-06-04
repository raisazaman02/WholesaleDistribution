package sample;

import javax.swing.*;

public class orderList implements DataStorage {
    private JFrame f = new JFrame("List of Orders");
    private JPanel rootpanel;
    private JList<String> ItemName;
    private JScrollPane scrollItemName;
    private DefaultListModel<String> name = new DefaultListModel<>();

    public void setWindow(){
        f.setContentPane(rootpanel);
        f.pack();
        f.setSize(800, 200);
        f.setVisible(true);
    }

    // Initialize customers and puts them on the JLIST
    public void initItem(){
        scrollItemName.setViewportView(ItemName);
        ItemName.setModel(name);

            name.addElement("Item ID: " + "\n" +
                    " Item Name: " + "\n" +
                    " Sell Price: " + "\n" +
                    " Item Quantity: " + "\n" + " Exp Date: ");
    }
}
