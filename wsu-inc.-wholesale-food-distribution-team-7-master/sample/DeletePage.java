package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

public class DeletePage {
    public void start() throws Exception{
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Delete Page");

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
        Label headerLabel = new Label("What vendor do you want to delete? ");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        // Add Search Vendor by ID Label
        Label deleteIDLabel = new Label("Delete by ID : ");
        gridPane.add(deleteIDLabel, 0,2);

        // Add Search Vendor by ID Field
        TextField deleteIDField = new TextField();
        deleteIDField.setPrefHeight(40);
        gridPane.add(deleteIDField, 1,2);

        // Add Search by ID Button
        Button deleteID = new Button("Delete");
        deleteID.setPrefHeight(40);
        deleteID.setDefaultButton(true);
        deleteID.setPrefWidth(100);
        gridPane.add(deleteID, 0, 3, 2, 1);
        GridPane.setHalignment(deleteID, HPos.RIGHT);
        GridPane.setMargin(deleteID, new Insets(20, 0,20,0));

        deleteID.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DeleteByIDPage DeleteByIDPage= new DeleteByIDPage();
                try {
                    if (!deleteIDField.getText().matches("\\d{6}")){
                        showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter 6 integers");
                        return;
                    }
                    DeleteByIDPage.start(Integer.valueOf(deleteIDField.getText()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // Add Search Vendor by Name Label
        Label deleteNameLabel = new Label("Delete by Name : ");
        gridPane.add(deleteNameLabel, 0,4);

        // Add Search Vendor by ID Field
        TextField deleteNameField = new TextField();
        deleteNameField.setPrefHeight(40);
        gridPane.add(deleteNameField, 1,4);

        // Add Search by ID Button
        Button deleteName = new Button("Delete");
        deleteName.setPrefHeight(40);
        deleteName.setDefaultButton(true);
        deleteName.setPrefWidth(100);
        gridPane.add(deleteName, 0, 5, 2, 1);
        GridPane.setHalignment(deleteName, HPos.RIGHT);
        GridPane.setMargin(deleteName, new Insets(20, 0,20,0));

        deleteName.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DeleteByNamePage deleteByNamePage= new DeleteByNamePage();
                try {
                    deleteByNamePage.start(String.valueOf(deleteNameField.getText()));
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
