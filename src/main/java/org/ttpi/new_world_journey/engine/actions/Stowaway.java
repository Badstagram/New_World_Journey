package org.ttpi.new_world_journey.engine.actions;

import net.dv8tion.jda.api.entities.MessageChannel;

public class Stowaway extends Action {
    MessageChannel channel;
    String discordId;
    public Stowaway(String discordId, MessageChannel channel) {
        super(90, new int[] {2});
        channel = channel;
        discordId = discordId;
    }

}
