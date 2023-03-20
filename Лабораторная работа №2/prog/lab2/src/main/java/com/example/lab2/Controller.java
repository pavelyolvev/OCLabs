package com.example.lab2;

import com.example.lab2.MemMethods.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;


public class Controller {

    int pid, readed;
    String addressSt;



    @FXML
    private TilePane paneInsert;
    @FXML
    private Button btnApplyAddress, btnApplyValue;
    @FXML
    private Label lblAddress, lblValue;
    @FXML
    private TextField textFieldInsAddress, textFieldInsPid, textFieldInsertValue;
    @FXML
    private HBox hBoxInsertValue, hBoxAddress, hBoxValue;

    @FXML
    protected void OnClickApplyAddress(){

        pid = Integer.parseInt(textFieldInsPid.getText());
        addressSt = textFieldInsAddress.getText();

        MemMethods mMethod = new MemMethods(pid, addressSt);
        readed = mMethod.read();
        lblValue.setText(String.valueOf(readed));
        lblAddress.setText(mMethod.getAddress());
    }
    @FXML
    protected void OnClickApplyInsValue(){
        MemMethods mMethod = new MemMethods(pid, addressSt);
        mMethod.write(Integer.parseInt(textFieldInsertValue.getText()));

        readed = mMethod.read();
        lblValue.setText(String.valueOf(readed));
    }



}



/*
try {
        CLibrary.INSTANCE.ptrace(CLibrary.PTRACE_DETACH, pid, address,null);
        Memory buffer = new Memory(4);

        String addressSt = textFieldInsAddress.getText();
        byte[] dataAddress = addressSt.getBytes(StandardCharsets.UTF_8);
        address = new Memory(dataAddress.length+1);
        address.write(0, dataAddress, 0,dataAddress.length);
        address.setByte(dataAddress.length, (byte) 0);

        CLibrary.INSTANCE.ptrace(CLibrary.PTRACE_PEEKDATA, pid, address, buffer);

        lblAddress.setText(address.getString(0));
        lblValue.setText(String.valueOf(buffer.getInt(0)));
        }catch (LastErrorException ex) {
        ex.printStackTrace();
        } finally {
        CLibrary.INSTANCE.ptrace(CLibrary.PTRACE_DETACH, pid, address,null);
        }

*/