package org.ttpi.new_world_journey.ships;

public class Ship {
    private int currentDistance;
    private int passengers;
    private int happiness;
    private int healthOfShip;
    private int coins;
    private int startFood;

    public Ship(int passengers, int happiness, int healthOfShip, int coins, int startFood) {
        this.passengers = passengers;
        this.happiness = happiness;
        this.healthOfShip = healthOfShip;
        this.coins = coins;
        this.startFood = startFood;
    }

    public int progressShip(int n){
        this.currentDistance += n;
        return this.currentDistance;
    }

}
