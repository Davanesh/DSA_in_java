package com.dava.introToOOPs.interfaces;

public class Main {
    public static void main(String[] args) {
//        car.start();
//        car.acc();
//        car.brake();
//        car.stop();
//        Media carMedia = new Car();
//        carMedia.start();
        NiceCar car = new NiceCar();
        car.start();
        car.startMusic();
        car.upgradeEngine();
        car.start();
    }
}
