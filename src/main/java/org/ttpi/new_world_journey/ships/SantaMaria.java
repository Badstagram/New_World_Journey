package org.ttpi.new_world_journey.ships;

public class SantaMaria {
    private int passengers;
    private int happiness;
    private int healthOfShip;
    private int coins;
    private int startFood;

    public SantaMaria() {
        this.passengers = 25;
        this.happiness = 100;
        this.healthOfShip = 100;
        this.coins = 1500;
        this.startFood = 125;
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
