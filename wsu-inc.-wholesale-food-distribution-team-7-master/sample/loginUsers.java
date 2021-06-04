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

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Random;

public class loginUsers extends Application {

//    @Override
//    public void start(Stage stage) throws Exception {
//
//        Stage primaryStage = new Stage();
//        primaryStage.setTitle("Login Page");
//
//        // Create the registration form grid pane
//        GridPane gridPane = createRegistrationFormPane();
//        // Add UI controls to the registration form grid pane
//        addUIControls(gridPane);
//
//        // Create a scene with registration form grid pane as the root node
//        Scene scene = new Scene(gridPane, 1000, 800);
//        // Set the scene in primary stage
//        primaryStage.setScene(scene);
//
//        primaryStage.show();
//    }
//
//    private GridPane createRegistrationFormPane() {
//        // Instantiate a new Grid Pane
//        GridPane gridPane = new GridPane();
//
//        // Position the pane at the center of the screen, both vertically and horizontally
//        gridPane.setAlignment(Pos.CENTER);
//
//        // Set a padding of 20px on each side
//        gridPane.setPadding(new Insets(40, 40, 40, 40));
//
//        // Set the horizontal gap between columns
//        gridPane.setHgap(10);
//
//        // Set the vertical gap between rows
//        gridPane.setVgap(10);
//
//        // columnOneConstraints will be applied to all the nodes placed in column one.
//        ColumnConstraints columnOneConstraints = new ColumnConstraints(180, 180, Double.MAX_VALUE);
//        columnOneConstraints.setHalignment(HPos.RIGHT);
//
//        // columnTwoConstraints will be applied to all the nodes placed in column two.
//        ColumnConstraints columnTwoConstrains = new ColumnConstraints(400,400, Double.MAX_VALUE);
//        columnTwoConstrains.setHgrow(Priority.ALWAYS);
//
//        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);
//
//        return gridPane;
//    }
//
//    private void addUIControls(GridPane gridPane) {
//        // Add Header
//        Label headerLabel = new Label("Login Page");
//        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
//        gridPane.add(headerLabel, 0, 0, 2, 1);
//        GridPane.setHalignment(headerLabel, HPos.CENTER);
//        GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));
//        // Add userType Label
//        Label userType = new Label("User Type: ");
//        gridPane.add(userType, 0, 1);
//
//        // Add userType Combo Field
//        ComboBox<String> userTypeField = new ComboBox<>();
//        userTypeField.getItems().addAll("Select", "Inventory Manager", "Purchaser", "Accountant", "Sales Person", "Owner", "System Admin");
//        userTypeField.setValue("Select");
//        userTypeField.setPrefHeight(40);
//        gridPane.add(userTypeField, 1, 1);
//        System.out.println(String.valueOf(userTypeField.getValue()));
//
//        if (userTypeField.getValue().equals("Select")) {
//            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your state");
//            return;
//        } else {
//
//            if (userTypeField.getValue().equals("Purchaser") || userTypeField.getValue().equals("Accountant") || userTypeField.getValue().equals("Sales Person")) {
//                Label welcome = new Label("Welcome " + userTypeField.getValue());
//                gridPane.add(welcome, 0, 2);
//            } else if (userTypeField.getValue().equals("Inventory Manager")) {
//
//                // Add Item Button
//                Button itemButton = new Button("See Items");
//                itemButton.setPrefHeight(40);
//                itemButton.setDefaultButton(true);
//                itemButton.setPrefWidth(100);
//                gridPane.add(itemButton, 0, 2, 2, 1);
//                GridPane.setHalignment(itemButton, HPos.RIGHT);
//                GridPane.setMargin(itemButton, new Insets(20, 0, 20, 0));
//                // See Item only ----Justen's Part
//
////            itemButton.setOnAction(new EventHandler<ActionEvent>() {
////                @Override
////                public void handle(ActionEvent event) {
////
////                    try {
////
////                    } catch (Exception e) {
////                        e.printStackTrace();
////                    }
////                }
////            });
//            } else {
//                // Add userType Label
//                Label pageType = new Label("Page Type : ");
//                gridPane.add(pageType, 0, 2);
//
//                // Add featureType Combo Field
//                ComboBox<String> featureTypeField = new ComboBox<>();
//                featureTypeField.getItems().addAll("Select", "Customer Page", "Items Page", "Vendor Page");
//                featureTypeField.setValue("Select");
//                featureTypeField.setPrefHeight(40);
//                gridPane.add(featureTypeField, 1, 2);
//
//
//            }
//
//
//        }
//    }
//
//    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
//        Alert alert = new Alert(alertType);
//        alert.setTitle(title);
//        alert.setHeaderText(null);
//        alert.setContentText(message);
//        alert.initOwner(owner);
//        alert.show();
//    }



    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Login Page");

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
        Label headerLabel = new Label("Login Page");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));


         //Add userType Label
        Label userType = new Label("User Type: ");
        gridPane.add(userType, 0, 1);

        // Add userType Combo Field
        ComboBox<String> userTypeField = new ComboBox<>();
        userTypeField.getItems().addAll("Select", "Inventory Manager", "Purchaser", "Accountant", "Sales Person", "Owner", "System Admin");
        userTypeField.setValue("Select");
        userTypeField.setPrefHeight(40);
        gridPane.add(userTypeField, 1, 1);

        // Add userType Label
                Label pageType = new Label("Page Type : ");
               gridPane.add(pageType, 0, 2);

                // Add featureType Combo Field
                ComboBox<String> featureTypeField = new ComboBox<>();
                featureTypeField.getItems().addAll("Select", "Customer Page", "Items Page", "Vendor Page");
                featureTypeField.setValue("Select");
                featureTypeField.setPrefHeight(40);
                gridPane.add(featureTypeField, 1, 2);


        // Add Submit Button
        Button submitButton = new Button("Submit");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 11, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));

