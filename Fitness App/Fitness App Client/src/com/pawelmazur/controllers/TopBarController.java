package com.pawelmazur.controllers;

import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import com.pawelmazur.main.Main;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class TopBarController {
    @FXML public JFXHamburger hamburger;

    public void initialize() {
        hamburgerInitialization();
    }

    private void hamburgerInitialization() {
        HamburgerBackArrowBasicTransition burgerTask = new HamburgerBackArrowBasicTransition(hamburger);
        burgerTask.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e)->{
            burgerTask.setRate(burgerTask.getRate()*-1);
            burgerTask.play();

            if(Main.mainScreenController.drawer.isClosed()){
                Main.mainScreenController.drawer.open();
            }else {
                Main.mainScreenController.drawer.close();
            }
        });
    }


}
