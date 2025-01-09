package com.sde;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    private final List<StudentObserver> observers;

    public NotificationService() {
        this.observers = new ArrayList<>();
    }

    public void addObserver(StudentObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(StudentObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (StudentObserver observer : observers) {
            observer.update(message);
        }
    }
}
