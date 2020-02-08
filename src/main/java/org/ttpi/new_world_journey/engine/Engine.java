package org.ttpi.new_world_journey.engine;

import org.ttpi.new_world_journey.engine.ships.*;
import org.ttpi.new_world_journey.engine.events.*;

public class Main {

    public String user;
    public String shipName;
    public Boolean wasPreviousEvent = false;
    public int ticksThisMonth = 0;
    public int currentMonth = 0;
    public int targetDistance = 3000;
    public Ship ship;

    public void Main(String discordId, String shipName) {
        this.user = discordId;
        String lowerCase = shipName.toLowerCase();
        if ("mayflower".equals(lowerCase)) {
            Ship ship = new Mayflower();
        } else if ("caravel".equals(lowerCase)) {
            Ship ship = new Caravel();
        } else if ("santa maria".equals(lowerCase)) {
            Ship ship = new SantaMaria();
        } else if ("trinidad".equals(lowerCase)) {
            Ship ship = new Trinidad();
        } else if ("endurance".equals(lowerCase)) {
            Ship ship = new Endurance();
        } else {
            Ship ship = new Mayflower();
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


        if(!wasPreviousEvent) {
            //shove all events into an event array
//            Events[] events;
//
//            //Calculate total weight of our events
//            double totalWeight = 0.0d;
//            for(events ent : events) {
//                totalWeight += ent.getWeight();
//            }
//
//            //Calculate random event
//            int randomIndex = -1;
//            double random = Math.random() * totalWeight;
//            for(int i = 0; i < events.length; i++) {
//                random -= events[i].getWeight();
//                if(random <= 0.0d) {
//                    randomIndex = i;
//                    break;
//                }
//            }
//
//            Events randomEvent = Events[randomIndex];
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
}
