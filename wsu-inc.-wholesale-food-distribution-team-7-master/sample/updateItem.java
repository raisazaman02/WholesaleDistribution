package sample;

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
 * Group: 7
 * Author: Justen Latcau
 */

public class updateItem implements DataStorage {

    private JFrame f = new JFrame("Update Page");
    private JPanel rootpanel;
    private JList ItemInfo;
    private JScrollPane ItemInfoscroll;
    private JTextField itemname;
    private JComboBox itemtype;
    private JTextField purchaseprice;
    private JComboBox unittype;
    private JTextField sellprice;
    private JComboBox vendorid;
    private JTextField itemquantity;
    private JTextField expirationdate;
    private JButton selectCustomerProfilebtn;
    private JButton updatebtn;
    private DefaultListModel name = new DefaultListModel();
    private int index;
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

    public updateItem() {

        updatebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options = { "OK", "CANCEL" };
                String name = itemname.getText();
                String type = updateItem.this.itemtype.getSelectedItem().toString();
                String purchase = purchaseprice.getText();
                String unit = updateItem.this.unittype.getSelectedItem().toString();
                String sell = sellprice.getText();
                String vendorid = updateItem.this.vendorid.getSelectedItem().toString();
                String date = expirationdate.getText();
                int itemid = ItemList.get(index).getItemid();
                String amountofitems = itemquantity.getText();
                    int answer = JOptionPane.showOptionDialog(null,
                            "Will be overriding Please ensure fields are correct. Click OK to continue", "Warning",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                            null, options, options[0]);

                    if(answer == JOptionPane.OK_OPTION && !ItemInfo.isSelectionEmpty()){
                        Items updatedItems = new Items();
                        updatedItems.setItemid(itemid);
                        updatedItems.setFullName(name);
                        updatedItems.setVendorID(vendorid);
                        updatedItems.setType(type);
                        updatedItems.setPurchasePrice(purchase);
                        updatedItems.setmeasure(unit);
                        double cellValue = 0.0;
                        try {
                            cellValue = Double.parseDouble(sell);
                        }
                        catch(NumberFormatException event) {
                        }
                        updatedItems.setSell(cellValue);

                        Pattern pattern = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
                        Matcher matcher = pattern.matcher(expirationdate.getText());
                        if(expirationdate.getText().equals(""))
                        {
                            ItemList.remove(index);
                            ItemList.add(updatedItems);
                            f.dispose();
                        }
                        else if(!matcher.matches()){
                            JOptionPane.showMessageDialog(null,
                                    "Incorrect format of date, will skip over operation.");
                            ItemList.remove(index);
                            ItemList.add(updatedItems);
                            f.dispose();
                        }
                        else {

                            try {
                                if ((new SimpleDateFormat("MM/dd/yyyy").parse(date).after(new Date()))){
                                updatedItems.setExpirationDate(String.valueOf(new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH).parse(expirationdate.getText())));
                                }
                                else{
                                    JOptionPane.showMessageDialog(null,
                                            "input date is past value. will skip over operation");
                                }
                            } catch (ParseException parseException) {
                                parseException.printStackTrace();
                            }
                            ItemList.remove(index);
                            ItemList.add(updatedItems);
                            f.dispose();
                        }
                    }
                    else if(answer == JOptionPane.OK_OPTION && !ItemInfo.isSelectionEmpty()){
                        JOptionPane.showMessageDialog(null,
                                "Selection empty please choose item");
                    }

                else {
                    JOptionPane.showMessageDialog(null,
                                "Input Cancelled");
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
        ItemInfoscroll.setViewportView(ItemInfo);
        ItemInfo.setModel(name);
        for (int i = 0; i < ItemList.size(); i++) {
            name.addElement(ItemList.get(i).getFullName());
        }
    }

}
