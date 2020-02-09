package org.ttpi.new_world_journey.engine.actions;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.ttpi.new_world_journey.engine.ships.Ship;

import java.awt.*;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class Idle extends Action {
    private EventWaiter waiter;
    private Ship ship;
    private CommandEvent event;

    public Idle(EventWaiter waiter, CommandEvent event) {
        super(150, new int[]{1, 2, 3});

    }

    @Override
    public Ship execute(Ship ship) {
        this.ship = ship;
        double percent = (Math.random() * 100) + 1;
        double percent2 = (Math.random() * 10) + 1;
        for (int i = 0; i < 2; i++) {
            event.reply(new EmbedBuilder()
                    .setTitle("Nothing at sea!")
                    .setDescription("What will you do during your time of leisure? \n'''1. Fish?\n2. Repair Ship?\n3. Party?\n4. Row'''")
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

                        switch (Integer.parseInt(e.getMessage().getContentRaw())) {
                            case 1:
                                if (percent >= 1 && percent < 33) {
                                    event.reply(new EmbedBuilder()
                                            .setTitle("You catch plenty of fish!")
                                            .setThumbnail("https://cdn.discordapp.com/attachments/669674609938792471/675887557623676948/cts.gif")
                                            .setDescription("```Your food goes up by " + ship.getPassengers() * 2 + "!")
                                            .setTimestamp(Instant.now())
                                            .setColor(new Color(92, 207, 247))
                                            .build());
                                    ship.consumeFood(-ship.getPassengers() * 2);
                                } else if (percent >= 33 && percent < 98) {
                                    event.reply(new EmbedBuilder()
                                            .setTitle("You catch a couple schools of fish")
                                            .setThumbnail("https://cdn.discordapp.com/attachments/669674609938792471/675887557623676948/cts.gif")
                                            .setDescription("```Your food goes up by " + ship.getPassengers() + "```")
                                            .setTimestamp(Instant.now())
                                            .setColor(new Color(92, 207, 247))
                                            .build());
                                    ship.consumeFood(-ship.getPassengers());
                                } else {
                                    event.reply(new EmbedBuilder()
                                            .setTitle("The fish you caught were poisonous!")
                                            .setThumbnail("https://cdn.discordapp.com/attachments/669674609938792471/675887557623676948/cts.gif")
                                            .setDescription("```Your food kills a passenger```")
                                            .setTimestamp(Instant.now())
                                            .setColor(new Color(92, 207, 247))
                                            .build());
                                    ship.changePassengers(-1);
                                    ship.changeHappiness(-10);
                                }
                                break;
                            case 2:
                                event.reply(new EmbedBuilder()
                                        .setTitle("You spend some time repairing ship")
                                        .setThumbnail("https://cdn.discordapp.com/attachments/669674609938792471/675887557623676948/cts.gif")
                                        .setDescription("```Your ship's health goes up by " + percent2 + "```")
                                        .setTimestamp(Instant.now())
                                        .setColor(new Color(92, 207, 247))
                                        .build());
                                ship.changeHealth((int) -percent2);
                                ship.changeHappiness(-3);
                                break;
                            case 3:
                                if (percent <= 1 && percent < 7) {
                                    event.reply(new EmbedBuilder()
                                            .setTitle("PARTY ON DECK!")
                                            .setThumbnail("https://cdn.discordapp.com/attachments/669674609938792471/675887557623676948/cts.gif")
                                            .setDescription("```You get black out drunk and lose " + percent2 + " men!```")
                                            .setTimestamp(Instant.now())
                                            .setColor(new Color(92, 207, 247))
                                            .build());
                                    ship.changePassengers((int) -percent2);
                                    ship.changeHappiness((int) -percent2);
                                    break;
                                } else {
                                    event.reply(new EmbedBuilder()
                                            .setTitle("Party on deck!")
                                            .setThumbnail("https://cdn.discordapp.com/attachments/669674609938792471/675887557623676948/cts.gif")
                                            .setDescription("```You have a great time with the passengers and their happiness increases```")
                                            .setTimestamp(Instant.now())
                                            .setColor(new Color(92, 207, 247))
                                            .build());
                                    ship.changeHappiness(30);
                                }
                                break;
                            case 4:
                                if (percent >= 1 && percent < 30) {
                                    event.reply(new EmbedBuilder()
                                            .setTitle("Great rowing!")
                                            .setThumbnail("https://cdn.discordapp.com/attachments/669674609938792471/675887557623676948/cts.gif")
                                            .setDescription("```You increase your speed two-fold!```")
                                            .setTimestamp(Instant.now())
                                            .setColor(new Color(92, 207, 247))
                                            .build());
                                    ship.progressShip(ship.getSpeedOfShip());
                                } else {
                                    event.reply(new EmbedBuilder()
                                            .setTitle("Good rowing")
                                            .setThumbnail("https://cdn.discordapp.com/attachments/669674609938792471/675887557623676948/cts.gif")
                                            .setDescription("```You increase your speed a bit```")
                                            .setTimestamp(Instant.now())
                                            .setColor(new Color(92, 207, 247))
                                            .build());
                                    ship.progressShip(ship.getSpeedOfShip() / 2);
                                }

                        }

                    },
                    5, TimeUnit.MINUTES, () -> event.reply("Sorry, you took too long to respond and died."));
        }
        return ship;
    }
}
