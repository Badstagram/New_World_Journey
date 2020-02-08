package org.ttpi.new_world_journey.engine;

import org.ttpi.new_world_journey.engine.ships.*;
import org.ttpi.new_world_journey.engine.actions.*;

public class Engine {

    private String user;
    private String shipName;
    private Boolean wasPreviousEvent = false;
    private int ticksThisMonth = 0;
    private int currentMonth = 0;
    private int targetDistance = 3000;
    private Ship ship;

    public Engine(String discordId, String shipName) {
        this.user = discordId;
        String lowerCase = shipName.toLowerCase();
        if ("mayflower".equals(lowerCase)) {
            this.ship = new Mayflower();
        } else if ("caravel".equals(lowerCase)) {
            this.ship = new Caravel();
        } else if ("santa maria".equals(lowerCase)) {
            this.ship = new SantaMaria();
        } else if ("trinidad".equals(lowerCase)) {
            this.ship = new Trinidad();
        } else if ("endurance".equals(lowerCase)) {
            this.ship = new Endurance();
        } else {
            this.ship = new Mayflower();
        }
    }

    public void nextTick() {
        if(ticksThisMonth == 5) {
            currentMonth += 1;
            ticksThisMonth = 0;
        }

        int currentDistance = ship.progressShip(200);
        if(currentDistance >= targetDistance) {
            gameOver(true, "User has reached the new world!");
        }

        int foodLeft = ship.consumeFood(100);
        if(foodLeft == 0) {
            gameOver(false, "User has ran out of food.");
        }

        Kraken event = new Kraken();
        ship = event.execute(ship, 1);

        if(!wasPreviousEvent) {
            //shove all events into an event array
            Action[] events = {
                    new Kraken()
            };

            //Calculate total weight of our events
            double totalWeight = 0.0d;
            for(Action ent : events) {
                totalWeight += ent.getWeight();
            }

            //Calculate random event
            int randomIndex = -1;
            double random = Math.random() * totalWeight;
            for(int i = 0; i < events.length; i++) {
                random -= events[i].getWeight();
                if(random <= 0.0d) {
                    randomIndex = i;
                    break;
                }
            }

            Action randomWeightedEvent = events[randomIndex];
            
        } else {
            // Call idle Event
        }

    }

    public void gameOver(boolean hasWon, String reason) {
        if(!hasWon) {
            //User lost game
        } else {
            //User won the game
        }
    }

    public String getUser() {
        return user;
    }

    public String getShipName() {
        return shipName;
    }

    public int getTicksThisMonth() {
        return ticksThisMonth;
    }

    public int getCurrentMonth() {
        return currentMonth;
    }

    public int getTargetDistance() {
        return targetDistance;
    }

    public int getMilesLeft() {
        return targetDistance - ship.getCurrentDistance();
    }

    public Ship getShip() {
        return ship;
    }
}
