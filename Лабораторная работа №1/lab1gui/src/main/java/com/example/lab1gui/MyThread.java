package com.example.lab1gui;

import com.example.lab1gui.TankNCup.Tank;
import javafx.scene.control.ProgressBar;

import com.example.lab1gui.HelloController;

public class MyThread extends Thread{
    Tank tank = new Tank(1000);
    HelloController controller = new HelloController();
    ProgressBar progBar;

    @Override
    public void run(){
        progBar.setProgress(tank.getVolume());
    }
    public MyThread(ProgressBar progBar){
        this.progBar = progBar;
    }
}
