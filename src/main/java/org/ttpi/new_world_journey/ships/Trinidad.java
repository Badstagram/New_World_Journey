package org.ttpi.new_world_journey.ships;

public class Trinidad {
    private int passengers;
    private int happiness;
    private int healthOfShip;
    private int coins;
    private int startFood;

    public Trinidad() {
        this.passengers = 100;
        this.happiness = 100;
        this.healthOfShip = 50;
        this.coins = 500;
        this.startFood = 500;
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