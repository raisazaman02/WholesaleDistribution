package sample;
/**
 * Author: Raisa Zaman
 * Date: 03/20/2021
 * Group number: 7
 */


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class loginPage implements DataStorage {

    JFrame window = new JFrame("Login Page: ");
    private JComboBox userTypeCombo;
    private JPanel rootpanel;
    private JButton gotoPageButton;
    private JComboBox pageTypeCombo;

    public static void main(String [] args) throws FileNotFoundException, ParseException {
        loginPage loginPage = new loginPage();
        loginPage.setWindow();
    }

    void setWindow() {
        window.setContentPane(rootpanel);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(400,500);
        window.setResizable(false);
        window.pack();
        window.setVisible(true);
    }

    public loginPage() throws FileNotFoundException, ParseException {
        //Test cases

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

            if(CustomerList.size() == 0) {
                CustomerList.add(new Customer("Ibbie Shute", "351 Troy Circle", "North Little Rock", "AR", "501-496-8274"));
                CustomerList.add(new Customer("Pren Guion", "7 Larry Road", "Lexington", "KY", "859-916-6021"));
                CustomerList.add(new Customer("Liesa Werrilow", "65 Eagle Crest Plaza", "Jackson", "MS", "601-724-5177"));
                CustomerList.add(new Customer("Alessandro Batter", "41 Village Pass", "Huntsville", "AL", "256-421-5966"));
                CustomerList.add(new Customer("Nolly Verey", "5 Fair Oaks Way", "Columbus", "OH", "740-179-6491"));
            }

        if (ItemList.size() == 0 ){
            ItemList.add(new Items(111111, "Apple","Vendor1", "fruits", ".99", "pound", 2, 200, "10/10/2021"));
            ItemList.add(new Items(222222, "Peach","Vendor2", "fruits", ".99", "pound", 2, 150, "01/10/2021"));
            ItemList.add(new Items(333333, "Almond Milk","Vendor1", "dairy", "1.06", "gallon", 2.50, 100, "01/10/2021"));
            ItemList.add(new Items(444444, "Eggs","Vendor2", "dairy", "1.05", "dozen", 2.50, 85, "01/10/2021"));
            ItemList.add(new Items(555555, "Coconut Water","Vendor3", "juice", "1.00", "gallon", 1.80, 75, "10/10/2021"));
            ItemList.add(new Items(666666, "Onions","Vendor4", "vegetables", "1.05", "pound", 2.50, 66, "10/10/2021"));
        }
        if (PurchaseVendorList.size() ==0){
            PurchaseVendorList.add(new PurchaseOrder("Boba", "123456", "10/21/2021", "3", "Apple", 5.97));
            PurchaseVendorList.add(new PurchaseOrder("Boba", "123457", "10/21/2021", "4", "Peach", 7.96));
        }
        if(VendorList.size() ==0 ){
            File myObj = new File(data_path);
            if (myObj.exists()) {
                Scanner myReader = new Scanner(myObj);
                String[] vendorItems;
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    vendorItems = data.split(",");
                    VendorList.add(new Vendor(vendorItems[0],vendorItems[1], vendorItems[2], vendorItems[3], String.valueOf(vendorItems[4]),vendorItems[5],vendorItems[6],vendorItems[7],vendorItems[8],vendorItems[9]));
                }
                for (int i = 0; i < VendorList.size(); i++)
                {
                    System.out.println(VendorList.get(i).getFullName());
                }

            } else {
                System.out.println("The file does not exist.");
            }
        }
        gotoPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(userTypeCombo.getSelectedItem().equals("Select")) {
                    JOptionPane.showMessageDialog(null,
                            "Please enter a user type");
                    return;
                }
                else{
                    JOptionPane.showMessageDialog(null,
                            "Login Successful! Welcome " + userTypeCombo.getSelectedItem());
                    if (userTypeCombo.getSelectedItem().equals("") || userTypeCombo.getSelectedItem().equals("Sales Person")){
                        JOptionPane.showMessageDialog(null,
                                "Registration Successful! Sorry no features are available for you at this time.");
                    }
                    else if ((userTypeCombo.getSelectedItem().equals("Owner") && (pageTypeCombo.getSelectedItem().equals("Customer Orders")))) {
                        orderList oList = new orderList();
                        try {
                            oList.setWindow();
                        } catch (Exception name) {
                            name.printStackTrace();
                        }
                    }
                    else if ((userTypeCombo.getSelectedItem().equals(("Purchaser")) && (pageTypeCombo.getSelectedItem().equals("Items Page"))))
                    {
                        mainItemPurchaser eDate = new mainItemPurchaser();
                        try {
                            eDate.setWindow();
                        } catch (Exception name) {
                            name.printStackTrace();
                        }
                    }
                    else if ((userTypeCombo.getSelectedItem().equals( "Owner") || userTypeCombo.getSelectedItem().equals( "Purchaser")) && (pageTypeCombo.getSelectedItem().equals("Vendor Page")))
                    {
                        VendorProfile vendorProfile = null;
                        try {
                            vendorProfile = new VendorProfile();
                            vendorProfile.setWindow();
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        }
                    }
                    else if ((userTypeCombo.getSelectedItem().equals( "Owner") )&& (pageTypeCombo.getSelectedItem().equals("Customer Page"))){
                        profilePage customer = new profilePage();
                        try {
                            customer.setWindow();
                        } catch (Exception name) {
                            name.printStackTrace();
                        }
                    }

                        if ((userTypeCombo.getSelectedItem().equals( "Owner") || userTypeCombo.getSelectedItem().equals( "System Admin")) && (pageTypeCombo.getSelectedItem().equals("Items Page")))
                        {
                            mainItem mainI = new mainItem();
                            try {
                                mainI.setWindow();
                            } catch (Exception name) {
                                name.printStackTrace();
                            }
                        }
                        if ((userTypeCombo.getSelectedItem().equals( "Inventory Manager") && (pageTypeCombo.getSelectedItem().equals("Items Page"))))
                        {
                            mainItemInventory mainII = new mainItemInventory();
                            try {
                                mainII.setWindow();
                            } catch (Exception name) {
                                name.printStackTrace();
                            }
                        }
                        if ((userTypeCombo.getSelectedItem().equals("Purchaser") && (pageTypeCombo.getSelectedItem().equals("Purchase Order Page"))))
                        {
                            PurchaseOrderPage purchaseOrder;
                            try {
                                purchaseOrder = new PurchaseOrderPage();
                                purchaseOrder.setWindow();
                            } catch (FileNotFoundException fileNotFoundException) {
                                fileNotFoundException.printStackTrace();
                            }
                        }

                    if ((userTypeCombo.getSelectedItem().equals("Accountant") && (pageTypeCombo.getSelectedItem().equals("Invoice Page")))){
                        CustomerInvoiceMain invoiceMain;
                        try {
                            invoiceMain = new CustomerInvoiceMain();
                            invoiceMain.setWindow();
                            invoiceMain.alertTwoOrderAvailable();
                        } catch (ParseException parseException) {
                            parseException.printStackTrace();
                        }
                    }

                    else if ((userTypeCombo.getSelectedItem().equals( "Owner") || userTypeCombo.getSelectedItem().equals( "System Admin")) && (pageTypeCombo.getSelectedItem().equals("Vendor Page"))) {
                        discountAlert dAlert = new discountAlert();
                        dAlert.setWindow();
                        dAlert.initDiscount();

                    }

                    }
                }
        });

    }

}