//        // Add List Button
//        Button listVendor = new Button("All Vendors");
//        submitButton.setPrefHeight(40);
//        submitButton.setDefaultButton(true);
//        submitButton.setPrefWidth(100);
//        gridPane.add(listVendor, 0, 11, 2, 1);
//        GridPane.setHalignment(listVendor, HPos.RIGHT);
//        GridPane.setMargin(listVendor, new Insets(20, 0,20,0));
//
//        // Add Search Button
//        Button searchVendor = new Button("Search Vendor");
//        submitButton.setPrefHeight(40);
//        submitButton.setDefaultButton(true);
//        submitButton.setPrefWidth(100);
//        gridPane.add(searchVendor, 0, 11, 2, 1);
//        GridPane.setHalignment(searchVendor, HPos.LEFT);
//        GridPane.setMargin(searchVendor, new Insets(20, 0,20,0));
//
//        // Add Update Button
//        Button updateVendor = new Button("Update Vendor");
//        submitButton.setPrefHeight(40);
//        submitButton.setDefaultButton(true);
//        submitButton.setPrefWidth(100);
//        gridPane.add(updateVendor, 0, 12, 2, 1);
//        GridPane.setHalignment(updateVendor, HPos.LEFT);
//        GridPane.setMargin(updateVendor, new Insets(20, 0,20,0));
//
//        // Add Delete Button
//        Button deleteVendor = new Button("Delete Vendor");
//        submitButton.setPrefHeight(40);
//        submitButton.setDefaultButton(true);
//        submitButton.setPrefWidth(100);
//        gridPane.add(deleteVendor, 0, 12, 2, 1);
//        GridPane.setHalignment(deleteVendor, HPos.RIGHT);
//        GridPane.setMargin(deleteVendor, new Insets(20, 0,20,0));

//        listVendor.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                ListPage listPage= new ListPage();
//                try {
//                    listPage.start();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        searchVendor.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                SearchPage searchPage= new SearchPage();
//                try {
//                    searchPage.start();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        updateVendor.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                UpdatePage updatePage= new UpdatePage();
//                try {
//                    updatePage.start();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        deleteVendor.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                DeletePage daletePage= new DeletePage();
//                try {
//                    daletePage.start();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(userTypeField.getValue().equals("Select")) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a user type");
                    return;
                }
                else{
                    showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Login Successful!", "Welcome " + userTypeField.getValue());
                    if (userTypeField.getValue().equals( "Accountant") || userTypeField.getValue().equals("Sales Person")){
                        showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Registration Successful!", "Sorry no features are available for you at this time.");
                    }
                    else if ((userTypeField.getValue().equals(("Purchaser")) && (featureTypeField.getValue().equals("Items Page"))))
                    {
                        mainItemPurchaser eDate = new mainItemPurchaser();
                        try {
                            eDate.setWindow();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    else if ((userTypeField.getValue().equals( "Owner") || userTypeField.getValue().equals( "System Admin")) && (featureTypeField.getValue().equals("Vendor Page")))
                    {
                        discountAlert dAlert = new discountAlert();
                        try {
                            dAlert.setWindow();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    else if ((userTypeField.getValue().equals( "Owner") )&& (featureTypeField.getValue().equals("Customer Page"))){
                        profilePage customer = new profilePage();
                        try {
                            customer.setWindow();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    else if ((userTypeField.getValue().equals( "Owner") || userTypeField.getValue().equals( "System Admin")) && (featureTypeField.getValue().equals("Items Page")))
                    {
                        mainItem mainI = new mainItem();
                        try {
                            mainI.setWindow();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    else if ((userTypeField.getValue().equals( "Inventory Manager") && (featureTypeField.getValue().equals("Items Page"))))
                    {
                        mainItemInventory mainII = new mainItemInventory();
                        try {
                            mainII.setWindow();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
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
        launch(args);
    }
}
