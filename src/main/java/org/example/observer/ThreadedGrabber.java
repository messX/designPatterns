package org.example.observer;

import java.util.Map;
import java.util.stream.IntStream;

public class ThreadedGrabber implements Runnable {
    private StockGrabber stockGrabber;
    public ThreadedGrabber(StockGrabber stockGrabber){
        this.stockGrabber = stockGrabber;
    }
    @Override
    public void run() {
        IntStream.range(0,10).forEach((int i)->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            double rand = Math.random() * 0.1 * i;
            if(i%2==0){
                stockGrabber.setGoogleStock(rand);
            }
            else{
                stockGrabber.setAppleStock(rand);
            }
        });
    }
}
