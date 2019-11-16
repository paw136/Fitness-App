package com.pawelmazur;

import com.pawelmazur.ClientSide.Client;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Client client = new Client();
        client.start();

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Fitness App");
        primaryStage.setScene(new Scene(root, 1200, 720));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
