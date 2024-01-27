package com.generator.generator;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import java.io.IOException;
import java.net.URL;

public class SceneSwitch {
    public SceneSwitch(String newFxmlScene) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(newFxmlScene));
        Scene scene = new Scene(fxmlLoader.load(), DataBaseApplication.primaryStage.getWidth(), DataBaseApplication.primaryStage.getHeight());
        DataBaseApplication.primaryStage.setScene(scene);
    }

    public SceneSwitch(String newFxmlScene, int width, int height, boolean ifMaximized, boolean ifResizable) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(newFxmlScene));
        Scene scene = new Scene(fxmlLoader.load(), width, height);
        DataBaseApplication.primaryStage.setScene(scene);
        DataBaseApplication.primaryStage.setMaximized(ifMaximized); // Fullscreen in window if true
        DataBaseApplication.primaryStage.setResizable(ifResizable);
    }

    public SceneSwitch(String newFxmlScene, int width, int height, boolean ifMaximized, boolean ifResizable, String newTitle) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(newFxmlScene));
        Scene scene = new Scene(fxmlLoader.load(), width, height);
        DataBaseApplication.primaryStage.setScene(scene);
        DataBaseApplication.primaryStage.setMaximized(ifMaximized); // Fullscreen in window if true
        DataBaseApplication.primaryStage.setResizable(ifResizable);
        DataBaseApplication.primaryStage.setTitle(newTitle);
   }

    public SceneSwitch(String newFxmlScene,int width, int height, int MaxWidth, int MaxHeight, boolean ifMaximized, boolean ifResizable, String newTitle) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(newFxmlScene));
        Scene scene = new Scene(fxmlLoader.load(), width, height);
        DataBaseApplication.primaryStage.setScene(scene);
        DataBaseApplication.primaryStage.setResizable(!ifResizable);
        DataBaseApplication.primaryStage.setMaxHeight(MaxHeight);
        DataBaseApplication.primaryStage.setMaxWidth(MaxWidth);
        DataBaseApplication.primaryStage.setTitle(newTitle);
        DataBaseApplication.primaryStage.setResizable(ifResizable);
        DataBaseApplication.primaryStage.setMaximized(ifMaximized); // Fullscreen in window if true
    }
}
