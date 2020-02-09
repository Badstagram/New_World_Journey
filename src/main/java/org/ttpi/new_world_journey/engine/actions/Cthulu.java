package org.ttpi.new_world_journey.engine.actions;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import org.ttpi.new_world_journey.engine.ships.Ship;

import java.awt.*;
import java.time.Instant;

public class Cthulu extends Action {
    private Ship ship;
    private EventWaiter waiter;
    private CommandEvent event;
    public Cthulu(EventWaiter waiter, CommandEvent event) {
        super(1, new int[] {2,3});
        this.waiter = waiter;
        this.event = event;
    }

    @Override
    public Ship execute(Ship ship, int argument) {
        System.out.println("[EVENT] - Cthulu");
        this.ship = ship;
        double random = (Math.random()*100) + 1;
        event.reply(new EmbedBuilder()
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
                    event.reply(new EmbedBuilder()
                            .setTitle("Cthulu destroys your mind")
                            .setThumbnail("https://cdn.discordapp.com/attachments/669674609938792471/675887557623676948/cts.gif")
                            .setTimestamp(Instant.now())
                            .setColor(new Color(92, 207, 247))
                            .build());
                    ship.changePassengers((ship.getPassengers()/ship.getPassengers())-1);
                }else if(random > 33 && random <= 66){
                    event.reply(new EmbedBuilder()
                            .setTitle("Cthulu takes the souls of your crew")
                            .setThumbnail("https://cdn.discordapp.com/attachments/669674609938792471/675887557623676948/cts.gif")
                            .setTimestamp(Instant.now())
                            .setColor(new Color(92, 207, 247))
                            .build());
                    ship.changeHappiness(-1(ship.getHappiness()/2));
                }else{
                    event.reply(new EmbedBuilder()
                            .setTitle("Cthulu does something but your puny minds could never understand..")
                            .setDescription("'''Nothing happens...'''")
                            .setThumbnail("https://cdn.discordapp.com/attachments/669674609938792471/675887557623676948/cts.gif")
                            .setTimestamp(Instant.now())
                            .setColor(new Color(92, 207, 247))
                            .build());
                }
            //Choose to flee
            case 2:
                event.reply(new EmbedBuilder()
                        .setTitle("Cthulu scrambles the mind of your crew ")
                        .setDescription("'''You get lost and end up traveling back'''")
                        .setThumbnail("https://cdn.discordapp.com/attachments/669674609938792471/675887557623676948/cts.gif")
                        .setTimestamp(Instant.now())
                        .setColor(new Color(92, 207, 247))
                        .build());
                ship.progressShip(-ship.getSpeedOfShip()*2);
            case 3:
                if(random >= 1 && random < 50){
                    event.reply(new EmbedBuilder()
                            .setTitle("Cthulu is flattered")
                            .setDescription("'''Cthulu lets you go so you can spread his religion'''")
                            .setThumbnail("https://cdn.discordapp.com/attachments/669674609938792471/675887557623676948/cts.gif")
                            .setTimestamp(Instant.now())
                            .setColor(new Color(92, 207, 247))
                            .build());
                    ship.progressShip(ship.getSpeedOfShip()*2);
                }else{
                    event.reply(new EmbedBuilder()
                            .setTitle("Cthulu is flattered")
                            .setDescription("'''Cthulu kills you as a sacrifice to himself'''")
                            .setThumbnail("https://cdn.discordapp.com/attachments/669674609938792471/675887557623676948/cts.gif")
                            .setTimestamp(Instant.now())
                            .setColor(new Color(92, 207, 247))
                            .build());
                    ship.progressShip(-ship.getSpeedOfShip()*2);
                }
        }

        return ship;
    }

}
