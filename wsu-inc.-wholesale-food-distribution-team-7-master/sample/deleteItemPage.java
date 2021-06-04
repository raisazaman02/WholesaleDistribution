package sample;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Group: 7
 * Author: Justen Latcau
 */


public class deleteItemPage implements DataStorage {
    private JFrame f = new JFrame("Delete Page");
    private JButton delete;
    private JPanel rootpanel;
    private JList ItemName;
    private JScrollPane scrollItemName;
    private DefaultListModel name = new DefaultListModel();
    private DefaultListModel balance = new DefaultListModel();

    public deleteItemPage() {
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!ItemName.isSelectionEmpty()) {
                    Object[] options = {"OK", "CANCEL"};
                    System.out.println(ItemName.getSelectedIndex());
                    int index = ItemName.getSelectedIndex();
                    if (ItemList.get(index).getSell() != 0) {
                        int answer = JOptionPane.showOptionDialog(null, "All associated items will be deleted. Click OK to continue", "Warning",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                                null, options, options[0]);
                        if (answer == JOptionPane.OK_OPTION) {
                            ItemList.remove(index);
                            f.dispose();
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,
                            "selection empty please choose item");

                }
            }
        });
    }

    public void setWindow(){

        f.setContentPane(rootpanel);
        f.setSize(ItemName.getSize());
        f.pack();
        f.setVisible(true);
    }

    public void initItem(){
        scrollItemName.setViewportView(ItemName);
        ItemName.setModel(name);
        for (int i = 0; i < ItemList.size(); i++) {
            name.addElement("Item Name: " + ItemList.get(i).getFullName() + " | Sell Price: " + ItemList.get(i).getSell());
            System.out.println("Item Name: " + ItemList.get(i).getFullName() + " | Sell Price: " + ItemList.get(i).getSell());
        }
    }


}