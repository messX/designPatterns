package org.example.observer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StockObserver extends ObserverImpl {
    private StockGrabber stockGrabber;
    private double applePrice;
    private double googlePrice;

    public StockObserver(StockGrabber stockGrabber){
        this.stockGrabber = stockGrabber;
        id++;
    }

    @Override
    public void update() {
        this.applePrice = this.stockGrabber.getAppleStock();
        this.googlePrice = this.stockGrabber.getGoogleStock();
        log.info(String.format("New stock prices are \n Apple:\t %2f \n Google:\t %2f", this.applePrice, this.googlePrice));
    }

}
