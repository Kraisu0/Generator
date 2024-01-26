package com.generator.generator;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.util.Random;

public class GeneratorController {
    @FXML
    public Label resultLabel;
    @FXML
    public TextField minTextField;
    @FXML
    public TextField maxTextField;
    @FXML
    public Pane exitButton;
    @FXML
    public Button generateButton;
    @FXML
    public Label statusLabel;

    int numGenerator(){
        int min = Integer.parseInt(minTextField.getText());
        int max = Integer.parseInt(maxTextField.getText());

        Random random = new Random();

        return random.nextInt((max - min) + 1) + min;
    }

    @FXML
    public void generateButtonClicked(ActionEvent actionEvent) {

        String result = null;

        if(maxTextField.equals(null) || minTextField.equals(null)){
            statusLabel.setText("Fill all gaps!");
        }
        else if(Integer.parseInt(minTextField.getText()) < 0){
            statusLabel.setText("Min. number must be more than 0!");
            statusLabel.setStyle("-fx-font-size: 12");
        }
        else{
            result = Integer.toString(numGenerator());
            resultLabel.setText(result);
        }
    }
}