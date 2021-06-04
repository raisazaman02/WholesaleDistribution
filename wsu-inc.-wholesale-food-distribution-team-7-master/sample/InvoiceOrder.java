package sample;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 * Author: Athar Bakth
 * Date: 04/17/2021
 * Group number: 7
 */

public class InvoiceOrder implements DataStorage{
    private JPanel rootpanel;
    private JList orderList;
    private JScrollPane orderListScroll;
    private JButton selectOrderBtn;
    private JTextField orderIDBox;
    private JTextField nameBox;
    private JTextField item1Box;
    private JTextField item2Box;
    private JTextField item3Box;
    private JTextField item4Box;
    private JTextField item5Box;
    private JTextField needByDatebox;
    private JTextField orderDateBox;
    private JTextField quantityBox;
    private JTextField subtotalCostBox;
    private JButton createInvoiceBtn;
    private JFrame f = new JFrame("Invoice Order Page");
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/y");
    private DefaultListModel order = new DefaultListModel();


    public InvoiceOrder() {
        orderIDBox.setEditable(false);
        nameBox.setEditable(false);
        item1Box.setEditable(false);
        item2Box.setEditable(false);
        item3Box.setEditable(false);
        item4Box.setEditable(false);
        item5Box.setEditable(false);
        needByDatebox.setEditable(false);
        orderDateBox.setEditable(false);
        quantityBox.setEditable(false);
        subtotalCostBox.setEditable(false);
        selectOrderBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!orderList.isSelectionEmpty()) {
                    for (int i = 0; i < OrderList.size(); i++) {
                        if ((int) orderList.getSelectedValue() == OrderList.get(i).getOrderID()) {
                            orderIDBox.setText(Integer.toString(OrderList.get(i).getOrderID()));
                            nameBox.setText(OrderList.get(i).getCustomerName());

                            if (OrderList.get(i).getItems()[0].getItemName() == null) {
                                item1Box.setText("1");
                            } else {
                                item1Box.setText(OrderList.get(i).getItems()[0].getItemName());
                            }

                            if (OrderList.get(i).getItems()[1].getItemName() == null) {
                                item2Box.setText("2");
                            } else {
                                item2Box.setText(OrderList.get(i).getItems()[1].getItemName());
                            }
                            //item2Box.setText(OrderList.get(i).getItems()[1].getItemName());
                            if (OrderList.get(i).getItems()[2].getItemName() == null) {
                                item3Box.setText("3");
                            } else {
                                item3Box.setText(OrderList.get(i).getItems()[2].getItemName());
                            }

                            if (OrderList.get(i).getItems()[3].getItemName() == null) {
                                item4Box.setText("4");
                            } else {
                                item4Box.setText(OrderList.get(i).getItems()[3].getItemName());
                            }

                            if (OrderList.get(i).getItems()[4].getItemName() == null) {
                                item5Box.setText("5");
                            } else {
                                item5Box.setText(OrderList.get(i).getItems()[4].getItemName());
                            }

                            needByDatebox.setText(dateFormat.format(OrderList.get(i).getNeedbyDate()));
                            orderDateBox.setText(dateFormat.format(OrderList.get(i).getOrderDate()));
                            quantityBox.setText(Integer.toString(OrderList.get(i).getQuantity()));
                            subtotalCostBox.setText(Double.toString(OrderList.get(i).getSubtotalCost()));
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Nothing is selected");
                }
            }
        });
        createInvoiceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!orderList.isSelectionEmpty()) {

                    CustomerInvoice invoice = new CustomerInvoice();
                    //get todays date
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    try {
                        invoice.setInvoiceDate(new SimpleDateFormat("MM/dd/y", Locale.ENGLISH).parse(dtf.format(now)));
                        invoice.setOrderDate(new SimpleDateFormat("MM/dd/y", Locale.ENGLISH).parse(orderDateBox.getText()));

                    } catch (ParseException parseException) {
                        parseException.printStackTrace();
                    }
                    invoice.setCustomerOrderNumber(Integer.parseInt(orderIDBox.getText()));
                    double total = totalInvoiceCost();
                    invoice.setTotalInvoiceAmount(total);

                    //updates Customer Balance Value
                    for (int i = 0; i < CustomerList.size(); i++) {
                        if (nameBox.getText().equals(CustomerList.get(i).getFullName())) {
                            CustomerList.get(i).setBalance(CustomerList.get(i).getBalance() - total);
                        }
                    }

                    for (int i = 0; i < OrderList.size(); i++) {
                        if (Integer.parseInt(orderIDBox.getText()) == OrderList.get(i).getOrderID()) {
                            JOptionPane.showMessageDialog(null,
                                    "Item Name: " + OrderList.get(i).getItems()[0].getItemName() + '\n' +
                                            "Item Quantity: " + OrderList.get(i).getItems()[0].getItemQuantity() + '\n' +
                                            "Total cost: " + OrderList.get(i).getItems()[0].getSell() + "\n \n" +

                                            "Item Name: " + OrderList.get(i).getItems()[1].getItemName() + '\n' +
                                            "Item Quantity: " + OrderList.get(i).getItems()[1].getItemQuantity() + '\n' +
                                            "Total cost: " + OrderList.get(i).getItems()[1].getSell() + "\n \n" +

                                            "Item Name: " + OrderList.get(i).getItems()[2].getItemName() + '\n' +
                                            "Item Quantity: " + OrderList.get(i).getItems()[2].getItemQuantity() + '\n' +
                                            "Total cost: " + OrderList.get(i).getItems()[2].getSell() + "\n \n" +

                                            "Item Name: " + OrderList.get(i).getItems()[3].getItemName() + '\n' +
                                            "Item Quantity: " + OrderList.get(i).getItems()[3].getItemQuantity() + '\n' +
                                            "Total cost: " + OrderList.get(i).getItems()[3].getSell() + "\n \n" +

                                            "Item Name: " + OrderList.get(i).getItems()[4].getItemName() + '\n' +
                                            "Item Quantity: " + OrderList.get(i).getItems()[4].getItemQuantity() + '\n' +
                                            "Total cost of Item: " + OrderList.get(i).getItems()[4].getSell() + "\n \n",
                                    "Invoice Detail", JOptionPane.INFORMATION_MESSAGE);
                            OrderList.remove(i);
                        }
                    }

                    InvoiceList.add(invoice);
                    
                    f.dispose();
                    System.out.println("----------------------\n Created Invoice");
                    try {
                        CustomerInvoiceMain page = new CustomerInvoiceMain();
                        page.setWindow();


                    } catch (ParseException parseException) {
                        parseException.printStackTrace();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "cannot create invoice, nothing is selected");
                }
            }
        });
    }

    private double totalInvoiceCost(){
        double price = 0;
        for(int i = 0; i < OrderList.size(); i++)
        {
            if(nameBox.getText().equals(OrderList.get(i).getCustomerName())){
                for(int j = 0; j < OrderList.get(i).getItems().length; j++)
                {
                    price += OrderList.get(i).getItems()[j].getSell();
                }
            }
        }

        return price;
    }
    public void setWindow(){
        f.setContentPane(rootpanel);
        f.setSize(500,500);
        f.pack();
        f.setVisible(true);
    }
    //fill list with Customer order from searched Customer
    public void initOrder(String name){
        orderListScroll.setViewportView(orderList);
        orderList.setModel(order);
        for (int i = 0; i < OrderList.size(); i++) {
            if(OrderList.get(i).getCustomerName().equals(name))
            {
                order.addElement(OrderList.get(i).getOrderID());
            }
        }
    }
}
