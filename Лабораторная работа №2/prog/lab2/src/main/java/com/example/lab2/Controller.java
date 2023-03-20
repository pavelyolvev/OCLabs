package com.example.lab2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class Controller {


    @FXML
    private TilePane paneInsert;
    @FXML
    private Button btnApplyAddress, btnApplyValue;
    @FXML
    private Label lblAddress, lblValue;
    @FXML
    private TextField textFieldInsAddress, textFieldInsertValue;
    @FXML
    private HBox hBoxInsertValue, hBoxAddress, hBoxValue;

    @FXML
    protected void OnClickApplyAddress(){
        lblAddress.setText(textFieldInsAddress.getText());
    }
}