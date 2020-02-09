package org.ttpi.new_world_journey.engine.actions;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.entities.MessageChannel;
import org.ttpi.new_world_journey.engine.ships.Ship;

public class TreasureMap extends Action {
    private EventWaiter waiter;
    private CommandEvent event;
    private Ship ship;

    public TreasureMap(EventWaiter waiter, CommandEvent event) {
        super(30, new int[] {1,2});
        this.waiter = waiter;
        this.event = event;
    }
    public Ship execute(Ship ship, int argument) {
        System.out.println("[EVENT] - Treasure Map");
        this.ship = ship;
        double percent = (Math.random()*100) + 1;
        if (argument == 0){
            return ship;
        }else if(argument == 1){
            if(percent >= 1 && percent <= 33){
                //executeShipWrecked();
            }else if(percent > 33 && percent <= 66){
                //executeAngryNatives();
            }else{
                //executeFindFood();
            }
        }

        return ship;
    }

    public void executeFindTreasureGetLost(){

    }
    public void executeFindTreasure(){

    }
    public void executeGetLost(){

    }
}
