package org.example.memento;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CareTaker {
    public List<Memento> mementos = new ArrayList<>();

    public void addMemento(Memento memento){
        mementos.add(memento);
    }
    public Memento getMemento(){
        Memento memento = mementos.get(mementos.size() - 1);
        mementos.remove(mementos.size() - 1);
        return memento;
    }
}
