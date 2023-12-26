package org.example.memento;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
    public static void main(String[] args){
        CareTaker careTaker = new CareTaker();
        Originator originator = new Originator("state 1");
        careTaker.addMemento(originator.save());
        log.info(originator.getState());
        originator.setState("state 2");
        careTaker.addMemento(originator.save());
        log.info(originator.getState());
        originator.restore(careTaker.getMemento());
        log.info(originator.getState());
        originator.restore(careTaker.getMemento());
        log.info(originator.getState());
    }
}
