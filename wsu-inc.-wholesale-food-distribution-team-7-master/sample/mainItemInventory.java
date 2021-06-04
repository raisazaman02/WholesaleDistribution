package sample;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Window;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
/**
 * Group: 7
 * Author: Justen Latcau
 */


public class mainItemInventory implements DataStorage {
    private JFrame f = new JFrame("list of customer");
    private JPanel rootpanel;
    private JList ItemInventory;
    private JTextField nameField;
    private JTextField priceField;
    private JTextField purchaseField;
    private JComboBox vendorComboBox;
    private JComboBox categoryComboBox;
    private JComboBox unitComboBox;
    private JTextField datePicker;
    private JTextField quantityField;
    private JButton submitButton;
    private JButton deleteButton;
    private DefaultListModel name = new DefaultListModel();

    public void setWindow() {
        f.setContentPane(rootpanel);
        f.pack();
        f.setSize(1500, 500);
        f.setVisible(true);
    }


    public mainItemInventory() {

        Random rand = new Random();
        int upperbound = 1000000;
        int lowerbound = 99999;
        int itemID = rand.nextInt(upperbound - lowerbound) + lowerbound;


        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                int ITEMID = itemID;

                String type = String.valueOf(categoryComboBox.getSelectedItem().toString());
                String purchase = purchaseField.getText();
                String unit = String.valueOf(unitComboBox.getSelectedItem().toString());
                double sell = Double.parseDouble(priceField.getText());
                String sell2 = String.valueOf(sell);
                String vendorid = String.valueOf(vendorComboBox.getSelectedItem().toString());
                String localDate = datePicker.getText();
                double amountofitems = Double.parseDouble(quantityField.getText());
                String aot = String.valueOf(amountofitems);
                String name = nameField.getText();
                Items newItems = new Items(ITEMID, name, vendorid, type, purchase, unit, sell, amountofitems, localDate);

                if (name.equals("") || type.equals("") || purchase.equals("") || unit.equals("") || sell2.equals("") || aot.equals("")) {
                    JOptionPane.showMessageDialog(null,
                            " One or more field is empty");
                    return;
                } else {
                    Items newitem = new Items(name, vendorid, type, purchase, unit);
                    JOptionPane.showMessageDialog(null,
                            "Item Added!");
                    ItemList.add(newitem);
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent event) {
                deleteItemPage deletepage = new deleteItemPage();
                deletepage.setWindow();
                deletepage.initItem();
                System.out.println("test");
            }
        });
    }
}

