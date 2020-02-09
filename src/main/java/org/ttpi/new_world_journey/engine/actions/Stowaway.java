package org.ttpi.new_world_journey.engine.actions;

import net.dv8tion.jda.api.entities.MessageChannel;
import org.ttpi.new_world_journey.engine.ships.Ship;

public class Stowaway extends Action {
    private Ship ship;
    private MessageChannel channel;
    private String discordId;
    public Stowaway(String discordId, MessageChannel channel) {
        super(90, new int[] {2});
        channel = channel;
        discordId = discordId;
    }

}
