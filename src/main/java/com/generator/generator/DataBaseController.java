package com.generator.generator;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.util.Duration;
import helpz.Constants;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DataBaseController implements Initializable {
    @FXML
    public TextField addNewTextField, addNewTDescriptionTextField;
    @FXML
    public Button addButton, saveInDifrentLocationButton, removeButton, saveButton, openButton, backButton;
    @FXML
    public Label addNewStatusLabel, removeStatusLabel, saveSatatusLabel, datasLabel, openStatusLabel;
    @FXML
    public Spinner removeSpinner;
    @FXML
    public Pane addNewPane, removePane, savePane, OpenPane;
    @FXML
    private GridPane gridPane;
    public int fileCounter = 0;
    public String[][] fileDescription;
    public String filePath = "src/main/resources/Files/all_files.txt";
    public String mainFilePath = "src/main/resources/Files/";
    public String selectedFile = "";
    private Pane selectedPane;


    public void countFilesFromList(){
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int count = 0;
            String line = "";

            while ((line = reader.readLine()) != null){
                count++;
            }
            fileCounter = count;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        fileDescription = new String[fileCounter][3];
        fileDescription = loadToArray();
    }

    public String[][] loadToArray() {
        String[][] descriptionArr;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = "";

            descriptionArr = new String[fileCounter][3];
            int index = 0;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\$\\$");

                if (parts.length >= 2) {
                    descriptionArr[index] = parts;
                    index++;
                } else {
                    System.err.println("Invalid line format: " + line);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return descriptionArr;
    }

    public void loadAllData(){
        for (int i = 0; i <fileCounter; i++) {
            String fileName = fileDescription[i][0];
            Pane newDataPane = new Pane();
            Label newDataPaneTitle = new Label(fileDescription[i][1]);
            Label newDataPaneDate = new Label(fileDescription[i][2]);

            newDataPaneTitle.setLayoutX(10);
            newDataPaneDate.setLayoutX(10);
            newDataPaneTitle.setLayoutY(10);
            newDataPaneDate.setLayoutY(40);
            newDataPaneTitle.setPrefWidth(600);
            newDataPaneDate.setPrefWidth(600);
            newDataPaneTitle.setPrefHeight(30);
            newDataPaneDate.setPrefHeight(30);

            newDataPane.setOnMouseClicked(mouseEvent -> {
                selectedFile = fileName;
                OpenPane.setDisable(false);
            });

            setColors(newDataPane);

            //newMessageTitle.setFont(new Font("Consolas Bold", 36.0));

            //newMessageContent.setPadding(new Insets(40, 0, 0, 0));
            //newMessageContent.setWrapText(true); // Text wrapping

            newDataPane.getChildren().addAll(newDataPaneTitle, newDataPaneDate);

            // Add new notification to the GridPane on the appropriate row
            gridPane.add(newDataPane, 0, i);
        }

    }

    public String openFile(String fileOpenPath){
        StringBuilder content = new StringBuilder();
        int index = 2;
        content.append(index - 1).append(". ");
        try (BufferedReader reader = new BufferedReader(new FileReader(fileOpenPath))) {
            String line;
            while ((line = reader.readLine()) != null){
                content.append(line).append("\n").append(index).append(". ");
                index++;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content.toString();
    }

    void setColors(Pane newPane) {
        newPane.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000; -fx-border-width: 1");

        newPane.setOnMouseEntered(mouseEvent -> {
            if (newPane != selectedPane) {
                newPane.setStyle("-fx-background-color: #e6e6e6; -fx-border-radius: 10; -fx-border-color: #ffaa51; -fx-border-width: 3");
            }
        });

        newPane.setOnMouseExited(mouseEvent -> {
            if (newPane != selectedPane) {
                newPane.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000; -fx-border-width: 1");
            }
        });

        newPane.setOnMousePressed(mouseEvent -> {
            if (selectedPane != null) {
                // Przywróć domyślny styl dla poprzednio zaznaczonego panelu
                selectedPane.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000; -fx-border-width: 1");
            }

            // Zaznacz nowy panel
            selectedPane = newPane;

            // Zmień styl dla zaznaczonego panelu
            newPane.setStyle("-fx-background-color: #f2f2f2; -fx-border-radius: 10; -fx-border-color: #00ffe0; -fx-border-width: 3");
        });
    }

    private void statusLabelOpen2500(Label label, String text, Color color) {
        label.setText(text);
        label.setTextFill(color);
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(2500), TimeEvent -> {
                    label.setText("");
                }));
        timeline.setCycleCount(1);
        timeline.play();
    }

    public void addButtonClicked(ActionEvent actionEvent) {

    }

    public void removeButtonClicked(ActionEvent actionEvent) {
    }

    public void saveInDifrentLocationButtonClicked(ActionEvent actionEvent) {
    }

    public void saveButtonClicked(ActionEvent actionEvent) {
    }

    public void openButtonClicked(ActionEvent actionEvent) {
        String fileOpenPath = mainFilePath + selectedFile;
        String fileContent = openFile(fileOpenPath);
        datasLabel.setText(fileContent);
        statusLabelOpen2500(openStatusLabel, ("file opened correctly: " + selectedFile), Constants.Colors.GREEN);
    }

    public void backButtonClicked(ActionEvent actionEvent) throws IOException {
        new SceneSwitch("/com/generator/generator/BaseMainScene.fxml", 600, 420, 600, 400, false, false, "Datas!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        countFilesFromList();
        loadAllData();
    }
}
