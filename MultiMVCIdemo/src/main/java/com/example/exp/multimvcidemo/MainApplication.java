package com.example.exp.multimvcidemo;

import com.example.exp.multimvcidemo.main.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Multi-MVCI Application");
        stage.setScene(new Scene(new MainController().getView()));
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}