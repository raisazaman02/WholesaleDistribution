package sample;

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

public class UpdatePage {
    public void start() throws Exception{
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Update Page");

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

    private void addUIControls(GridPane gridPane) {
        // Add Header
        Label headerLabel = new Label("Update information here :");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        // Add Update Vendor by ID Label
        Label idUpdateLabel = new Label("Update by ID : ");
        gridPane.add(idUpdateLabel, 0,2);

        // Add Update Vendor by ID Field
        TextField idUpdateField = new TextField();
        idUpdateField.setPrefHeight(40);
        gridPane.add(idUpdateField, 1,2);

        // Add Update by ID Button
        Button updateID = new Button("Update");
        updateID.setPrefHeight(40);
        updateID.setDefaultButton(true);
        updateID.setPrefWidth(100);
        gridPane.add(updateID, 0, 3, 2, 1);
        GridPane.setHalignment(updateID, HPos.RIGHT);
        GridPane.setMargin(updateID, new Insets(20, 0,20,0));

        updateID.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UpdateByIDPage updateByIDPage= new UpdateByIDPage();
                try {
                    if (!idUpdateField.getText().matches("\\d{6}")){
                        showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter 6 integers");
                        return;
                    }
                    updateByIDPage.start(Integer.valueOf(idUpdateField.getText()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // Add update Vendor by Name Label
        Label updateNameLabel = new Label("Update by Name : ");
        gridPane.add(updateNameLabel, 0,4);

        // Add update Vendor by ID Field
        TextField updateNameField = new TextField();
        updateNameField.setPrefHeight(40);
        gridPane.add(updateNameField, 1,4);

        // Add update by ID Button
        Button updateName = new Button("Update");
        updateName.setPrefHeight(40);
        updateName.setDefaultButton(true);
        updateName.setPrefWidth(100);
        gridPane.add(updateName, 0, 5, 2, 1);
        GridPane.setHalignment(updateName, HPos.RIGHT);
        GridPane.setMargin(updateName, new Insets(20, 0,20,0));

        updateName.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UpdateByNamePage updateByNamePage= new UpdateByNamePage();
                try {
                    updateByNamePage.start(String.valueOf(updateNameField.getText()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


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
    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}
