package org.ttpi.new_world_journey.engine.ships;

public class Ship {
    final int MAX_HEALTH;
    final private int MAX_PASSENGERS;
    private int currentDistance;
    public int passengers;
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

    public int progressShip(int n) {
        this.currentDistance += n;
        return this.currentDistance;
    }

    public int consumeFood(int n) {
        if (this.startFood - n <= 0) {
            this.startFood = 0;
            return 0;
        } else {
            this.startFood -= n;
            return this.startFood;
        }
    }


    public void changeHealth (int n){
        if (healthOfShip + n > MAX_HEALTH) {
            healthOfShip = MAX_HEALTH;
        } else if (healthOfShip + n < 0) {
                healthOfShip = 0;
        } else {
            healthOfShip += n;
        }
    }
    public void changePassengers(int n){
        if(passengers + n > MAX_PASSENGERS){
            passengers = MAX_PASSENGERS;
        }else if(passengers + n < 0){
            passengers = 0;
        }else{
            passengers += n;
        }
    }

    public void changeHappiness(int n){
        if(happiness + n> 100){
            happiness = 100;
        }else if(happiness + n< 0){
            happiness = 0;
        }else{
            happiness += n;
        }
    }

    public int getCurrentDistance() {
        return currentDistance;
    }

    public void changeCoins(int n){
        if(coins + n < 0){
            coins = 0;
        }else{
            coins += n;
        }
    }

}
