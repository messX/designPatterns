package org.example.adapter;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Captain {
    private RowingBoat rowingBoat;
    public void row(){
        rowingBoat.row();
    }
}
