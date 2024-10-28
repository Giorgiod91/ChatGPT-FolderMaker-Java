package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX User Input Example
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        VBox vbox = new VBox(10); // Vertical box layout with spacing
        Label instructionLabel = new Label("Enter folder names (comma separated):");
        TextField userInputField = new TextField(); // TextField for user input
        Button submitButton = new Button("Create Folders");
        Label outputLabel = new Label(); // Label to display the output

        // Set action for the button
        submitButton.setOnAction(e -> {
            String userInput = userInputField.getText(); // Get text from TextField
            String[] folders = userInput.split(","); // Split the input into folder names
            
            // Create an instance of CreateFolder and call createFolders
            CreateFolder folderCreator = new CreateFolder();
            String resultMessage = folderCreator.createFolders(folders); // Get the result message
            
            outputLabel.setText(resultMessage); // Display it in outputLabel
        });

        // Add controls to the layout
        vbox.getChildren().addAll(instructionLabel, userInputField, submitButton, outputLabel);

        Scene scene = new Scene(vbox, 400, 200); // Create a scene with the VBox layout
        stage.setScene(scene);
        stage.setTitle("Folder Creator");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
