package com.pawelmazur;

import javafx.fxml.FXML;

public class FirstScreenController {

    @FXML private void parseIgrend(){
        Main.foodDataSource.parse_Ingredients();
    }
}
