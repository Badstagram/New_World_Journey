/*
 * Copyright 2020 Test Team Pls Ignore.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ttpi.new_world_journey.engine.ships;

public class Ship {
    final int MAX_HEALTH;
    final private int MAX_PASSENGERS;
    private int currentDistance;
    private int passengers;
    private int happiness;
    private int healthOfShip;

    public int getDamageCapabilities() {
        return damageCapabilities;
    }

    private int coins;
    private int speedOfShip;
    private int damageCapabilities;

    public String getName() {
        return name;
    }

    private int startFood;
    private String name;
    public boolean readyForNextTick = true;

    public int getMAX_HEALTH() {
        return MAX_HEALTH;
    }

    public int getMAX_PASSENGERS() {
        return MAX_PASSENGERS;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getHealthOfShip() {
        return healthOfShip;
    }

    public int getCoins() {
        return coins;
    }

    public int getSpeedOfShip() {
        return speedOfShip;
    }

    public int getStartFood() {
        return startFood;
    }

    public int getPassengers() {
        return passengers;
    }

    public Ship(int passengers, int healthOfShip, int coins, int startFood, int speedOfShip, String name) {
        this.passengers = passengers;
        this.happiness = 100;
        this.healthOfShip = healthOfShip;
        this.coins = coins;
        this.startFood = startFood;
        this.speedOfShip = speedOfShip;
        this.name = name;
        MAX_HEALTH = healthOfShip;
        MAX_PASSENGERS = passengers;

    }

    public void progressShip(int n) {
        this.currentDistance += n;
    }

    public void consumeFood(int n) {
        if (this.startFood - n <= 0) {
            this.startFood = 0;
        } else {
            this.startFood -= n;
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
    public void changeDamageOutput(int n){
        this.damageCapabilities += n;
    }

}
