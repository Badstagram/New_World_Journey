package org.ttpi.new_world_journey.engine.actions;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import org.ttpi.new_world_journey.engine.ships.Ship;

public class Island extends Action {
    MessageChannel channel;
    String discordId;
    public Island(String discordId, MessageChannel channel) {
        super(10, new int[] {2,3});
        channel = channel;
        discordId = discordId;
    }

    private Ship ship;

    public Ship execute(Ship ship, int argument) {
        ship = ship;
        double percent = (Math.random()*100) + 1;
        if (argument == 0){
            return ship;
        }else if(argument == 1){
            if(percent >= 1 && percent <= 33){
                executePirates();
            }else if(percent > 33 && percent <= 66){
                executeAbandonedShip();
            }else{
                executeMerchant();
            }
        }

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
