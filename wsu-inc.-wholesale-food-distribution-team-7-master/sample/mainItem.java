package sample;

import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;


public class mainItem implements DataStorage {
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
    private JButton searchButton;
    private JButton listButton;
    private JButton updateButton;
    private JButton profitButton;
    private DefaultListModel name = new DefaultListModel();

    public void setWindow() {
        f.setContentPane(rootpanel);
        f.pack();
        f.setSize(1500, 500);
        f.setVisible(true);
    }

    public class Database {
        ArrayList<Items> ItemList= new ArrayList<Items>();
    }

    public mainItem() {

        Random rand = new Random();
        int upperbound = 1000000;
        int lowerbound = 99999;
        int itemID = rand.nextInt(upperbound-lowerbound) + lowerbound;



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

                if(name.equals("") || type.equals("") || purchase.equals("") || unit.equals("") || sell2.equals("") || aot.equals("")){
                    JOptionPane.showMessageDialog(null,
                            " One or more field is empty");
                    return;
                }
                else
                {
                    Items newitem = new Items(name, vendorid, type, purchase, unit);
                    JOptionPane.showMessageDialog(null,
                            "Item Added!");
                    ItemList.add(newitem);
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                deleteItemPage deletepage = new deleteItemPage();
                deletepage.setWindow();
                deletepage.initItem();
            }
        });

        profitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                profitFinder profit = new profitFinder();
                profit.setWindow();
                profit.initUsers();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                searchItemPage searchitempage = new searchItemPage();
                searchitempage.setWindow();
            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                ItemList listofitems = new ItemList();
                listofitems.initItem();
                listofitems.setWindow();

            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                updateItem updatepage = new updateItem();
                updatepage.setWindow();
                updatepage.initUsers();
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


