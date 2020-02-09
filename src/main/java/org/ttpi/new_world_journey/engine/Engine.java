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
package org.ttpi.new_world_journey.engine;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import org.ttpi.new_world_journey.engine.ships.*;
import org.ttpi.new_world_journey.engine.actions.*;

import java.awt.*;
import java.time.Instant;

public class Engine {

    private EventWaiter waiter;
    private CommandEvent event;
    private int ticksThisMonth = 0;
    private int currentMonth = 0;
    private int targetDistance = 3000;
    private Ship ship;

    public Engine(EventWaiter waiter, CommandEvent event, String shipName) {
        this.waiter = waiter;
        this.event = event;
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

    public void start() {
        Island newMerchant = new Island(waiter, event);
        newMerchant.forceMerchant(ship);
        nextTick();
    }


    public void nextTick() {
        if(ticksThisMonth == 5) {
            currentMonth += 1;
            ticksThisMonth = 0;
        }

        ship.progressShip(200);
        ship.consumeFood(100);

        if(ship.getCurrentDistance() >= targetDistance) {
            gameOver(true, "User has reached the new world!");
        } else if(ship.getStartFood() == 0) {
            gameOver(false, "User has ran out of food.");
        } else if(ship.getPassengers() == 0) {
            gameOver(false, "User's passengers have all died.");
        } else if(ship.getHappiness() == 0) {
            gameOver(false, "The captains crew has performed a mutiny due to low happiness.");
            nextTick();
        }

        //shove all events into an event array
        Action[] events = {
                new Cthulu(waiter, event),
                new Diseases(waiter, event),
                new Island(waiter, event),
                new Kraken(waiter, event),
                new MechanicalFailure(waiter, event),
                new Mermaid(waiter, event),
                new RainbowMist(waiter, event),
                new ShipAppears(waiter, event),
                new Stowaway(waiter, event),
                new TreasureMap(waiter, event),
                new Weather(waiter, event)
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
        randomWeightedEvent.execute(ship, 1);
    }


    public void gameOver(boolean hasWon, String reason) {
        if(!hasWon) {
            event.getChannel().sendMessage(new EmbedBuilder()
                    .setTitle("You lost...")
                    .setDescription(reason)
                    .setTimestamp(Instant.now())
                    .setColor(new Color(92, 207, 247))
                    .build());
        } else {
            event.getChannel().sendMessage(new EmbedBuilder()
                    .setTitle("You Won!")
                    .setDescription(reason)
                    .setTimestamp(Instant.now())
                    .setColor(new Color(92, 207, 247))
                    .build());
        }
        String user = null;
        MessageChannel channel = null;
        String shipName = null;
        int ticksThisMonth = 0;
        int currentMonth = 0;
        int targetDistance = 3000;
        Ship ship = null;
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
