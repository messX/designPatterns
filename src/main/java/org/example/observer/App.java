package org.example.observer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
    public static void main(String... args) throws InterruptedException {
        StockGrabber stockGrabber = new StockGrabber();
        StockObserver stockObserver = new StockObserver(stockGrabber);
        stockGrabber.register(stockObserver);
//        stockGrabber.setAppleStock(10.2);
//        stockGrabber.setGoogleStock(11.2);
        //using multithreading
        log.info("Starting trading");
        ThreadedGrabber threadedGrabber = new ThreadedGrabber(stockGrabber);
        Thread t1 = new Thread(threadedGrabber);
        t1.start();
        t1.join();
        log.info("Ending trading");
        
    }
}
