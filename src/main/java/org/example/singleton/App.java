package org.example.singleton;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App extends Thread {

    @SneakyThrows
    @Override
    public void run() {
        //log.info(String.valueOf(SafeSingleton.getInstance().hashCode()));
        log.info(String.valueOf(UnsafeSingleton.getInstance().hashCode()));
    }

    public static void main(String[] args){
        for(int i=0;i<4;i++){
            new App().start();
        }
    }
}
