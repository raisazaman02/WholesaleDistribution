package sample;

import javax.swing.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author: Athar Bakth
 * Date: 04/17/2021
 * Group number: 7
 */

public class profilePage implements DataStorage {
    private JFrame f = new JFrame("Customer Profiles ");
    private JTextField fullName;
    private JTextField streetAddress;
    private JTextField city;
    private JTextField phone;
    private JButton createProfile;
    private JButton deleteProfileButton;
    private JButton updateProfileButton;
    private JButton searchCustomerProfileButton;
    private JButton listOfCustomersButton;
    private JButton emptyButtonButton;
    private JPanel rootpanel;
    private JComboBox state;

    public void setWindow(){
        f.setContentPane(rootpanel);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400,500);
        f.setResizable(false);
        f.pack();
        f.setVisible(true);
    }
    // public Customer(String fullName, String streetAddress, String city, String state, int phone)

    /** TODO:
     * Check for duplicate Full names
     *  UPdate profile
     *
     */
    public profilePage() {

        //hard code add when page object is created
        CustomerList.add(new Customer("Ibbie Shute","351 Troy Circle","North Little Rock","AR","501-496-8274"));
        CustomerList.add(new Customer("Pren Guion","7 Larry Road","Lexington","KY","859-916-6021"));
        CustomerList.add(new Customer("Liesa Werrilow","65 Eagle Crest Plaza","Jackson","MS","601-724-5177"));
        CustomerList.add(new Customer("Alessandro Batter","41 Village Pass","Huntsville","AL","256-421-5966"));
        CustomerList.add(new Customer("Nolly Verey","5 Fair Oaks Way", "Columbus","OH","740-179-6491"));

        createProfile.addActionListener(new ActionListener() {
            int i = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = fullName.getText();
                String street = streetAddress.getText();
                String State = state.getSelectedItem().toString();
                String Phone = phone.getText();
                String City = city.getText();

                Pattern pattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
                Matcher matcher = pattern.matcher(phone.getText());

                if(name.equals("") || street.equals("") || Phone.equals("") || City.equals("")){
                    JOptionPane.showMessageDialog(null,
                            " One or more field is empty");
                    return;
                }
                // checkTextSize(int size, String textfield)
                else if(checkTextSize(20, name) == false){
                    JOptionPane.showMessageDialog(null,
                            "Name field is bigger than 20");
                    return;
                }
                else if(checkTextSize(20, State) == false){
                    JOptionPane.showMessageDialog(null,
                            "State field is bigger than 20");
                    return;
                }
                else if(checkTextSize(20, street) == false){
                    JOptionPane.showMessageDialog(null,
                            "street field is bigger than 20");
                    return;
                }
                else if(checkTextSize(20, City) == false){
                    JOptionPane.showMessageDialog(null,
                            "City field is bigger than 20");
                    return;
                }
                else if(!matcher.matches()) {
                    JOptionPane.showMessageDialog(null,
                            "Phone Number is not in correct format use: xxx-xxx-xxxx");
                    return;
                }

                else {
                    if(checkExistingName(name))
                    {
                        JOptionPane.showMessageDialog(null,
                                "Customer Already Exists try again!");
                        fullName.setText("");
                        streetAddress.setText("");
                        state.setSelectedIndex(0);
                        phone.setText("");
                        city.setText("");
                    }
                    else {
                        Customer newCustomer = new Customer(name, street, City, State, Phone);
                        JOptionPane.showMessageDialog(null,
                                "Created Customer Profile!");
                        fullName.setText("");
                        streetAddress.setText("");
                        state.setSelectedIndex(0);
                        phone.setText("");
                        city.setText("");
                        CustomerList.add(newCustomer);
                    }

                }
            }
        });
        deleteProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteCustomerPage deletepage = new deleteCustomerPage();
                deletepage.setWindow();
                deletepage.initCustomer();
                //deletepage.setDisplayBalance();
            }
        });
        updateProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCustomerPage updatepage = new updateCustomerPage();
                updatepage.setWindow();
                updatepage.initUsers();
            }
        });
        searchCustomerProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchCustomerPage searchcustomerpage = new searchCustomerPage();
                searchcustomerpage.setWindow();
            }
        });
        listOfCustomersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListOfCustomerPage listofcustomerpage = new ListOfCustomerPage();
                listofcustomerpage.setWindow();
                listofcustomerpage.initCustomer();
            }
        });

    }

    private boolean checkTextSize(int size, String text){
        if(text.length() < size + 1){
            return true;
        }
        else {

            return false;
        }
    }

    private boolean checkExistingName(String name){
        for(int i =0; i < CustomerList.size(); i++)
        {
            if(CustomerList.get(i).getFullName().equals(name))
            {
                return true;
            }
        }
        return false;
    }



    public static void main(String [] args){


        profilePage page = new profilePage();
        page.setWindow();
    }
}
