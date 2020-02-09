package org.ttpi.new_world_journey.engine.actions;

import net.dv8tion.jda.api.entities.MessageChannel;
import org.ttpi.new_world_journey.engine.ships.Ship;

public class RainbowMist extends Action {
    private Ship ship;
    private MessageChannel channel;
    private String discordId;
    public RainbowMist(String discordId, MessageChannel channel) {
        super(1, new int[] {2});
        channel = channel;
        discordId = discordId;
    }
    public Ship execute(Ship ship, int argument) {
        this.ship = ship;
        switch (argument){
            case 1:
            case 2:
            default:
        }

        return ship;
    }
}
