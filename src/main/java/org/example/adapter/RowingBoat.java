package org.example.adapter;

public interface RowingBoat {
    default void row(){
        System.out.println("default row.....");
    }
}
