package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Window;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

public class UserDataStorage implements DataStorage {

    public void updateVendorID (GridPane gridPane,int id){
        System.out.println("Vendor update by id start");
        int x = 2;
        int successAdd = 0;
        for (int i = 0; i < VendorList.size();i++)
        {
            if (id == VendorList.get(i).getVendorID()) {
                successAdd = -1;

                // Add Name Label
                Label idLabel = new Label("ID : ");
                gridPane.add(idLabel, 0,1);

                // Add Name Text Field
                TextField idField = new TextField(String.valueOf(VendorList.get(i).getVendorID()));
                idField.setDisable(true);
                idField.setPrefHeight(40);
                gridPane.add(idField, 1,1);

                // Add Name Label
                Label nameLabel = new Label("Full Name : ");
                gridPane.add(nameLabel, 0,2);

                // Add Name Text Field
                TextField nameField = new TextField(VendorList.get(i).getFullName());
                nameField.setPrefHeight(40);
                gridPane.add(nameField, 1,2);


                // Add Address Label
                Label addressLabel = new Label("Street Address : ");
                gridPane.add(addressLabel, 0, 3);

                // Add Address Text Field
                TextField addressField = new TextField(VendorList.get(i).getAddress());
                addressField.setPrefHeight(40);
                gridPane.add(addressField, 1, 3);

                // Add City Label
                Label cityLabel = new Label("City : ");
                gridPane.add(cityLabel, 0, 4);

                // Add City Text Field
                TextField cityField = new TextField(VendorList.get(i).getCity());
                cityField.setPrefHeight(40);
                gridPane.add(cityField, 1, 4);

                // Add State Label
                Label stateLabel = new Label("State : ");
                gridPane.add(stateLabel, 0, 5);

                // Add State Text Field
                ComboBox stateField = new ComboBox();
                stateField.getItems().addAll(VendorList.get(i).getState(),"AL","AK","AZ","AR","CA","CO","CT","DE","FL","GA","HI","ID","IL",
                        "IN","IA","KS","KY","LA","ME","MD","MA","MI","MN","MS","MO","MT","NE","NV","NH","NJ",
                        "NM","NY","NC","ND","OH","OK","OR","PA","RI","SC","SD","TN","TX","UT","VT","VA","WA",
                        "WV","WI","WY");
                stateField.setValue(VendorList.get(i).getState());
                stateField.setPrefHeight(40);
                gridPane.add(stateField, 1, 5);

                // Add Phone Label
                Label phoneLabel = new Label("Phone : ");
                gridPane.add(phoneLabel, 0, 6);


                // Add Phone Text Field
                TextField phoneField = new TextField(VendorList.get(i).getPhoneNumber());
                phoneField.setPrefHeight(40);
                gridPane.add(phoneField,1,6);


                // Add balance Label
                Label balanceLabel = new Label("Balance : ");
                gridPane.add(balanceLabel, 0, 7);


                // Add balance Text Field
                TextField balanceField = new TextField(String.valueOf(VendorList.get(i).getBalance()));
                balanceField.setPrefHeight(40);
                gridPane.add(balanceField,1,7);


                // Add lastPaidAmount Label
                Label lastPaidAmountLabel = new Label("last Paid Amount : ");
                gridPane.add(lastPaidAmountLabel, 0, 8);


                // Add lastPaidAmount Text Field
                TextField lastPaidAmountField = new TextField(String.valueOf(VendorList.get(i).getBalance()));
                lastPaidAmountField.setPrefHeight(40);
                gridPane.add(lastPaidAmountField,1,8);

                // Add date Label
                Label  dateLabel = new Label("Last order date : ");
                gridPane.add(dateLabel, 0, 9);

                // Add date Text Field
                TextField dateField = new TextField(VendorList.get(i).getLastOrder());
                dateField.setPrefHeight(40);
                gridPane.add(dateField, 1, 9);

                // Add date Label
                Label  dateTwoLabel = new Label("Seasonal discounts start date : ");
                gridPane.add(dateTwoLabel, 0, 10);

                // Add date Text Field
                TextField  dateTwoField = new TextField(VendorList.get(i).getSeasonalDiscount());
                dateTwoField.setPrefHeight(40);
                gridPane.add(dateTwoField, 1, 10);

                // Add Submit Button
                Button submitButton = new Button("Submit");
                submitButton.setPrefHeight(40);
                submitButton.setDefaultButton(true);
                submitButton.setPrefWidth(100);
                gridPane.add(submitButton, 0, 11, 2, 1);
                GridPane.setHalignment(submitButton, HPos.CENTER);
                GridPane.setMargin(submitButton, new Insets(20, 0,20,0));

                submitButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (nameField.getText().length() > 20) {
                            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Your company name can be at most 20");
                            return;
                        }
                        if (addressField.getText().length() > 20) {
                            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Your address can be at most 20");
                            return;
                        }

                        if (!phoneField.getText().matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) {
                            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Your phone number must be formatted like this xxx-xxx-xxxx");
                            return;
                        }
                        if (!balanceField.getText().matches("\\d+\\.\\d{1,2}")) {
                            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Your phone number must be formatted like this 0.00");
                            return;
                        }
                        Boolean found = false;
                        try {
                            DeleteByID(gridPane,id);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        for (int i = 0; i < VendorList.size(); i++) {
                            if (nameField.getText().equals(VendorList.get(i).getFullName())) {
                                found = false;
                            } else {
                                found = true;
                            }
                        }
                        if (found == true) {

                            try {
                                PrintWriter myWriter = new PrintWriter(new FileWriter(data_path, true));
                                myWriter.write(System.lineSeparator() + idField.getText() + "," + nameField.getText() + "," +
                                        addressField.getText() + "," + cityField.getText() + "," +
                                        stateField.getSelectionModel().getSelectedItem() + "," + phoneField.getText() + "," +
                                        dateField.getText() + "," + dateTwoField.getText() + "," +
                                        balanceField.getText() + "," + lastPaidAmountField.getText());
                                myWriter.close();
                                System.out.println("Successfully wrote to the file.");
                                Vendor vendor = new Vendor(idField.getText(), nameField.getText(),
                                        addressField.getText(), cityField.getText(),
                                        String.valueOf(stateField.getValue()), phoneField.getText(),
                                        String.valueOf(dateField.getText()), String.valueOf(dateTwoField.getText()),
                                        balanceField.getText(), lastPaidAmountField.getText());
                                VendorList.add(vendor);
                                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Registration Successful!", "Welcome " + nameField.getText());
                                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Insertion", "Inserted Successfully");
                            } catch (IOException e) {
                                System.out.println("An error occurred.");
                                e.printStackTrace();
                            }
                        } else {
                            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "The vendor already exists");
                        }

                    }
                    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
                        Alert alert = new Alert(alertType);
                        alert.setTitle(title);
                        alert.setHeaderText(null);
                        alert.setContentText(message);
                        alert.initOwner(owner);
                        alert.show();
                    }
                });
            }

        }
        if (successAdd == 0){
            System.out.println(successAdd);
            Alert alert = new Alert(Alert.AlertType.ERROR);// line 1
            alert.setTitle("Error");// line 2
            alert.setContentText("Please enter valid ID!");// line 4

            alert.showAndWait(); // line 5

            // Add Header
            Label headerLabel = new Label("Please enter a valid vendor ID!!! ");
            headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
            gridPane.add(headerLabel, 0,2,2,1);
            GridPane.setHalignment(headerLabel, HPos.CENTER);
            GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));
        }
        System.out.println("Vendor update by id end");

    }

    public void updateVendorName(GridPane gridPane, String name) throws ParseException {
        System.out.println("Vendor update by name start");
        int x = 2;
        int successAdd = 0;
        for (int i = 0; i < VendorList.size();i++)
        {
            if (name .equals(VendorList.get(i).getFullName())) {
                successAdd = -1;

                // Add Name Label
                Label idLabel = new Label("ID : ");
                gridPane.add(idLabel, 0,1);

                // Add Name Text Field
                TextField idField = new TextField(String.valueOf(VendorList.get(i).getVendorID()));
                idField.setDisable(true);
                idField.setPrefHeight(40);
                gridPane.add(idField, 1,1);

                // Add Name Label
                Label nameLabel = new Label("Full Name : ");
                gridPane.add(nameLabel, 0,2);

                // Add Name Text Field
                TextField nameField = new TextField(VendorList.get(i).getFullName());
                nameField.setPrefHeight(40);
                gridPane.add(nameField, 1,2);


                // Add Address Label
                Label addressLabel = new Label("Street Address : ");
                gridPane.add(addressLabel, 0, 3);

                // Add Address Text Field
                TextField addressField = new TextField(VendorList.get(i).getAddress());
                addressField.setPrefHeight(40);
                gridPane.add(addressField, 1, 3);

                // Add City Label
                Label cityLabel = new Label("City : ");
                gridPane.add(cityLabel, 0, 4);

                // Add City Text Field
                TextField cityField = new TextField(VendorList.get(i).getCity());
                cityField.setPrefHeight(40);
                gridPane.add(cityField, 1, 4);

                // Add State Label
                Label stateLabel = new Label("State : ");
                gridPane.add(stateLabel, 0, 5);

                // Add State Text Field
                ComboBox stateField = new ComboBox();
                stateField.getItems().addAll(VendorList.get(i).getState(),"AL","AK","AZ","AR","CA","CO","CT","DE","FL","GA","HI","ID","IL",
                        "IN","IA","KS","KY","LA","ME","MD","MA","MI","MN","MS","MO","MT","NE","NV","NH","NJ",
                        "NM","NY","NC","ND","OH","OK","OR","PA","RI","SC","SD","TN","TX","UT","VT","VA","WA",
                        "WV","WI","WY");
                stateField.setValue(VendorList.get(i).getState());
                stateField.setPrefHeight(40);
                gridPane.add(stateField, 1, 5);

                // Add Phone Label
                Label phoneLabel = new Label("Phone : ");
                gridPane.add(phoneLabel, 0, 6);


                // Add Phone Text Field
                TextField phoneField = new TextField(VendorList.get(i).getPhoneNumber());
                phoneField.setPrefHeight(40);
                gridPane.add(phoneField,1,6);


                // Add balance Label
                Label balanceLabel = new Label("Balance : ");
                gridPane.add(balanceLabel, 0, 7);


                // Add balance Text Field
                TextField balanceField = new TextField(String.valueOf(VendorList.get(i).getBalance()));
                balanceField.setPrefHeight(40);
                gridPane.add(balanceField,1,7);


                // Add lastPaidAmount Label
                Label lastPaidAmountLabel = new Label("last Paid Amount : ");
                gridPane.add(lastPaidAmountLabel, 0, 8);


                // Add lastPaidAmount Text Field
                TextField lastPaidAmountField = new TextField(String.valueOf(VendorList.get(i).getBalance()));
                lastPaidAmountField.setPrefHeight(40);
                gridPane.add(lastPaidAmountField,1,8);

                // Add date Label
                Label  dateLabel = new Label("Last order date : ");
                gridPane.add(dateLabel, 0, 9);

                // Add date Text Field
                TextField dateField = new TextField(VendorList.get(i).getLastOrder());
                dateField.setPrefHeight(40);
                gridPane.add(dateField, 1, 9);

                // Add date Label
                Label  dateTwoLabel = new Label("Seasonal discounts start date : ");
                gridPane.add(dateTwoLabel, 0, 10);

                // Add date Text Field
                TextField  dateTwoField = new TextField(VendorList.get(i).getSeasonalDiscount());
                dateTwoField.setPrefHeight(40);
                gridPane.add(dateTwoField, 1, 10);

                // Add Submit Button
                Button submitButton = new Button("Submit");
                submitButton.setPrefHeight(40);
                submitButton.setDefaultButton(true);
                submitButton.setPrefWidth(100);
                gridPane.add(submitButton, 0, 11, 2, 1);
                GridPane.setHalignment(submitButton, HPos.CENTER);
                GridPane.setMargin(submitButton, new Insets(20, 0,20,0));

                submitButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (nameField.getText().length() > 20) {
                            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Your company name can be at most 20");
                            return;
                        }
                        if (addressField.getText().length() > 20) {
                            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Your address can be at most 20");
                            return;
                        }

                        if (!phoneField.getText().matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) {
                            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Your phone number must be formatted like this xxx-xxx-xxxx");
                            return;
                        }
                        if (!balanceField.getText().matches("\\d+\\.\\d{1,2}")) {
                            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Your phone number must be formatted like this 0.00");
                            return;
                        }
                        Boolean found = false;
                        try {
                            DeleteByName(gridPane,name);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        for (int i = 0; i < VendorList.size(); i++) {
                            if (nameField.getText().equals(VendorList.get(i).getFullName())) {
                                found = false;
                            } else {
                                found = true;
                            }
                        }
                        if (found == true) {

                            try {
                                PrintWriter myWriter = new PrintWriter(new FileWriter(data_path, true));
                                myWriter.write(System.lineSeparator() + idField.getText() + "," + nameField.getText() + "," +
                                        addressField.getText() + "," + cityField.getText() + "," +
                                        stateField.getSelectionModel().getSelectedItem()  + "," + phoneField.getText() + "," +
                                        dateField.getText() + "," + dateTwoField.getText() + "," +
                                        balanceField.getText() + "," + lastPaidAmountField.getText());
                                myWriter.close();
                                System.out.println("Successfully wrote to the file.");
                                Vendor vendor = new Vendor(idField.getText(), nameField.getText(),
                                        addressField.getText(), cityField.getText(),
                                        String.valueOf(stateField.getValue()), phoneField.getText(),
                                        String.valueOf(dateField.getText()), String.valueOf(dateTwoField.getText()),
                                        balanceField.getText(), lastPaidAmountField.getText());
                                VendorList.add(vendor);
                                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Registration Successful!", "Welcome " + nameField.getText());
                                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Insertion", "Inserted Successfully");
                            } catch (IOException e) {
                                System.out.println("An error occurred.");
                                e.printStackTrace();
                            }
                        } else {
                            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "The vendor already exists");
                        }

                    }
                    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
                        Alert alert = new Alert(alertType);
                        alert.setTitle(title);
                        alert.setHeaderText(null);
                        alert.setContentText(message);
                        alert.initOwner(owner);
                        alert.show();
                    }
                });
            }

        }
        if (successAdd == 0){
            System.out.println(successAdd);
            Alert alert = new Alert(Alert.AlertType.ERROR);// line 1
            alert.setTitle("Error");// line 2
            alert.setContentText("Please enter valid name!");// line 4

            alert.showAndWait(); // line 5

            // Add Header
            Label headerLabel = new Label("Please enter a valid vendor name!!! ");
            headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
            gridPane.add(headerLabel, 0,2,2,1);
            GridPane.setHalignment(headerLabel, HPos.CENTER);
            GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));
        }
        System.out.println("Vendor update by name end");

    }

    public void searchVendorID (GridPane gridPane,int id){
        System.out.println("Vendor search by name start");
        int found = 0;
        System.out.println(found);
        for (int i = 0; i < VendorList.size();i++)
        {
            if (id == VendorList.get(i).getVendorID()) {
                // Add Header
                Label headerLabel = new Label("Here's the vendor:  ");
                headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                gridPane.add(headerLabel, 0,0,2,1);
                GridPane.setHalignment(headerLabel, HPos.CENTER);
                GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));
                // Add Name Text Field
                TextField nameField = new TextField("Name: " + VendorList.get(i).getFullName()
                        + ", Phone: " + VendorList.get(i).getPhoneNumber() + ", Balance:  $" + VendorList.get(i).getBalance() + ", Last Balance: $"
                        + VendorList.get(i).getLastBalance() + ", Last Order: " + VendorList.get(i).getLastOrder());
                nameField.setDisable(true);
                nameField.setPrefHeight(40);
                gridPane.add(nameField, 1, 2);
                found = -1;
            }
        }
        if (found == 0){
            System.out.println(found);
            Alert alert = new Alert(Alert.AlertType.ERROR);// line 1
            alert.setTitle("Error");// line 2
            alert.setContentText("Please enter valid ID!");// line 4

            alert.showAndWait(); // line 5

            // Add Header
            Label headerLabel = new Label("Please pick a valid vendor ID!!!  ");
            headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
            gridPane.add(headerLabel, 0,0,2,1);
            GridPane.setHalignment(headerLabel, HPos.CENTER);
            GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));
        }
        System.out.println("Vendor search by name end");
    }

    public void DeleteByName (GridPane gridPane,String name) throws IOException {
        System.out.println("Vendor delete by Name start");
        for (int i = 0; i < VendorList.size();i++)
        {
            if (name.equals(VendorList.get(i).getFullName()))
            {
                VendorList.remove(i);
                PrintWriter myWriter = new PrintWriter(new FileWriter(data_path));
                for (i= 0;  i < VendorList.size(); i++){
                    if (i == 0){
                        myWriter.write(VendorList.get(i).getVendorID() + "," + VendorList.get(i).getFullName() + "," +
                                VendorList.get(i).getAddress() + "," +  VendorList.get(i).getCity() + "," +
                                VendorList.get(i).getState() + "," + VendorList.get(i).getPhoneNumber() + "," +
                                VendorList.get(i).getLastOrder()+  "," +VendorList.get(i).getSeasonalDiscount() + ","+
                                VendorList.get(i).getBalance() + "," + VendorList.get(i).getLastBalance());
                    }
                    else {
                        myWriter.write(System.lineSeparator() +VendorList.get(i).getVendorID() + "," + VendorList.get(i).getFullName() + "," +
                                VendorList.get(i).getAddress() + "," +  VendorList.get(i).getCity() + "," +
                                VendorList.get(i).getState() + "," + VendorList.get(i).getPhoneNumber() + "," +
                                VendorList.get(i).getLastOrder()+  "," +VendorList.get(i).getSeasonalDiscount() + ","+
                                VendorList.get(i).getBalance() + "," + VendorList.get(i).getLastBalance());
                    }
                }
                myWriter.close();
                System.out.println("Vendor removed");
            }

        }

        System.out.println("Vendor delete by Name end");
    }
    public void DeleteByID (GridPane gridPane,int id) throws IOException {
        System.out.println("Vendor delete by ID start");
        for (int i = 0; i < VendorList.size();i++)
        {
            if (id == VendorList.get(i).getVendorID())
            {
                VendorList.remove(i);
                PrintWriter myWriter = new PrintWriter(new FileWriter(data_path));
                for (i= 0;  i < VendorList.size(); i++){
                    if (i == 0){
                        myWriter.write(VendorList.get(i).getVendorID() + "," + VendorList.get(i).getFullName() + "," +
                                VendorList.get(i).getAddress() + "," +  VendorList.get(i).getCity() + "," +
                                VendorList.get(i).getState() + "," + VendorList.get(i).getPhoneNumber() + "," +
                                VendorList.get(i).getLastOrder()+  "," +VendorList.get(i).getSeasonalDiscount() + ","+
                                VendorList.get(i).getBalance() + "," + VendorList.get(i).getLastBalance());
                    }
                    else {
                        myWriter.write(System.lineSeparator() +VendorList.get(i).getVendorID() + "," + VendorList.get(i).getFullName() + "," +
                                VendorList.get(i).getAddress() + "," +  VendorList.get(i).getCity() + "," +
                                VendorList.get(i).getState() + "," + VendorList.get(i).getPhoneNumber() + "," +
                                VendorList.get(i).getLastOrder()+  "," +VendorList.get(i).getSeasonalDiscount() + ","+
                                VendorList.get(i).getBalance() + "," + VendorList.get(i).getLastBalance());
                    }
                }
                myWriter.close();
                System.out.println("Vendor removed");
            }

        }

        System.out.println("Vendor delete by ID end");
    }


    public void DeleteByNamePage (GridPane gridPane,String name) throws IOException {
        System.out.println("Vendor delete by Name start");
        int found = 0;
        for (int i = 0; i < VendorList.size();i++)
        {
            if (name.equals(VendorList.get(i).getFullName())&& VendorList.get(i).getBalance() == 0)
            {
                found = -1;
                // Add Header
                Label headerLabel = new Label("Here's the vendor:  ");
                headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                gridPane.add(headerLabel, 0,0,2,1);
                GridPane.setHalignment(headerLabel, HPos.CENTER);
                GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

                // Add Name Text Field
                TextField nameField = new TextField("Name: " + VendorList.get(i).getFullName()
                        + ", Phone: " + VendorList.get(i).getPhoneNumber() + ", Balance:  $" + VendorList.get(i).getBalance() +", Last Balance: $"
                        + VendorList.get(i).getLastBalance() + ", Last Order: " + VendorList.get(i).getLastOrder());
                nameField.setDisable(true);
                nameField.setPrefHeight(40);
                gridPane.add(nameField, 1,2);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);// line 1
                alert.setTitle("Confirmation");// line 2
                alert.setContentText("Are you sure you want to delete this vendor?");// line 4
                alert.showAndWait(); // line
                VendorList.remove(i);
                PrintWriter myWriter = new PrintWriter(new FileWriter(data_path));
                for (i= 0;  i < VendorList.size(); i++){
                    if (i == 0){
                        myWriter.write(VendorList.get(i).getVendorID() + "," + VendorList.get(i).getFullName() + "," +
                                VendorList.get(i).getAddress() + "," +  VendorList.get(i).getCity() + "," +
                                VendorList.get(i).getState() + "," + VendorList.get(i).getPhoneNumber() + "," +
                                VendorList.get(i).getLastOrder()+  "," +VendorList.get(i).getSeasonalDiscount() + ","+
                                VendorList.get(i).getBalance() + "," + VendorList.get(i).getLastBalance());
                    }
                   else {
                        myWriter.write(System.lineSeparator() +VendorList.get(i).getVendorID() + "," + VendorList.get(i).getFullName() + "," +
                                VendorList.get(i).getAddress() + "," +  VendorList.get(i).getCity() + "," +
                                VendorList.get(i).getState() + "," + VendorList.get(i).getPhoneNumber() + "," +
                                VendorList.get(i).getLastOrder()+  "," +VendorList.get(i).getSeasonalDiscount() + ","+
                                VendorList.get(i).getBalance() + "," + VendorList.get(i).getLastBalance());
                    }
                }
                myWriter.close();
                System.out.println("Vendor removed");
            }

        }
        if (found == 0){
            System.out.println(found);
            Alert alert = new Alert(Alert.AlertType.ERROR);// line 1
            alert.setTitle("Error");// line 2
            alert.setContentText("Please enter valid name!");// line 4

            alert.showAndWait(); // line 5

            // Add Header
            Label headerLabel = new Label("Please pick a valid vendor name!!!  ");
            headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
            gridPane.add(headerLabel, 0,0,2,1);
            GridPane.setHalignment(headerLabel, HPos.CENTER);
            GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));
        }

        System.out.println("Vendor delete by Name end");
    }

    public void listVendor (GridPane gridPane){
        System.out.println("List vendor start");
        int x = 2;
        for (int i = 0; i < VendorList.size();i++)
        {

            // Add Name Text Field
            TextField nameField = new TextField("Name: " + VendorList.get(i).getFullName()
            + ", Phone: " + VendorList.get(i).getPhoneNumber() + ", Balance:  $" + VendorList.get(i).getBalance() +", Last Balance: $"
            + VendorList.get(i).getLastBalance() + ", Last Order: " + VendorList.get(i).getLastOrder());
            nameField.setDisable(true);
            nameField.setPrefHeight(40);
            gridPane.add(nameField, 1,x);
            System.out.println(x);
            x++;
        }
        System.out.println("List vendor end");

    }

    public void DeleteByIDPage (GridPane gridPane,int id) throws IOException {
        System.out.println("Vendor delete by ID start");
        int found = 0;
        for (int i = 0; i < VendorList.size();i++)
        {
            if (id == VendorList.get(i).getVendorID() && VendorList.get(i).getBalance() == 0)
            {
                found = -1;
                // Add Header
                Label headerLabel = new Label("Here's the vendor:  ");
                headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                gridPane.add(headerLabel, 0,0,2,1);
                GridPane.setHalignment(headerLabel, HPos.CENTER);
                GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

                // Add Name Text Field
                TextField nameField = new TextField("Name: " + VendorList.get(i).getFullName()
                        + ", Phone: " + VendorList.get(i).getPhoneNumber() + ", Balance:  $" + VendorList.get(i).getBalance() +", Last Balance: $"
                        + VendorList.get(i).getLastBalance() + ", Last Order: " + VendorList.get(i).getLastOrder());
                nameField.setDisable(true);
                nameField.setPrefHeight(40);
                gridPane.add(nameField, 1,2);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);// line 1
                alert.setTitle("Confirmation");// line 2
                alert.setContentText("Are you sure you want to delete this vendor?");// line 4
                alert.showAndWait(); // line
                VendorList.remove(i);
                PrintWriter myWriter = new PrintWriter(new FileWriter(data_path));
                for (i= 0;  i < VendorList.size(); i++){
                    if (i == 0){
                        myWriter.write(VendorList.get(i).getVendorID() + "," + VendorList.get(i).getFullName() + "," +
                                VendorList.get(i).getAddress() + "," +  VendorList.get(i).getCity() + "," +
                                VendorList.get(i).getState() + "," + VendorList.get(i).getPhoneNumber() + "," +
                                VendorList.get(i).getLastOrder()+  "," +VendorList.get(i).getSeasonalDiscount() + ","+
                                VendorList.get(i).getBalance() + "," + VendorList.get(i).getLastBalance());
                    }
                    else {
                        myWriter.write(System.lineSeparator() +VendorList.get(i).getVendorID() + "," + VendorList.get(i).getFullName() + "," +
                                VendorList.get(i).getAddress() + "," +  VendorList.get(i).getCity() + "," +
                                VendorList.get(i).getState() + "," + VendorList.get(i).getPhoneNumber() + "," +
                                VendorList.get(i).getLastOrder()+  "," +VendorList.get(i).getSeasonalDiscount() + ","+
                                VendorList.get(i).getBalance() + "," + VendorList.get(i).getLastBalance());
                    }
                }
                myWriter.close();
                System.out.println("Vendor removed");
            }

        }
        if (found == 0){
            System.out.println(found);
            Alert alert = new Alert(Alert.AlertType.ERROR);// line 1
            alert.setTitle("Error");// line 2
            alert.setContentText("Please enter valid ID and make sure the balance is 0.00");// line 4

            alert.showAndWait(); // line 5

            // Add Header
            Label headerLabel = new Label("Please pick a valid vendor ID and make sure the balance is 0.00");
            headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
            gridPane.add(headerLabel, 0,0,2,1);
            GridPane.setHalignment(headerLabel, HPos.CENTER);
            GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));
        }
        System.out.println("Vendor delete by ID end");
    }

    public void searchVendorName (GridPane gridPane,String name){
        System.out.println("Vendor search by name start");
        int found = 0;
        System.out.println(found);
        for (int i = 0; i < VendorList.size();i++)
        {
            if (name.equals( VendorList.get(i).getFullName())) {
                // Add Header
                Label headerLabel = new Label("Here's the vendor:  ");
                headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                gridPane.add(headerLabel, 0,0,2,1);
                GridPane.setHalignment(headerLabel, HPos.CENTER);
                GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

                // Add Name Text Field
                TextField nameField = new TextField("Name: " + VendorList.get(i).getFullName()
                        + ", Phone: " + VendorList.get(i).getPhoneNumber() + ", Balance:  $" + VendorList.get(i).getBalance() + ", Last Balance: $"
                        + VendorList.get(i).getLastBalance() + ", Last Order: " + VendorList.get(i).getLastOrder());
                nameField.setDisable(true);
                nameField.setPrefHeight(40);
                gridPane.add(nameField, 1, 2);
                found = 1;
            }
        }
        if (found == 0){
            System.out.println(found);
            Alert alert = new Alert(Alert.AlertType.ERROR);// line 1
            alert.setTitle("Error");// line 2
            alert.setContentText("Please enter valid name!");// line 4

            alert.showAndWait(); // line 5

            // Add Header
            Label headerLabel = new Label("Please enter a valid vendor name!!! ");
            headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
            gridPane.add(headerLabel, 0,0,2,1);
            GridPane.setHalignment(headerLabel, HPos.CENTER);
            GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));
         }
        System.out.println("Vendor search by name end");
        }

}
