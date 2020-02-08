package org.ttpi.new_world_journey.ships;

public class Caravel extends Ship {
    private int passengers;
    private int happiness;
    private int healthOfShip;
    private int coins;
    private int startFood;

    public Caravel() {
        this.passengers = 85;
        this.happiness = 100;
        this.healthOfShip = 75;
        this.coins = 1000;
        this.startFood = 250;
    }

    public int consumeFood(int n){
        if(this.startFood - n <= 0){
            this.startFood = 0;
            return 0;
        }else{
            this.startFood -= n;
            return this.startFood;
        }
    }
}
