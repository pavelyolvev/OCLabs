package com.example.lab1gui;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;

import java.util.Random;
import java.util.concurrent.Callable;
import com.example.lab1gui.TankNCup.*;
import com.example.lab1gui.MyThread.*;

public class HelloController extends Thread{


    int buffer;
    void setBuffer(int num){
        buffer = num;
    }
    @FXML
    private Label tank1volume;
    @FXML
    private Label tank2volume;
    @FXML
    private Label tank3volume;

    @FXML
    private ProgressBar tank1ProgBar;
    @FXML
    private ProgressBar tank2ProgBar;
    @FXML
    private ProgressBar tank3ProgBar;

    @FXML
    public void FillButton(ActionEvent actionEvent) {

    }
    @FXML
    public void DrainButton(ActionEvent actionEvent) {tank2volume.setText("BBBBB");
    }

    public ProgressBar getTank1ProgBar(){
        return tank1ProgBar;
    }
    public ProgressBar getTank2ProgBar(){
        return tank2ProgBar;
    }
    public ProgressBar getTank3ProgBar(){
        return tank3ProgBar;
    }
    public void setTank1ProgBar(int num){
        tank1ProgBar.setProgress(num);
    }
    public void setTank2ProgBar(int num){
        tank2ProgBar.setProgress(num);
    }
    public void setTank3ProgBar(int num){
        tank3ProgBar.setProgress(num);
    }

}
