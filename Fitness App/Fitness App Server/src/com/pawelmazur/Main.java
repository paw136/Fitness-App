package com.pawelmazur;

import com.pawelmazur.Database_Management.FoodDataSource;
import com.pawelmazur.Server.Server;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static FoodDataSource foodDataSource = new FoodDataSource();


    @Override
    public void start(Stage primaryStage) throws Exception{
        Server server = new Server();
        server.start();

        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1280 , 720));
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
