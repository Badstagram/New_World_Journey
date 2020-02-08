package org.ttpi.new_world_journey.ships;

public class Ship {
    private int currentDistance;


    public Ship findShip(String name){
        Ship mayFlower = new Mayflower();
        Ship caravel = new Caravel();
        Ship santaMaria = new SantaMaria;
        Ship trinidad = new Trinidad();
        Ship endurance = new Endurance();
        Ship
        String lowerCase = name.toLowerCase();
        switch(name){
            case "mayflower":
                this.currentShip = mayFlower;
                return mayFlower;
                break;
            case "caravel":
                this.currentShip = caravel;
                return caravel;
                break;
            case "santa maria":
                this.currentShip = santaMaria;
                return santaMaria;
                break;
            case "trinidad":
                this.currentShip = trinidad;
                return trinidad;
                break;
            case "endurance":
                this.currentShip = endurance;
                return endurance;
                break;
        }
    }

    public int progressShip(int n){
        this.currentDistance += n;
        return this.currentDistance;
    }

}
