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
import java.util.Scanner;

public class PurchaseOrderPage implements DataStorage{
    boolean found = false;
    private JFrame window = new JFrame("Purchase Order Page:");
    private JPanel rootpanel;
    private JTextField searchVendor;
    private JButton searchButton;
    private JButton viewOrders;
    PurchaseOrder purchaseOrder = new PurchaseOrder();

    public void setWindow() {
        window.setContentPane(rootpanel);
        window.pack();
        window.setSize(500, 200);
        window.setVisible(true);
    }

    public PurchaseOrderPage() throws FileNotFoundException {
        int x =0;
        for (int i = 0; i < ItemList.size();i++){
            if(ItemList.get(i).getItemQuantity() == 0){
                x ++;
            }
        }
        if (x > 2){
            JOptionPane.showMessageDialog(null,
                    "There are more then two items out of stock. Would you like move forward? ");
        }
        if(VendorList.size() == 0){
            System.out.println("Start Purchase Order");
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
        else {
            System.out.println("Start Purchase Order");
            for (int i = 0; i < VendorList.size(); i++)
            {
                System.out.println(VendorList.get(i).getFullName());
            }
        }



        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < VendorList.size(); i++) {
                    if (searchVendor.getText().equals(VendorList.get(i).getFullName())) {
                        found = true;
                        // Add Name Text Field
                        JOptionPane.showMessageDialog(null,
                                "Ready to create a purchasing order for "+ searchVendor.getText());
                        purchaseOrder.setVendorName(searchVendor.getText());
                        CreatePurchaseOrder createPurchaseOrder = new CreatePurchaseOrder(purchaseOrder);
                        createPurchaseOrder.setWindow();
                        return;
                    } else {
                        found = false;
                    }

                }
                if (found == false) {
                    JOptionPane.showMessageDialog(null,
                            "The vendor you searched for doesn't exist.");
                }
            }
        });
        viewOrders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < VendorList.size(); i++) {
                    if (searchVendor.getText().equals(VendorList.get(i).getFullName())) {
                        found = true;
                        // Add Name Text Field
                        JOptionPane.showMessageDialog(null,
                                "Here is the order list for "+ searchVendor.getText());
                        purchaseOrder.setVendorName(searchVendor.getText());
                        ListOfPurchaseOrder listOfPurchaseOrder = new ListOfPurchaseOrder(purchaseOrder);
                        listOfPurchaseOrder.setWindow();
                        return;
                    } else {
                        found = false;
                    }

                }
                if (found == false) {
                    JOptionPane.showMessageDialog(null,
                            "The vendor you searched for doesn't exist.");
                }
            }
        });
    }
}
