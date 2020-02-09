package org.ttpi.new_world_journey.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.ttpi.new_world_journey.engine.Engine;

import java.awt.*;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class Start extends Command {

    private final EventWaiter waiter;

    public Start(EventWaiter waiter) {
        this.waiter = waiter;
        this.name = "start";
        this.aliases = new String[]{"st"};
        this.help = "Starts the game.";
    }

    @Override
    protected void execute(CommandEvent event) {
        event.reply(
             new EmbedBuilder()
                     .setTitle("A message from the king!")
                     .setDescription("A message appears with the kings official seal, do you choose to read the letter? \nRespond with (`yes`/`no`)")
                     .setThumbnail("https://i.imgur.com/nlHCKYq.gif")
                     .setTimestamp(Instant.now())
                     .setColor(new Color(92, 207, 247))
                     .build()
        );

        waiter.waitForEvent(MessageReceivedEvent.class,

                //filtering
                e -> e.getAuthor().equals(event.getAuthor())
                        && e.getChannel().equals(event.getChannel())
                        && !e.getMessage().equals(event.getMessage()),

                // event executions
                e -> {
                    String response = e.getMessage().getContentRaw().toLowerCase();
                    if(response.equals("no")) {
                        event.reply(new EmbedBuilder()
                                .setTitle("Game Over.")
                                .setDescription("You failed to respond to the king.")
                                .setTimestamp(Instant.now())
                                .setColor(new Color(92, 207, 247))
                                .build());
                    }
                    if(response.equals("yes")) {
                        event.reply(new EmbedBuilder()
                                .setTitle("Pick a ship!")
                                .setDescription("The king is pleased to hear back from you! He ask you to go on a voyage, please respond with one of the following ships.\n```Caravel\nEndurance\nMayflower\nSantaMaria\nTrinidad```")
                                .setTimestamp(Instant.now())
                                .setThumbnail("https://i.imgur.com/nlHCKYq.gif")
                                .setColor(new Color(92, 207, 247))
                                .build());
                        declareShip(event);
                    }
                },
                // if the user takes more than a minute, time out
                5, TimeUnit.MINUTES, () -> event.reply("Sorry, you took too long to respond and died."));
    }

    public void declareShip(CommandEvent event) {
        waiter.waitForEvent(MessageReceivedEvent.class,

                //filtering
                e -> e.getAuthor().equals(event.getAuthor())
                        && e.getChannel().equals(event.getChannel())
                        && !e.getMessage().equals(event.getMessage()),

                // event executions
                e -> {
                    String response = e.getMessage().getContentRaw().toLowerCase();
                    if(!response.equals("caravel") && !response.equals("endurance") && !response.equals("mayflower") && !response.equals("santamaria") && !response.equals("trinidad")) {
                        event.reply(new EmbedBuilder()
                                .setTitle("Error!")
                                .setDescription("Invalid ship choice! Please try again.")
                                .setTimestamp(Instant.now())
                                .setColor(new Color(92, 207, 247))
                                .build());
                        declareShip(event);
                    } else {
                        event.reply(new EmbedBuilder()
                                .setTitle("Pick a ship!")
                                .setDescription("Great choice! The king is excited to hear about your travels!")
                                .setTimestamp(Instant.now())
                                .setThumbnail("https://i.imgur.com/nlHCKYq.gif")
                                .setColor(new Color(92, 207, 247))
                                .build());
                        Engine gameEngine = new Engine(waiter, event, response);
                        gameEngine.start();
                    }
                },
                // if the user takes more than a minute, time out
                5, TimeUnit.MINUTES, () -> event.reply("Sorry, you took too long to respond and died."));
    }
}
