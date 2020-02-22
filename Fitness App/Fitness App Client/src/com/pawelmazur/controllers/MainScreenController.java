package com.pawelmazur.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MainScreenController {
    @FXML BorderPane borderPane;

    public void initialize(){
        try{
            Parent sideMenu = FXMLLoader.load(getClass().getResource("../views/SideMenu.fxml"));
            Parent topBar = FXMLLoader.load(getClass().getResource("../views/TopBar.fxml"));
            borderPane.setLeft(sideMenu);
            borderPane.setTop(topBar);
            BorderPane.setAlignment(topBar, Pos.TOP_RIGHT);
        }catch (IOException e){ }
    }

}
