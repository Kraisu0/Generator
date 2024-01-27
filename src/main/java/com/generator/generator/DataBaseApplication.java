package com.generator.generator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.awt.Dimension;
import java.awt.Toolkit;

import java.io.IOException;

public class DataBaseApplication extends Application {
    public static Stage primaryStage;
    @Override
    public void start(Stage stage) throws IOException {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();

        FXMLLoader fxmlLoader = new FXMLLoader(GeneratorApplication.class.getResource("BaseMainScene.fxml"));
        DataBaseApplication.primaryStage = stage;
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
//        Image icon = new Image(String.valueOf(DataBaseApplication.class.getResource(".png")));
//        stage.getIcons().add(icon);
        stage.setTitle("Datas!");
        stage.setScene(scene);
        stage.show();
    }

    public static void mainDB(String[] args) {
        launch();
    }
}
