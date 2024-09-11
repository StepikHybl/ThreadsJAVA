package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        MyThreadWorld myThread2 = new MyThreadWorld();
        MyThreadTextures myThread3 = new MyThreadTextures();
        MyThreadEnter myThread4 = new MyThreadEnter();

        myThread.start();
        while(myThread.isAlive()){
            System.out.println(String.format("Creating character %s/250",myThread.getProgress()));
            Thread.sleep(1000);
        }
        myThread.join();
        System.out.println("-----------------");
        System.out.println("Character created");
        System.out.println("-----------------");

        myThread2.start();
        while(myThread2.isAlive()){
            System.out.println(String.format("Generating world %s/300",myThread2.getProgress()));
            Thread.sleep(1000);
        }
        myThread2.join();
        System.out.println("-----------------");
        System.out.println("World generated");
        System.out.println("-----------------");

        myThread3.start();
        while(myThread3.isAlive()){
            System.out.println(String.format("Loading Textures %s/500",myThread3.getProgress()));
            Thread.sleep(1000);
        }
        myThread3.join();
        System.out.println("-----------------");
        System.out.println("Textures loaded");
        System.out.println("-----------------");

        myThread4.start();
        while(myThread4.isAlive()){
            System.out.println(String.format("Entering World %s/100",myThread4.getProgress()));
            Thread.sleep(100);
        }
        myThread4.join();
        System.out.println("-----------------");
        System.out.println("Enjoy");
        System.out.println("-----------------");
    }
}
