package com.generator.generator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.awt.*;
import java.io.IOException;

public class BaseMainController {

    public Button confDataButton;
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension dimension = toolkit.getScreenSize();
    int width = dimension.width;
    int height = dimension.height;
    @FXML
    public void confDataButtonClicked(ActionEvent actionEvent) throws IOException {
        new SceneSwitch("/com/generator/generator/DataBaseScene.fxml",1920,1080,width,height, true,true, "ebebe");
    }
}
