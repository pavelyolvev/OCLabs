package com.example.lab1gui.TankNCup;

public class Tank {
    int volume, size;
    public Tank(int size){
        this.size=size;
    }
    public void add(int num){
        volume+=num;
    }
    public int getVolume(){
        return volume;
    }
}
