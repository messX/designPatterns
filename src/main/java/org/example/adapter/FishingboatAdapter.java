package org.example.adapter;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FishingboatAdapter implements RowingBoat {
    private final FishingBoat boat;
    public void row(){
        boat.sail();
    }
}
