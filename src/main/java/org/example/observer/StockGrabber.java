package org.example.observer;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
public class StockGrabber<T extends ObserverImpl> implements Subject<T> {
    private List<T> observers;
    private double appleStock;
    private double googleStock;

    public StockGrabber(){
        observers = new ArrayList<T>();
    }

    @Override
    public boolean register(T observer) {
        log.info(String.format("registering observer %d", observer.getId()));
        this.observers.add(observer);
        return true;
    }

    @Override
    public boolean unregister(T observer) {
        Optional<ObserverImpl> optionalObserver = (Optional<ObserverImpl>) this.observers.stream().filter((ObserverImpl _observer)-> {return _observer.getId() == observer.getId();}).findAny();
        if(!optionalObserver.isPresent()){
            log.error(String.format("observer %d is not registered", observer.getId()));
            return false;
        }
        else{
            log.info(String.format("unregistering observer %d", observer.getId()));
            this.observers = this.observers.stream().filter((_observer)-> _observer.getId() != observer.getId()).collect(Collectors.toList());
            return true;
        }

    }

    @Override
    public void notifyObserver() {
        for(T observer: this.observers){
            observer.update();
        }
    }

    public void setAppleStock(double price){
        this.appleStock = price;
        this.notifyObserver();
    }

    public void setGoogleStock(double price){
        this.googleStock = price;
        this.notifyObserver();
    }

    public double getAppleStock(){
        return this.appleStock;
    }

    public double getGoogleStock(){
        return this.googleStock;
    }
}
