package org.woojii.sonchar;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader root = new FXMLLoader(getClass().getResource("Helper_Main.fxml"));
        Scene scene = new Scene(root.load());
        stage.setTitle("순찰 도우미!");
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/main/resources/logo.png"));
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}