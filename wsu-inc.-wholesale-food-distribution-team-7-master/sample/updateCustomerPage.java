package sample;

import sample.Customer;
import sample.DataStorage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author: Athar Bakth
 * Date: 04/17/2021
 * Group number: 7
 */

public class updateCustomerPage implements DataStorage {

    private JFrame f = new JFrame("Update Page");
    private JPanel rootpanel;
    private JList CustomerInfo;
    private JScrollPane CustomerInfoscroll;
    private JTextField fullnamebox;
    private JTextField citybox;
    private JComboBox statecombobox;
    private JTextField phonebox;
    private JTextField balancebox;
    private JTextField addressbox;
    private JTextField lastpaidamountbox;
    private JTextField lastorderdatebox;
    private JButton selectCustomerProfilebtn;
    private JButton updatebtn;
    private DefaultListModel name = new DefaultListModel();
    private int index;
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/y");

    public updateCustomerPage() {
        selectCustomerProfilebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!CustomerInfo.isSelectionEmpty()) {
                    index = searchProfileInList();
                    fullnamebox.setText(CustomerList.get(index).getFullName());
                    citybox.setText(CustomerList.get(index).getCity());
                    statecombobox.setSelectedItem(CustomerList.get(index).getState());
                    phonebox.setText(CustomerList.get(index).getPhone());
                    balancebox.setText(Double.toString(CustomerList.get(index).getBalance()));
                    addressbox.setText(CustomerList.get(index).getStreetAddress());
                    lastpaidamountbox.setText(Double.toString(CustomerList.get(index).getLastPaidAmount()));
                    if (CustomerList.get(index).getLastOrderDate() == null) {
                        lastorderdatebox.setText("");
                    } else {
                        lastorderdatebox.setText(dateFormat.format(CustomerList.get(index).getLastOrderDate()));
                    }

                }
                else{
                        JOptionPane.showMessageDialog(null,
                                "selection empty please choose a customer");
                }
            }
        });
        updatebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options = { "OK", "CANCEL" };
                String name = fullnamebox.getText();
                String city = citybox.getText();
                String state = statecombobox.getSelectedItem().toString();
                String phone = phonebox.getText();
                String balance = balancebox.getText();
                String address = addressbox.getText();
                String date = lastorderdatebox.getText();
                int customerid = CustomerList.get(index).getCustomerid();
                String lastpaidamount = lastpaidamountbox.getText();
                    int answer = JOptionPane.showOptionDialog(null,
                            "Will be overriding Please ensure fields are correct. Click OK to continue", "Warning",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                            null, options, options[0]);
                    if(answer == JOptionPane.OK_OPTION){
                        Customer updatedCustomer = new Customer();
                        updatedCustomer.setCustomerid(customerid);
                        updatedCustomer.setFullName(name);
                        updatedCustomer.setStreetAddress(address);
                        updatedCustomer.setCity(city);
                        updatedCustomer.setState(state);
                        updatedCustomer.setPhone(phone);
                        updatedCustomer.setBalance(Double.parseDouble(balance));

                        Pattern pattern = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
                        Matcher matcher = pattern.matcher(lastorderdatebox.getText());
                        if(lastorderdatebox.getText().equals(""))
                        {
                            CustomerList.remove(index);
                            CustomerList.add(updatedCustomer);
                            f.dispose();
                        }
                        else if(!matcher.matches()){
                            JOptionPane.showMessageDialog(null,
                                    "Incorrect format of date, will skip over operation.");
                            CustomerList.remove(index);
                            CustomerList.add(updatedCustomer);
                            f.dispose();
                        }
                        else{

                            try {
                                if ((new SimpleDateFormat("MM/dd/y").parse(date).after(new Date()))){
                                updatedCustomer.setLastOrderDate(new SimpleDateFormat("MM/dd/y", Locale.ENGLISH).parse(lastorderdatebox.getText()));
                                }
                                else{
                                    JOptionPane.showMessageDialog(null,
                                            "input date is past value. will skip over operation");
                                }
                            } catch (ParseException parseException) {
                                parseException.printStackTrace();
                            }
                            CustomerList.remove(index);
                            CustomerList.add(updatedCustomer);
                            f.dispose();
                        }

                    }
                }
        });
    }

    public void setWindow(){
        f.setContentPane(rootpanel);
        f.setSize(500,500);
        f.pack();
        f.setVisible(true);
    }

    public void initUsers() {
        CustomerInfoscroll.setViewportView(CustomerInfo);
        CustomerInfo.setModel(name);
        for (int i = 0; i < CustomerList.size(); i++) {
            name.addElement(CustomerList.get(i).getFullName());
        }
    }

    private int searchProfileInList() {
        for (int i = 0; i < CustomerList.size(); i++) {
            if(CustomerList.get(i).getFullName().equals(CustomerInfo.getSelectedValue())){
                return i;
            }
        }
        //if search failed returns -1
        return -1;
    }
}
