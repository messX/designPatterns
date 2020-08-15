package org.example.observer;


public interface Subject<T> {
    public boolean register(T observer);
    public boolean unregister(T observer);
    public void notifyObserver();
}
