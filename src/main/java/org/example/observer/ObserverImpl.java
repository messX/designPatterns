package org.example.observer;

public abstract class ObserverImpl implements Observer {
    protected static int id;
    @Override
    public abstract void update();

    public int getId(){
        return id;
    };
}
