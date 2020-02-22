package com.pawelmazur.main;

//import com.pawelmazur.ClientSide.Client;
import com.pawelmazur.controllers.MainScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static MainScreenController mainScreenController;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/MainScreen.fxml"));
        Parent root = loader.load();
        mainScreenController = loader.getController();
        primaryStage.setTitle("Fitness App");
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
