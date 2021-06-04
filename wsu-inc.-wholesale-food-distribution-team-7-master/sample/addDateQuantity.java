package sample;

import javax.swing.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

/**
 * Author: Raisa Zaman
 * Date: 03/20/2021
 * Group number: 7
 */
public class addDateQuantity implements DataStorage{
    private final JFrame window = new JFrame("Item Information");
    private JPanel rootpanel;
    private JTextField Date;
    private JTextField Quantity;
    private JButton Submit;


    public void setWindow(){
        window.setContentPane(rootpanel);
        window.pack();
        window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        window.setSize(500, 200);
        window.setVisible(true);
    }

    public addDateQuantity(PurchaseOrder purchaseOrder) {
        Submit.addActionListener(e -> {
            System.out.println(Date.getText());
            System.out.println(Quantity.getText());
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            LocalDateTime now = LocalDateTime.now();
            System.out.println(dtf.format(now));
            String date1 = dtf.format(now);
            if (Date.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "Date can't be empty");
                return;
            }
            if (!Date.getText().isEmpty()) {
                if (!Date.getText().matches("" +
                        "((0?[13578]|10|12)(-|\\/)((0[0-9])|([12])" +
                        "([0-9]?)|(3[01]?))(-|\\/)((\\d{4})|(\\d{2}))|(0?[2469]" +
                        "|11)(-|\\/)((0[0-9])|([12])([0-9]?)|(3[0]?))(-|\\/)((\\d{4}|\\d{2})))")) {
                    JOptionPane.showMessageDialog(null,
                            "Please enter a date in mm/dd/yyyy");
                    return;
                }
            }
            if (!Date.getText().isEmpty()) {
                if (Date.getText().matches("" +
                        "((0?[13578]|10|12)(-|\\/)((0[0-9])|([12])" +
                        "([0-9]?)|(3[01]?))(-|\\/)((\\d{4})|(\\d{2}))|(0?[2469]" +
                        "|11)(-|\\/)((0[0-9])|([12])([0-9]?)|(3[0]?))(-|\\/)((\\d{4}|\\d{2})))")) {
                    String date2 = Date.getText();
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
            if (Quantity.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "Quantity can't be empty");
                return;
            }
            if (Double.parseDouble(Quantity.getText()) <= 0) {
                JOptionPane.showMessageDialog(null,
                        "Please enter a number greater then 0");
                return;
            }
            for (int i = 0; i < ItemList.size(); i++){
                for (int x = 0; x < purchaseOrder.getItemList().size(); i++){
                    if (purchaseOrder.getItemList().get(x).equals(ItemList.get(i).getFullName())){
                        if (Double.parseDouble(Quantity.getText())  > ItemList.get(i).getItemQuantity()) {
                            JOptionPane.showMessageDialog(null,
                                    "Please enter a number smaller than " + Quantity.getText());
                        }
                        else {
                            purchaseOrder.setDateNeed(Date.getText());
                            System.out.println("Date added to the list");
                            purchaseOrder.setQuantity(Quantity.getText());
                            ItemList.get(i).setItemQuantity(ItemList.get(i).getItemQuantity() - Double.parseDouble(Quantity.getText()));
                            System.out.println(ItemList.get(i).getFullName() + " new amount " + ItemList.get(i).getItemQuantity());
                            System.out.println("Quantity added to the list");
                            window.dispose();
                            System.out.println("Frame Closed.");

                        }
                        return;
                    }

                }
            }

        });
    }
}

