package com.pawelmazur.controllers;

import com.jfoenix.controls.JFXDrawer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MainScreenController {
    @FXML public BorderPane borderPane;
    @FXML public JFXDrawer drawer;

    SideMenuController sideMenuController;
    TopBarController topBarController;

    public void initialize(){
        Parent sideMenu = null;
        Parent topBar = null;
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/SideMenu.fxml"));
            sideMenu = loader.load();
            sideMenuController = loader.getController();

            FXMLLoader loader2 = new FXMLLoader(getClass().getResource("../views/TopBar.fxml"));
            topBar = loader2.load();
            topBarController = loader2.getController();

            borderPane.setTop(topBar);
//            borderPane.setLeft(sideMenu);
            BorderPane.setAlignment(topBar, Pos.TOP_RIGHT);
        }catch (IOException e){ }

        drawer.setSidePane(sideMenu);


    }


    @FXML private void openDrawer(){
        drawer.open();
    }
}
