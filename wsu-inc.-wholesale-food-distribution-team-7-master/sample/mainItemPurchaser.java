package sample;

import javafx.scene.control.Alert;
import javafx.stage.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class mainItemPurchaser implements DataStorage {
    private JFrame f = new JFrame("Expired Items");
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
    private JButton submitipButton;
    private JButton deleteButton;
    private JButton searchButton;
    private JButton listButton;
    private JButton updateButton;
    private JButton profitButton;
    private DefaultListModel name = new DefaultListModel();
    private int index;
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

    public void setWindow() {
        f.setContentPane(rootpanel);
        f.pack();
        f.setSize(500, 100);
        f.setVisible(true);
    }

    public class Database {
        ArrayList<Items> ItemList= new ArrayList<Items>();
    }

    public mainItemPurchaser() {

        Random rand = new Random();
        int upperbound = 1000000;
        int lowerbound = 99999;
        int itemID = rand.nextInt(upperbound-lowerbound) + lowerbound;
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = dateFormat.parse("04/19/2021");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(ItemList.size());
        for (int i = 0; i < ItemList.size(); i++) {
            String expDate = ItemList.get(i).getExpirationDate();
            System.out.println(d1);
                try {
                    d2 = dateFormat.parse(expDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (d2.compareTo(d1) > 0) {
                    ItemList.remove(i);
                //System.out.println("Item ID " + ItemList.get(i).getItemid());
                //System.out.println(ItemList.get(i).getFullName());
                System.out.println(d2);
                System.out.println(d1);
            }
        }

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                ItemList listofitems = new ItemList();
                listofitems.initItem();
                listofitems.setWindow();
            }
        });
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public static void main(String[] args) {
        ItemList.add(new Items("apple", "Vendor1", "fruit", "1", "pounds"));
    }
}
