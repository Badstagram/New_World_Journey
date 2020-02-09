package org.ttpi.new_world_journey.engine.actions;

import net.dv8tion.jda.api.entities.MessageChannel;
import org.ttpi.new_world_journey.engine.ships.Ship;

public class Diseases extends Action {

    private MessageChannel channel;
    private String discordId;
    private Ship ship;

    public Diseases(String discordId, MessageChannel channel) {
        super(90, new int[]{2, 3});
        channel = channel;
        discordId = discordId;
    }


    public Ship execute(Ship ship, int argument) {
        this.ship = ship;
        double percent = (Math.random() * 100) + 1;
        if (percent >= 1 && percent <= 20) {
            executeScurvy(argument);
        } else if (percent > 20 && percent <= 30) {
            executeDisentary(argument);
        } else {
            executeFlu(argument);
        }
        return ship;
    }

    public void executeScurvy(int n){

    }
    public void executeDisentary(int n){

    }
    public void executeFlu(int n){

    }
}
