package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.*;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class Main implements DataStorage {

    public void start() throws Exception{
        UserDataStorage userDataStorage = new UserDataStorage();


        File myObj = new File(data_path);
        if (myObj.exists()) {
            Scanner myReader = new Scanner(myObj);
            String[] vendorItems;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                vendorItems = data.split(",");
                VendorList.add(new Vendor(vendorItems[0],vendorItems[1], vendorItems[2], vendorItems[3], String.valueOf(vendorItems[4]),vendorItems[5],vendorItems[6],vendorItems[7],vendorItems[8],vendorItems[9]));
                System.out.println("Successfully read text file");

            }
        } else {
            System.out.println("The file does not exist.");
        }

        Stage primaryStage = new Stage();
        primaryStage.setTitle("Create Vendor Profile");

        // Create the registration form grid pane
        GridPane gridPane = createRegistrationFormPane();
        // Add UI controls to the registration form grid pane
        addUIControls(gridPane);

        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(gridPane, 1000, 800);
        // Set the scene in primary stage
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private GridPane createRegistrationFormPane() {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(10);

        // Set the vertical gap between rows
        gridPane.setVgap(10);

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(180, 180, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(400,400, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }

    private void addUIControls(GridPane gridPane) {
        // Add Header
        Label headerLabel = new Label("Vendor Registration Form");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        // Random number
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // Add Name Label
        Label randomNumberLabel = new Label("Unique ID : ");
        gridPane.add(randomNumberLabel, 0,1);

        // this will convert any number sequence into 6 character.
        TextField randomNumber = new TextField(String.format("%06d", number));
        randomNumber.setDisable(true);
        gridPane.add(randomNumber, 1,1);


        // Add Name Label
        Label nameLabel = new Label("Full Name : ");
        gridPane.add(nameLabel, 0,2);

        // Add Name Text Field
        TextField nameField = new TextField();
        nameField.setPrefHeight(40);
        gridPane.add(nameField, 1,2);


        // Add Address Label
        Label addressLabel = new Label("Street Address : ");
        gridPane.add(addressLabel, 0, 3);

        // Add Address Text Field
        TextField addressField = new TextField();
        addressField.setPrefHeight(40);
        gridPane.add(addressField, 1, 3);

        // Add City Label
        Label cityLabel = new Label("City : ");
        gridPane.add(cityLabel, 0, 4);

        // Add City Text Field
        TextField cityField = new TextField();
        cityField.setPrefHeight(40);
        gridPane.add(cityField, 1, 4);

        // Add State Label
        Label stateLabel = new Label("State : ");
        gridPane.add(stateLabel, 0, 5);

        // Add State Text Field
        ComboBox stateField = new ComboBox();
        stateField.getItems().addAll("Select","AL","AK","AZ","AR","CA","CO","CT","DE","FL","GA","HI","ID","IL",
                "IN","IA","KS","KY","LA","ME","MD","MA","MI","MN","MS","MO","MT","NE","NV","NH","NJ",
                "NM","NY","NC","ND","OH","OK","OR","PA","RI","SC","SD","TN","TX","UT","VT","VA","WA",
                "WV","WI","WY");
        stateField.setValue("Select");
        stateField.setPrefHeight(40);
        gridPane.add(stateField, 1, 5);

        // Add Phone Label
        Label phoneLabel = new Label("Phone : ");
        gridPane.add(phoneLabel, 0, 6);


        // Add Phone Text Field
        TextField phoneField = new TextField("xxx-xxx-xxxx");
        phoneField.setPrefHeight(40);
        gridPane.add(phoneField,1,6);


        // Add balance Label
        Label balanceLabel = new Label("Balance : ");
        gridPane.add(balanceLabel, 0, 7);


        // Add balance Text Field
        TextField balanceField = new TextField("0.0");
        balanceField.setPrefHeight(40);
        gridPane.add(balanceField,1,7);


        // Add lastPaidAmount Label
        Label lastPaidAmountLabel = new Label("last Paid Amount : ");
        gridPane.add(lastPaidAmountLabel, 0, 8);


        // Add lastPaidAmount Text Field
        TextField lastPaidAmountField = new TextField("0.0");
        lastPaidAmountField.setPrefHeight(40);
        gridPane.add(lastPaidAmountField,1,8);

        // Add date Label
        Label  dateLabel = new Label("Last order date : ");
        gridPane.add(dateLabel, 0, 9);

        // Add date Text Field
        DatePicker dateField = new DatePicker();
        dateField.setPrefHeight(40);
        gridPane.add(dateField, 1, 9);

        // Add date Label
        Label  dateTwoLabel = new Label("Seasonal discounts start date : ");
        gridPane.add(dateTwoLabel, 0, 10);

        // Add date Text Field
        DatePicker  dateTwoField = new DatePicker();
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

        // Add List Button
        Button listVendor = new Button("All Vendors");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(listVendor, 0, 11, 2, 1);
        GridPane.setHalignment(listVendor, HPos.RIGHT);
        GridPane.setMargin(listVendor, new Insets(20, 0,20,0));

        // Add Search Button
        Button searchVendor = new Button("Search Vendor");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(searchVendor, 0, 11, 2, 1);
        GridPane.setHalignment(searchVendor, HPos.LEFT);
        GridPane.setMargin(searchVendor, new Insets(20, 0,20,0));

        // Add Update Button
        Button updateVendor = new Button("Update Vendor");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(updateVendor, 0, 12, 2, 1);
        GridPane.setHalignment(updateVendor, HPos.LEFT);
        GridPane.setMargin(updateVendor, new Insets(20, 0,20,0));

        // Add Delete Button
        Button deleteVendor = new Button("Delete Vendor");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(deleteVendor, 0, 12, 2, 1);
        GridPane.setHalignment(deleteVendor, HPos.RIGHT);
        GridPane.setMargin(deleteVendor, new Insets(20, 0,20,0));

        listVendor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ListPage listPage= new ListPage();
                try {
                    listPage.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        searchVendor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SearchPage searchPage= new SearchPage();
                try {
                    searchPage.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        updateVendor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UpdatePage updatePage= new UpdatePage();
                try {
                    updatePage.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        deleteVendor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DeletePage daletePage= new DeletePage();
                try {
                    daletePage.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LocalDate date = dateField.getValue();
                LocalDate date2 = dateTwoField.getValue();
                if(nameField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your company name");
                    return;
                }
                if(nameField.getText().length() > 20) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Your company name can be at most 20");
                    return;
                }
                if(addressField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your address");
                    return;
                }
                if(addressField.getText().length() > 20) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Your address can be at most 20");
                    return;
                }
                if(cityField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your city");
                    return;
                }
                if(cityField.getText().length() > 20) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Your city name can be at most 20");
                    return;
                }
                if(stateField.getValue().equals("Select")) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your state");
                    return;
                }
                if(phoneField.getText().equals("xxx-xxx-xxxx")) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your phone using xxx-xxx-xxxx");
                    return;
                }
                if(!phoneField.getText().matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Your phone number must be formatted like this xxx-xxx-xxxx");
                    return;
                }
                if (balanceField.getText().equals(" ") ){
                    if (!balanceField.getText().matches("\\d+\\.\\d{1,2}")){
                        showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Your cost number must be formatted like this 0.00");
                        return;
                    }
                }
                if (lastPaidAmountField.getText().equals(" ")){
                    if (!lastPaidAmountField.getText().matches("\\d+\\.\\d{1,2}")){
                        showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Your cost number must be formatted like this 0.00");
                        return;
                    }
                }
                if(date == null) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter the date");
                    return;
                }
                if(date2 == null) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter the date");
                    return;
                }
                Boolean found = false;
                System.out.println(found);
                for (int i=0; i < VendorList.size(); i++){
                   if (nameField.getText().equals(VendorList.get(i).getFullName())){
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
                       System.out.println(stateField.getSelectionModel().getSelectedItem());
                        myWriter.write(System.lineSeparator() +randomNumber.getText() + "," + nameField.getText() + "," +
                                addressField.getText() + "," +  cityField.getText() + "," +
                                stateField.getSelectionModel().getSelectedItem() + "," + phoneField.getText() + "," +
                                dateField.getValue()+ "," + dateTwoField.getValue() + ","+
                                balanceField.getText() + "," + lastPaidAmountField.getText());
                        myWriter.close();
                        System.out.println("Successfully wrote to the file.");
                        Vendor vendor = new Vendor(randomNumber.getText() , nameField.getText(),
                                addressField.getText(), cityField.getText(),
                                stateField.getPromptText(),phoneField.getText(),
                                String.valueOf(dateField.getValue()), String.valueOf(dateTwoField.getValue()),
                                balanceField.getText(), lastPaidAmountField.getText());
                        VendorList.add(vendor);
                        showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Registration Successful!", "Welcome " + nameField.getText());
                        showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Insertion","Inserted Successfully");
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                }
                else
                {
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


    public static void main(String[] args) throws IOException {
        UserDataStorage userDataStorage = new UserDataStorage();


        File myObj = new File(data_path);
        if (myObj.exists()) {
            Scanner myReader = new Scanner(myObj);
            String[] vendorItems;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                vendorItems = data.split(",");
                VendorList.add(new Vendor(vendorItems[0],vendorItems[1], vendorItems[2], vendorItems[3], String.valueOf(vendorItems[4]),vendorItems[5],vendorItems[6],vendorItems[7],vendorItems[8],vendorItems[9]));
            }

        } else {
            System.out.println("The file does not exist.");
        }
    }

}
