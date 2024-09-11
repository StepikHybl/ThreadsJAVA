package com.company;

import java.util.Random;

public class MyThreadEnter extends Thread{

    Random random = new Random();

    private int progress;

    @Override
    public void run(){
        for (int i = 0; i < 100; i++){
            progress = i;
            try {
                Thread.sleep(random.nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getProgress(){
        return progress;
    }
}