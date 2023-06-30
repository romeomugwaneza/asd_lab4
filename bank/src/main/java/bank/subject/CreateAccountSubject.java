package bank.subject;

import bank.integration.Observer;

import java.util.ArrayList;
import java.util.Collection;

public class CreateAccountSubject {
    private Collection<Observer> observers = new ArrayList<>();
    public void addObserver(Observer observer){
        observers.add(observer);
    }
    public void doNotify(){

        for (Observer observer: observers){
            observer.update();
        }

    }
}
