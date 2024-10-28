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
            // Check if the result message contains the user input then display the folder name in a new window
            if(resultMessage.contains(userInput)) {
                VBox vboxTwo = new VBox(20); 
                Label createFolder = new Label("Created Folder:");
                Label folderName = new Label(userInput);
                vboxTwo.getChildren().addAll(createFolder, folderName);
                Scene sceneTwo = new Scene(vboxTwo, 400, 200);
                stage.setScene(sceneTwo);
                stage.setTitle("Folder Created");
                stage.show();


            }
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
