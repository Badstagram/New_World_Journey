package org.ttpi.new_world_journey.ships;

public class Ship {
    private int currentDistance;


    public Ship findShip(String name){
        Ship mayFlower = new Mayflower();
        Ship caravel = new Caravel();
        Ship santaMaria = new SantaMaria();
        Ship trinidad = new Trinidad();
        Ship endurance = new Endurance();
        String lowerCase = name.toLowerCase();
        if ("mayflower".equals(lowerCase)) {
            return mayFlower;
        } else if ("caravel".equals(lowerCase)) {
            return caravel;
        } else if ("santa maria".equals(lowerCase)) {
            return santaMaria;
        } else if ("trinidad".equals(lowerCase)) {
            return trinidad;
        } else if ("endurance".equals(lowerCase)) {
            return endurance;
        } else {
            return mayFlower;
        }
    }

    public int progressShip(int n){
        this.currentDistance += n;
        return this.currentDistance;
    }

}
