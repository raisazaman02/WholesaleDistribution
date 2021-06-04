package sample;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: Athar Bakth
 * Date: 04/17/2021
 * Group number: 7
 */

public class CustomerInvoiceMain implements DataStorage{
    private JTextField searchNameBox;
    private JButton searchButton;
    private JPanel rootpanel;
    private JFrame f = new JFrame("Main Customer Invoice Page");

    public CustomerInvoiceMain() throws ParseException {
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(searchNameBox.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "No name inputted try again");
                }
                String name = searchNameBox.getText();
                for(int i = 0; i < CustomerList.size(); i++){
                    if(name.equals(CustomerList.get(i).getFullName())) {
                        InvoiceOrder page = new InvoiceOrder();
                        page.initOrder(CustomerList.get(i).getFullName());
                        page.setWindow();
                        f.dispose();
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null,
                        "Unable to find Customer Try again");
            }
        });
    }

    public void alertTwoOrderAvailable(){
        int counter = 0;
        for(int i =0; i < OrderList.size(); i++){
            counter++;
        }
        if(counter > 2){
            JOptionPane.showMessageDialog(null,
                    "More than 2 Customer Orders are Available!");

        }
    }

    public void setWindow(){
        f.setContentPane(rootpanel);
        f.setSize(500,500);
        f.pack();
        f.setVisible(true);
    }
    public static void main (String [] args) throws ParseException {
        CustomerInvoiceMain page = new CustomerInvoiceMain();
        page.setWindow();
        page.alertTwoOrderAvailable();
        DateFormat df = new SimpleDateFormat("MM/dd/yy");
        Date dateobj = new Date("01/01/2022");

        //no more than 5 items
        Items[] items = {
                new Items(123456, "banana", "VENDOR1", "Fruit",
                        "5", "ounces", 10, 120, "01/01/2022"),
                new Items(123457, "Apple", "VENDOR2", "Fruit",
                        "7", "ounces", 14, 100, "01/01/2022"),
                new Items(),
                new Items(),
                new Items()
        };

        Items[] items2 = {
                new Items(123458, "apricot", "VENDOR1", "Fruit",
                        "5", "ounces", 10, 120, "01/01/2022"),
                new Items(123459, "salsa", "VENDOR2", "Fruit",
                        "7", "ounces", 14, 100,"01/01/2022"),
                new Items(),
                new Items(),
                new Items()
        };

        OrderList.add(new CustomerOrder("Ibbie Shute", 123456, items,new SimpleDateFormat("MM/dd/y").parse(df.format(dateobj)) ,
                new SimpleDateFormat("MM/dd/y").parse(df.format(dateobj)), 5, 15));
        OrderList.add(new CustomerOrder("Ibbie Shute", 345678, items2, new SimpleDateFormat("MM/dd/y").parse(df.format(dateobj)),
                new SimpleDateFormat("MM/dd/y").parse(df.format(dateobj)), 5, 17));

        OrderList.add(new CustomerOrder("Nolly Verey", 234567, items, new Date(01/02/2022),
                new Date(01/02/2022), 5, 16));

        CustomerList.add(new Customer("Ibbie Shute","351 Troy Circle","North Little Rock","AR","501-496-8274"));
        CustomerList.add(new Customer("Pren Guion","7 Larry Road","Lexington","KY","859-916-6021"));
        CustomerList.add(new Customer("Liesa Werrilow","65 Eagle Crest Plaza","Jackson","MS","601-724-5177"));
        CustomerList.add(new Customer("Alessandro Batter","41 Village Pass","Huntsville","AL","256-421-5966"));
        CustomerList.add(new Customer("Nolly Verey","5 Fair Oaks Way", "Columbus","OH","740-179-6491"));
    }
}


