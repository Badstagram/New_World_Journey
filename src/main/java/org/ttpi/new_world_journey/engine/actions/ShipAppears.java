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
package org.ttpi.new_world_journey.engine.actions;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.entities.MessageChannel;
import org.ttpi.new_world_journey.engine.ships.Ship;



public class ShipAppears extends Action {
    private Ship ship;
    private EventWaiter waiter;
    private CommandEvent event;

    public ShipAppears(EventWaiter waiter, CommandEvent event) {
        super(90, new int[] {1,2,3});
        this.waiter = waiter;
        this.event = event;
    }

    @Override
    public Ship execute(Ship ship, int argument) {
        this.ship = ship;
        double percent = (Math.random()*100) + 1;
        if (argument == 0){
            return ship;
        }else if(argument == 1){
            if(percent >= 1 && percent <= 33){
                executeShipWrecked();
            }else if(percent > 33 && percent <= 66){
                executeAngryNatives();
            }else{
                executeFindFood();
            }
        }

        return ship;
    }

    //Pick up new passengers, other members become unhappy
    public void executeShipWrecked(){
        ship.changePassengers(10);
        ship.changeHappiness(-5);
    }
    //Angry natives attack ship
    public void executeAngryNatives(){
        ship.changeHealth(-10);
        ship.changeHappiness(-10);
    }
    //Find all kinds of fruit for the ship.
    public void executeFindFood(){
        ship.consumeFood(-10);
        ship.changeHappiness(10);
    }
}
