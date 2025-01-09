package com.sde;

public class Logger implements StudentObserver {
    @Override
    public void update(String message) {
        System.out.println("LOG: " + message);
    }
}
