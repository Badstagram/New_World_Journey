package org.ttpi.new_world_journey.engine.actions;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.ttpi.new_world_journey.engine.ships.Ship;

import java.awt.*;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class Diseases extends Action {

    private EventWaiter waiter;
    private CommandEvent event;
    private Ship ship;

    public Diseases(EventWaiter waiter, CommandEvent event) {
        super(90, new int[]{2, 3});
        this.waiter = waiter;
        this.event = event;
    }


    public Ship execute(Ship ship) {
        System.out.println("[EVENT] - Diseases");
        this.ship = ship;
        double percent = (Math.random() * 100) + 1;
        double percent2 = (Math.random()*10) + 1;
        event.reply(new EmbedBuilder()
                .setTitle("Sickness spreads over the ship!")
                .setDescription("```You have noticed a disease spreading among your men and passengers. What will you do? \n1. Quarantine the sick?\n2. Try to cure the disease?```")
                .setThumbnail("https://cdn.discordapp.com/attachments/669674609938792471/675887557623676948/cts.gif")
                .setTimestamp(Instant.now())
                .setColor(new Color(92, 207, 247))
                .build());
        waiter.waitForEvent(MessageReceivedEvent.class,

                //filtering
                e -> e.getAuthor().equals(event.getAuthor())
                        && e.getChannel().equals(event.getChannel())
                        && !e.getMessage().equals(event.getMessage()),

                // event executions
                e -> {
                    switch(Integer.parseInt(e.getMessage().getContentRaw())){
                        case 1:
                            event.reply(new EmbedBuilder()
                                    .setTitle("You quarantine the sick")
                                    .setDescription("```The " + percent2 + " who were quarantined die but everyone else survives```")
                                    .setThumbnail("https://cdn.discordapp.com/attachments/669674609938792471/675887557623676948/cts.gif")
                                    .setTimestamp(Instant.now())
                                    .setColor(new Color(92, 207, 247))
                                    .build());
                            ship.changePassengers((int)-percent2);
                            ship.changeHappiness((int)-percent2*5);
                            break;
                        case 2:
                            if(percent <= 1 && percent < 40){
                                event.reply(new EmbedBuilder()
                                        .setTitle("You found a cure")
                                        .setDescription("```Everyone survives and morale is high!```")
                                        .setThumbnail("https://cdn.discordapp.com/attachments/669674609938792471/675887557623676948/cts.gif")
                                        .setTimestamp(Instant.now())
                                        .setColor(new Color(92, 207, 247))
                                        .build());
                                ship.changeHappiness(40);
                            }else{
                                event.reply(new EmbedBuilder()
                                        .setTitle("You couldn't find a cure")
                                        .setDescription("```You suffer a devastating loss of " + percent2*2 + " people due to the disease.```")
                                        .setThumbnail("https://cdn.discordapp.com/attachments/669674609938792471/675887557623676948/cts.gif")
                                        .setTimestamp(Instant.now())
                                        .setColor(new Color(92, 207, 247))
                                        .build());
                                ship.changePassengers((int)-percent2*2);
                                ship.changeHappiness(-40);
                            }
                    }
                },
                5, TimeUnit.MINUTES, () -> event.reply("Sorry, you took too long to respond and died."));
        return ship;
    }


}
