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
 * Updates Customer Profile Page
 */

public class profitFinder implements DataStorage {

    private JFrame f = new JFrame("Profit Page");
    private JPanel rootpanel;
    private JList ItemInfo;
    private JScrollPane ItemInfoscroll;
    private String purchaseprice;
    private String sellprice;
    private JTextField itemProfits;
    private JButton selectItemProfilebtn;
    private DefaultListModel name = new DefaultListModel();
    private int index;
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

    public profitFinder() {

        selectItemProfilebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!ItemInfo.isSelectionEmpty()) {
                    index = searchProfileInList();
                    purchaseprice = ItemList.get(index).purchasePrice();
                    sellprice = String.valueOf(ItemList.get(index).getSell());
                    double dItemProfits = (Double.parseDouble(sellprice) - Double.parseDouble(purchaseprice));
                    double dItemProfits2 = dItemProfits * ItemList.get(index).getItemQuantity();
                    JOptionPane.showMessageDialog(null,
                            "The potential profits per unit is: $" + dItemProfits + "\nThe total potential profit is: $" + dItemProfits2);
                }
                else{
                    JOptionPane.showMessageDialog(null,
                            "selection empty please choose a customer");
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

    private int searchProfileInList() {
        for (int i = 0; i < ItemList.size(); i++) {
            if(ItemList.get(i).getFullName().equals(ItemInfo.getSelectedValue())){
                return i;
            }
        }
        //if search failed returns -1
        return -1;
    }
}
