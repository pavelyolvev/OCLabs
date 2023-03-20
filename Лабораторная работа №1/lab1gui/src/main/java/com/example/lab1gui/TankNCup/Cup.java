package com.example.lab1gui.TankNCup;

import java.util.Random;

public class Cup {
    int[] cups = {5, 7, 10};
    public void antisort(){
        Random random = new Random();
        int buf;

        for(int i = 0; i<cups.length; i++) {
            int rand = random.nextInt(0, 2);
            if (i != rand) {
                buf = cups[i];
                cups[i] = cups[rand];
                cups[rand]=buf;
            }
        }
    }
    public int[] getCups(){
        return cups;
    }
    public int getElem(int Index){
        return cups[Index];
    }
}
