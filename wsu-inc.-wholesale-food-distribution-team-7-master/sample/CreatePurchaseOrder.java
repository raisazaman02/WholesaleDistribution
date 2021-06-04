package sample;
/**
 * Author: Raisa Zaman
 * Date: 03/20/2021
 * Group number: 7
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class CreatePurchaseOrder  implements DataStorage {
    private JFrame window = new JFrame("Purchase Order Page");
    String [] items;
    Random rnd = new Random();
    int number = rnd.nextInt(999999);
    private JPanel rootpanel;
    private JButton submitButton;
    private JTextField purchaseID;
    private JButton addItemButton;
    private JComboBox itemCombo;
    private DefaultListModel purchase = new DefaultListModel();

    public void setWindow(){
        window.setContentPane(rootpanel);
        window.pack();
        window.setSize(500, 500);
        window.setVisible(true);
    }
    public CreatePurchaseOrder(PurchaseOrder purchaseOrder) {
        purchaseID.setText(String.format("%06d", number));
        purchaseID.setEditable(false);
        purchaseOrder.setPurchaseID(String.format("%06d", number));
        String[] content = new String[ItemList.size()];
        for (int x  =0; x < ItemList.size(); x++){
                content[x] = ItemList.get(x).getFullName();
        }
        ComboBoxModel<String> model = itemCombo.getModel();

        if (model instanceof DefaultComboBoxModel) {
            DefaultComboBoxModel dcbm = (DefaultComboBoxModel) model;
            dcbm.removeAllElements();
            for (String value : content) {
                dcbm.addElement(value);
            }
        }
        addItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(itemCombo.getSelectedItem());
                if (itemCombo.getSelectedItem() == null){
                    JOptionPane.showMessageDialog(null,
                            "Please enter at least one item.");
                    return;
                }
                if (itemCombo.getSelectedItem().equals("Select")){
                    JOptionPane.showMessageDialog(null,
                            "Please enter at least one item.");
                    return;
                }
                for (int i =0; i < ItemList.size(); i++){
                    if (itemCombo.getSelectedItem().equals(ItemList.get(i).getFullName())){
                        if (ItemList.get(i).getItemQuantity() <= 0){
                            JOptionPane.showMessageDialog(null,
                                    "Sorry, "+ itemCombo.getSelectedItem() + " is currently out of stock.");
                            return;
                        }
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                        LocalDateTime now = LocalDateTime.now();
                        System.out.println(dtf.format(now));
                        String date1 = dtf.format(now);
                        String [] date = date1.split("/");
                        System.out.println(date1);
                        System.out.println("MM " + date[0]);
                        System.out.println("DD " + date[1]);
                        System.out.println("yyyy " + date[2]);
                        String date2 = ItemList.get(i).getExpirationDate();
                        String [] datePicked = date2.split("/");
                        System.out.println(date2);
                        System.out.println("MM " + datePicked[0]);
                        System.out.println("DD " + datePicked[1]);
                        System.out.println("yyyy " + datePicked[2]);
                        int monthDifference = (Integer.valueOf(datePicked[0]) - Integer.valueOf(date[0]));
                        System.out.println("Difference of month: " + monthDifference );
                        int dayDifference = (Integer.valueOf(datePicked[1]) - Integer.valueOf(date[1]));
                        System.out.println("Difference of days: " + dayDifference );
                        int yearDifference = (Integer.valueOf(datePicked[2]) - Integer.valueOf(date[2]));
                        System.out.println("Difference of year: " + yearDifference );
                         if (yearDifference < 0){
                             JOptionPane.showMessageDialog(null,
                                     "Sorry, "+ ItemList.get(i).getFullName() + " is currently expired.");
                            return;
                        }
                        if(monthDifference < 0 && yearDifference <= 0){
                            JOptionPane.showMessageDialog(null,
                                    "Sorry, "+ ItemList.get(i).getFullName() + " is currently expired.");
                            return;
                        }
                        if(monthDifference <= 0 && yearDifference <= 0 && dayDifference < 0){
                            JOptionPane.showMessageDialog(null,
                                    "Sorry, "+ ItemList.get(i).getFullName() + " is currently expired.");
                            return;
                        }
                    }
                }
                System.out.println(purchaseOrder.getItemList().size());
                if (purchaseOrder.getItemList().size() > 4) // start with index 0
               {
                    JOptionPane.showMessageDialog(null,
                            "Sorry, you can't enter more the 5 items.");
                    return;
               }
                purchaseOrder.setItemList(String.valueOf(itemCombo.getSelectedItem()));
                addDateQuantity addDateQuantity = new addDateQuantity(purchaseOrder);
                addDateQuantity.setWindow();
                System.out.println(purchaseOrder.getItemList());
            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(purchaseOrder.getItemList());
                if (purchaseOrder.getItemList().isEmpty()){
                    JOptionPane.showMessageDialog(null,
                            "Please, added at least one item and filled in the need date and the quantity.");
                    return;
                }
                TotalPage totalPage = new TotalPage(purchaseOrder);
                totalPage.setWindow();
               // Goes to the total page
                //Calculates price of each item
                //Calculates the total --> Update the vendors balance
            }
        });
    }
}
