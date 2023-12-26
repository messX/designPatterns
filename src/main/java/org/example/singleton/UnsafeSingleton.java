package org.example.singleton;

public class UnsafeSingleton {
    private static UnsafeSingleton instance = null;

    private UnsafeSingleton() {}

    static UnsafeSingleton getInstance () {
        if(instance == null) {
            instance = new UnsafeSingleton();
        }
        return instance;
    }
}
