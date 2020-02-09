package org.ttpi.new_world_journey.engine.actions;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import org.ttpi.new_world_journey.engine.ships.Ship;

public class Island extends Action {
    private EventWaiter waiter;
    private CommandEvent event;
    private Ship ship;
    public Island(EventWaiter waiter, CommandEvent event) {
        super(10, new int[] {2,3});
        this.waiter = waiter;
        this.event = event;
    }

    public Ship execute(Ship ship) {
        System.out.println("[EVENT] - Island");
        this.ship = ship;
        double percent = (Math.random()*100) + 1;
//        if (argument == 0){
//            return ship;
//        }else if(argument == 1){
//            if(percent >= 1 && percent <= 33){
//                executePirates();
//            }else if(percent > 33 && percent <= 66){
//                executeAbandonedShip();
//            }else{
//                executeMerchant();
//            }
//        }

        return ship;
    }

    public void executePirates(){

    }
    public void executeAbandonedShip(){

    }

    public void executeMerchant(){

    }

    public Ship forceMerchant(Ship ship){
        this.ship = ship;
        executeMerchant();
        return ship;
    }
}
