package org.ttpi.new_world_journey.engine.actions;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import org.ttpi.new_world_journey.engine.ships.Ship;

import java.awt.*;
import java.time.Instant;

public class Cthulu extends Action {
    private Ship ship;
    private MessageChannel channel;
    private String discordId;
    public Cthulu(String discordId, MessageChannel channel) {
        super(1, new int[] {2,3});
        channel = channel;
        discordId = discordId;
    }

    @Override
    public Ship execute(Ship ship, int argument) {
        this.ship = ship;
        double random = (Math.random()*100) + 1;
        channel.sendMessage(new EmbedBuilder()
                .setTitle("Cthulu Appears!")
                .setDescription("What will you do against such a terrifying foe? \n'''1. Fight?\n2. Flee?\n3. Pray?'''")
                .setThumbnail("https://cdn.discordapp.com/attachments/669674609938792471/675887557623676948/cts.gif")
                .setTimestamp(Instant.now())
                .setColor(new Color(92, 207, 247))
                .build());
        switch (argument){
            //Choose to fight
            case 1:
                if(random >= 1 && random <= 33){
                    channel.sendMessage(new EmbedBuilder()
                            .setTitle("Cthulu destroys your mind")
                            .setThumbnail("https://cdn.discordapp.com/attachments/669674609938792471/675887557623676948/cts.gif")
                            .setTimestamp(Instant.now())
                            .setColor(new Color(92, 207, 247))
                            .build());
                    ship.changePassengers((ship.getPassengers()/ship.getPassengers());
                }
            case 2:
            case 3:
        }

        return ship;
    }

}
