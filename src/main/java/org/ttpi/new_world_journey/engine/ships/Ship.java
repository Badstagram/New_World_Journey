package org.ttpi.new_world_journey.engine.ships;

public class Ship {
    final int MAX_HEALTH;
    final private int MAX_PASSENGERS;
    private int currentDistance;
    private int passengers;
    private int happiness;
    private int healthOfShip;
    private int coins;
    private int startFood;

    public Ship(int passengers, int healthOfShip, int coins, int startFood) {
        this.passengers = passengers;
        this.happiness = 100;
        this.healthOfShip = healthOfShip;
        this.coins = coins;
        this.startFood = startFood;
        MAX_HEALTH = healthOfShip;
        MAX_PASSENGERS = passengers;

    }

    public int progressShip(int n){
        this.currentDistance += n;
        return this.currentDistance;
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

    public int changeHealth(){

    }
    public int changeCoins(){

    }
    public int changeHealth(){
        
    }

}
