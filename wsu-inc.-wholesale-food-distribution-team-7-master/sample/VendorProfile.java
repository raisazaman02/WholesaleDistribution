package sample;
/**
 * Author: Raisa Zaman
 * Date: 03/20/2021
 * Group number: 7
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;


public class VendorProfile implements DataStorage {
    JFrame window = new JFrame("Vendor Profiles ");
    // Random number
    Random rnd = new Random();
    int number = rnd.nextInt(999999);
    private JTextField id;
    private JPanel rootpanel;
    private JButton submit;
    private JButton deleteProfileButton;
    private JButton updateProfileButton;
    private JButton listOfVendorButton;
    private JComboBox state;
    private JTextField name;
    private JTextField street;
    private JTextField city;
    private JTextField phone;
    private JTextField balance;
    private JTextField lastPaid;
    private JTextField lastOrder;
    private JTextField seasonalDate;
    private JButton searchVendor;

    void setWindow() {
        window.setContentPane(rootpanel);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(400,500);
        window.setResizable(false);
        window.pack();
        window.setVisible(true);
    }

    public VendorProfile() throws FileNotFoundException {
        id.setText(String.format("%06d", number));
        id.setEditable(false);
        listOfVendorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListVendor listVendor = new ListVendor();
                listVendor.setWindow();
                listVendor.initVendor();


            }
        });
        deleteProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteVendor deleteVendor = new DeleteVendor();
                deleteVendor.setWindow();
                deleteVendor.initVendor();


            }
        });
        updateProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateVendor updateVendor = new UpdateVendor();
                updateVendor.setWindow();
                updateVendor.initVendor();


            }
        });

        searchVendor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchVendor searchVendor = new SearchVendor();
                searchVendor.setWindow();


            }
        });
        submit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(name.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Please enter your company name");
                    return;
                }
                if(name.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null,
                            "Your company name can be at most 20");
                    return;
                }
                if(street.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Please enter your address");
                    return;
                }
                if(street.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null,
                            "Your address can be at most 20");
                    return;
                }
                if(city.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Please enter your city");
                    return;
                }
                if(city.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null,
                            "Your city can be at most 20");
                    return;
                }
                if(state.getSelectedItem().equals("Select")) {
                    JOptionPane.showMessageDialog(null,
                            "Please enter your state");
                    return;
                }
                if(phone.getText().equals("xxx-xxx-xxxx")) {
                    JOptionPane.showMessageDialog(null,
                            "Please enter your phone using xxx-xxx-xxxx");
                    return;
                }
                if(!phone.getText().matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) {
                    JOptionPane.showMessageDialog(null,
                            "Your phone number must be formatted like this xxx-xxx-xxxx");
                    return;
                }
                if (balance.getText().isEmpty()){
                    balance.setText("0.00");
                }
                if (!balance.getText().isEmpty() ){
                    if (!balance.getText().matches("\\d+\\.\\d{1,2}")){
                        JOptionPane.showMessageDialog(null,
                                "Your cost number must be formatted like this 0.00");
                        return;
                    }
                }
                if (lastPaid.getText().isEmpty()){
                    lastPaid.setText("0.00");
                }
                if (!lastPaid.getText().isEmpty()){
                    if (!lastPaid.getText().matches("\\d+\\.\\d{1,2}")){
                        JOptionPane.showMessageDialog(null,
                                "Please enter your last paid balance using 0.00");
                        return;
                    }
                }
                if(lastOrder.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Please enter the last order date.");
                    return;
                }
//                if (!lastOrder.getText().matches("" +
//                        "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$"))
//                {
//                    JOptionPane.showMessageDialog(null,
//                            "Your last order date must be formatted like this dd/mm/yyyy"); // MM/DD/YYYY
//                    return;
//                }
                if (!lastOrder.getText().isEmpty()) {
                    if (lastOrder.getText().matches("" +
                            "((0?[13578]|10|12)(-|\\/)((0[0-9])|([12])" +
                            "([0-9]?)|(3[01]?))(-|\\/)((\\d{4})|(\\d{2}))|(0?[2469]" +
                            "|11)(-|\\/)((0[0-9])|([12])([0-9]?)|(3[0]?))(-|\\/)((\\d{4}|\\d{2})))")) {
                        String date2 = lastOrder.getText();
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                        LocalDateTime now = LocalDateTime.now();
                        System.out.println(dtf.format(now));
                        String date1 = dtf.format(now);
                        String [] date = date1.split("/");
                        System.out.println(date1);
                        System.out.println("MM " + date[0]);
                        System.out.println("DD " + date[1]);
                        System.out.println("yyyy " + date[2]);
                        System.out.println(date2);
                        String [] datePicked = date2.split("/");
                        System.out.println("MM " + datePicked[0]);
                        System.out.println("DD " + datePicked[1]);
                        System.out.println("yyyy " + datePicked[2]);
                        int monthDifference = (Integer.parseInt(datePicked[0]) - Integer.parseInt(date[0]));
                        System.out.println("Difference of month: " + monthDifference );
                        int dayDifference = (Integer.parseInt(datePicked[1]) - Integer.parseInt(date[1]));
                        System.out.println("Difference of days: " + dayDifference );
                        int yearDifference = (Integer.parseInt(datePicked[2]) - Integer.parseInt(date[2]));
                        System.out.println("Difference of year: " + yearDifference );
                        if (yearDifference < 0){
                            JOptionPane.showMessageDialog(null,
                                    "Please enter a date after " + date1);
                            return;
                        }
                        if(monthDifference < 0 && yearDifference <= 0){
                            JOptionPane.showMessageDialog(null,
                                    "Please enter a date after " + date1);
                            return;
                        }
                        if(monthDifference <= 0 && yearDifference <= 0 && dayDifference < 0){
                            JOptionPane.showMessageDialog(null,
                                    "Please enter a date after " + date1);
                            return;
                        }
                    }
                if(seasonalDate.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Please enter the seasonal start date.");
                    return;
                }
                if (!seasonalDate.getText().isEmpty()) {
                    if (seasonalDate.getText().matches("" +
                            "((0?[13578]|10|12)(-|\\/)((0[0-9])|([12])" +
                            "([0-9]?)|(3[01]?))(-|\\/)((\\d{4})|(\\d{2}))|(0?[2469]" +
                            "|11)(-|\\/)((0[0-9])|([12])([0-9]?)|(3[0]?))(-|\\/)((\\d{4}|\\d{2})))")) {
                        String date2 = seasonalDate.getText();
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                        LocalDateTime now = LocalDateTime.now();
                        System.out.println(dtf.format(now));
                        String date1 = dtf.format(now);
                        String [] date = date1.split("/");
                        System.out.println(date1);
                        System.out.println("MM " + date[0]);
                        System.out.println("DD " + date[1]);
                        System.out.println("yyyy " + date[2]);
                        System.out.println(date2);
                        String [] datePicked = date2.split("/");
                        System.out.println("MM " + datePicked[0]);
                        System.out.println("DD " + datePicked[1]);
                        System.out.println("yyyy " + datePicked[2]);
                        int monthDifference = (Integer.parseInt(datePicked[0]) - Integer.parseInt(date[0]));
                        System.out.println("Difference of month: " + monthDifference );
                        int dayDifference = (Integer.parseInt(datePicked[1]) - Integer.parseInt(date[1]));
                        System.out.println("Difference of days: " + dayDifference );
                        int yearDifference = (Integer.parseInt(datePicked[2]) - Integer.parseInt(date[2]));
                        System.out.println("Difference of year: " + yearDifference );
                        if (yearDifference < 0){
                            JOptionPane.showMessageDialog(null,
                                    "Please enter a date after " + date1);
                            return;
                        }
                        if(monthDifference < 0 && yearDifference <= 0){
                            JOptionPane.showMessageDialog(null,
                                    "Please enter a date after " + date1);
                            return;
                        }
                        if(monthDifference <= 0 && yearDifference <= 0 && dayDifference < 0){
                            JOptionPane.showMessageDialog(null,
                                    "Please enter a date after " + date1);
                            return;
                        }
                    }
                }
                Boolean found = false;
                System.out.println(found);
                for (int i=0; i < VendorList.size(); i++){
                    if (name.getText().equals(VendorList.get(i).getFullName())){
                        found = true;
                        System.out.println(found);
                        break;
                    }
                    else {
                        System.out.println(found);
                        found = false;
                    }
                }
                if (found == false){
                    try {
                        System.out.println(found);
                        PrintWriter myWriter = new PrintWriter(new FileWriter(data_path,true));
                        myWriter.write(MessageFormat.format("{0}{1},{2},{3},{4},{5},{6},{7},{8},{9},{10}", System.lineSeparator(), id.getText(), name.getText(), street.getText(), city.getText(), state.getSelectedItem(), phone.getText(), lastOrder.getText(), seasonalDate.getText(), balance.getText(), lastPaid.getText()));
                        myWriter.close();
                        System.out.println("Successfully wrote to the file.");
                        Vendor vendor = new Vendor(id.getText() , name.getText(),
                                street.getText(), city.getText(),
                                String.valueOf(state.getSelectedItem()),phone.getText(),
                                lastOrder.getText(), seasonalDate.getText(),
                                balance.getText(), lastPaid.getText());
                        VendorList.add(vendor);
                        if(lastOrder.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null,
                                    "Registration Successful! Welcome " + name.getText());
                            return;
                        }
                        JOptionPane.showMessageDialog(null,
                                "Insertion Inserted Successfully");
                    } catch (IOException name) {
                        System.out.println("An error occurred.");
                        name.printStackTrace();
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,
                             "The vendor already exists");
                }
            }
        }
        });
    }
}
