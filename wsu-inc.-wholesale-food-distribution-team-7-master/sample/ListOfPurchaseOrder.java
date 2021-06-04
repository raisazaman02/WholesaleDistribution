package sample;
/**
 * Author: Raisa Zaman
 * Date: 03/20/2021
 * Group number: 7
 */
import javax.swing.*;

public class ListOfPurchaseOrder implements DataStorage{
    private JPanel rootPanel;
    private JList orderList;
    private JScrollPane orderScroll;

    private JFrame window = new JFrame("list of vendors");
    private DefaultListModel purchase = new DefaultListModel();

    public void setWindow(){
        window.setContentPane(rootPanel);
        window.pack();
        window.setSize(500, 100);
        window.setVisible(true);
    }
    public ListOfPurchaseOrder(PurchaseOrder purchaseOrder){
        System.out.println("List vendor start");
        orderScroll.setViewportView(orderList);
        orderList.setModel(purchase);
        for (int i =0; i < PurchaseVendorList.size(); i++){
            if(PurchaseVendorList.get(i).getVendorName().equals(purchaseOrder.getVendorName())){
                // Add Name Text Field
                System.out.println("Name: " + PurchaseVendorList.get(i).getVendorName()
                        + ", Id: " + PurchaseVendorList.get(i).getPurchaseID()+ ", List of Dates: " + PurchaseVendorList.get(i).getNeedDate() +", List of Quantities: "
                        + PurchaseVendorList.get(i).getQuantity()+ ", List Of Items: " + PurchaseVendorList.get(i).getItemList() + " , Total cost: $ "+ PurchaseVendorList.get(i).getCostOfAllItems());
                purchase.addElement("Name: " + PurchaseVendorList.get(i).getVendorName()
                        + ", Id: " + PurchaseVendorList.get(i).getPurchaseID()+ ", List of Dates: " + PurchaseVendorList.get(i).getNeedDate() +", List of Quantities: "
                        + PurchaseVendorList.get(i).getQuantity()+ ", List Of Items: " + PurchaseVendorList.get(i).getItemList() + " , Total cost: $ "+ PurchaseVendorList.get(i).getCostOfAllItems());
            }
            else {
                purchase.addElement("Vendor list is empty.");
            }
        }
        System.out.println("List vendor end");
    }
}
