package org.example.adapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
    public static void main(String[]args){
        FishingBoat fishingBoat = new FishingBoat();
        FishingboatAdapter fishingboatAdapter = new FishingboatAdapter(fishingBoat);
        Captain captain = new Captain(fishingboatAdapter);
        captain.row();
    }
}
