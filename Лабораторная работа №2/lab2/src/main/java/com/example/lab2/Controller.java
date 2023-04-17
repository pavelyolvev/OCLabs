package com.example.lab2;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;

import java.io.*;

public class Controller {

    int pid, readed;
    String addressSt;



    @FXML
    private TilePane paneInsert;
    @FXML
    private Button btnApplyAddress, btnApplyValue;
    @FXML
    private Label lblAddress, lblValue, lblSwap;
    @FXML
    private TextField textFieldInsAddress, textFieldInsPid, textFieldInsertValue;
    @FXML
    private HBox hBoxInsertValue, hBoxAddress, hBoxValue;


    @FXML
    protected void OnClickApplyAddress() throws IOException {

        try {
            btnApplyAddress.setText("Apply");
            pid = Integer.parseInt(textFieldInsPid.getText());
            addressSt = textFieldInsAddress.getText();

            MemMethods mMethod = new MemMethods(pid, addressSt);

            readed = mMethod.read();
            lblValue.setText(String.valueOf(readed));
            lblAddress.setText(mMethod.getAddress());

            infSys inf = new infSys();
            lblSwap.setText(String.valueOf(inf.getSwap()));
            btnApplyValue.setDisable(false);
        } catch (NumberFormatException e){
            NotANumberMessage();
        }



    }
    @FXML
    protected void OnClickApplyInsValue(){
        try {
            MemMethods mMethod = new MemMethods(pid, addressSt);
            mMethod.write(Integer.parseInt(textFieldInsertValue.getText()));

            readed = mMethod.read();
            lblValue.setText(String.valueOf(readed));
        }catch (NumberFormatException e){
            NotANumberMessage();
        }
    }

    @FXML
    void NotANumberMessage(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Enter warning");
        alert.setHeaderText("Enter a number in the field");
        alert.showAndWait();
    }

}

