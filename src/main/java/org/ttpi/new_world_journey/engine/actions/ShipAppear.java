package org.ttpi.new_world_journey.engine.actions;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.ttpi.new_world_journey.engine.ships.Ship;

import java.awt.*;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class ShipAppear extends Action {
    private EventWaiter waiter;
    private CommandEvent event;
    private Ship ship;
    public ShipAppear(EventWaiter waiter, CommandEvent event) {
        super(10, new int[] {2,3});
        this.waiter = waiter;
        this.event = event;
    }

    public Ship execute(Ship ship) {
        System.out.println("[EVENT] - Island");
        this.ship = ship;
        double percent = (Math.random() * 100) + 1;
        double percent2 = (Math.random()*500) + 100;
        double percent3 = (Math.random()*100) + 1;
        event.reply(new EmbedBuilder()
                .setTitle("Your man in the crows nest cries out that there is a ship in the distance")
                .setDescription("```Will you investigate? \n1. yes\n2. no```")
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
                    switch(e.getMessage().getContentRaw()){
                        case "yes":
                            if(percent >= 1 && percent < 33){
                                event.reply(new EmbedBuilder()
                                        .setTitle("As you approach, you notice a jolly roger")
                                        .setDescription("```Will you fight or flee? \n1. fight\n2. flee```")
                                        .setThumbnail("https://cdn.discordapp.com/attachments/669674609938792471/675887557623676948/cts.gif")
                                        .setTimestamp(Instant.now())
                                        .setColor(new Color(92, 207, 247))
                                        .build());
                                        waiter.waitForEvent(MessageReceivedEvent.class,
                                        f -> f.getAuthor().equals(event.getAuthor())
                                            && f.getChannel().equals(event.getChannel())
                                            && !f.getMessage().equals(event.getMessage()),

                                            // event executions
                                            f -> {
                                                switch(f.getMessage().getContentRaw()) {
                                                    case "fight":
                                                        if (ship.getDamageCapabilities() >= 10) {
                                                            if (percent3 >= 1 && percent3 < 50) {
                                                                event.reply(new EmbedBuilder()
                                                                        .setTitle("You manage to overwhelm the pirates!")
                                                                        .setDescription("```You gain their treasure (" + percent2 + " coins) and the loyalty of ten of their men```")
                                                                        .setThumbnail("https://cdn.discordapp.com/attachments/669674609938792471/675887557623676948/cts.gif")
                                                                        .setTimestamp(Instant.now())
                                                                        .setColor(new Color(92, 207, 247))
                                                                        .build());
                                                                ship.changeCoins((int) percent2);
                                                                ship.changePassengers(10);
                                                            } else {
                                                                event.reply(new EmbedBuilder()
                                                                        .setTitle("The pirates overwhelm you!")
                                                                        .setDescription("```They steal some treasure (" + percent2 + " coins) and the loyalty of ten of your men!```")
                                                                        .setThumbnail("https://cdn.discordapp.com/attachments/669674609938792471/675887557623676948/cts.gif")
                                                                        .setTimestamp(Instant.now())
                                                                        .setColor(new Color(92, 207, 247))
                                                                        .build());
                                                                ship.changeCoins((int) -percent2);
                                                                ship.changeHealth(-20);
                                                                ship.changePassengers(-10);
                                                            }
                                                        } else {
                                                            if (percent3 >= 1 && percent3 < 30) {
                                                                event.reply(new EmbedBuilder()
                                                                        .setTitle("You manage to overwhelm the pirates!")
                                                                        .setDescription("```You gain their treasure (" + percent3 + " coins) and the loyalty of ten of their men```")
                                                                        .setThumbnail("https://cdn.discordapp.com/attachments/669674609938792471/675887557623676948/cts.gif")
                                                                        .setTimestamp(Instant.now())
                                                                        .setColor(new Color(92, 207, 247))
                                                                        .build());
                                                                ship.changeCoins((int) percent3);
                                                                ship.changePassengers(10);
                                                            } else {
                                                                event.reply(new EmbedBuilder()
                                                                        .setTitle("The pirates overwhelm you!")
                                                                        .setDescription("```They steal some treasure (" + percent2 + " coins) and the loyalty of ten of your men!```")
                                                                        .setThumbnail("https://cdn.discordapp.com/attachments/669674609938792471/675887557623676948/cts.gif")
                                                                        .setTimestamp(Instant.now())
                                                                        .setColor(new Color(92, 207, 247))
                                                                        .build());
                                                                ship.changeCoins((int) -percent2);
                                                                ship.changeHappiness(-20);
                                                                ship.changeHealth(-20);
                                                                ship.changePassengers(-10);
                                                            }
                                                        }
                                                        break;
                                                    case "flee":
                                                        if (ship.getSpeedOfShip() >= 200) {
                                                            if (percent3 >= 1 && percent3 < 50) {
                                                                event.reply(new EmbedBuilder()
                                                                        .setTitle("You manage to escape the pirates!")
                                                                        .setDescription("```You gain nothing but the being able to keep the skin on your back```")
                                                                        .setThumbnail("https://cdn.discordapp.com/attachments/669674609938792471/675887557623676948/cts.gif")
                                                                        .setTimestamp(Instant.now())
                                                                        .setColor(new Color(92, 207, 247))
                                                                        .build());
                                                            } else {
                                                                event.reply(new EmbedBuilder()
                                                                        .setTitle("The pirates overwhelm you!")
                                                                        .setDescription("```They steal some treasure (" + percent2 + " coins) and the loyalty of ten of your men!```")
                                                                        .setThumbnail("https://cdn.discordapp.com/attachments/669674609938792471/675887557623676948/cts.gif")
                                                                        .setTimestamp(Instant.now())
                                                                        .setColor(new Color(92, 207, 247))
                                                                        .build());
                                                                ship.changeCoins((int) -percent2);
                                                                ship.changeHappiness(-20);
                                                                ship.changeHealth(-20);
                                                                ship.changePassengers(-10);
                                                            }
                                                        } else {
                                                            if (percent3 >= 1 && percent3 < 30) {
                                                                event.reply(new EmbedBuilder()
                                                                        .setTitle("You manage to escape the pirates!")
                                                                        .setDescription("```You gain nothing but the being able to keep the skin on your back```")
                                                                        .setThumbnail("https://cdn.discordapp.com/attachments/669674609938792471/675887557623676948/cts.gif")
                                                                        .setTimestamp(Instant.now())
                                                                        .setColor(new Color(92, 207, 247))
                                                                        .build());
                                                            } else {
                                                                event.reply(new EmbedBuilder()
                                                                        .setTitle("The pirates overwhelm you!")
                                                                        .setDescription("```They steal some treasure (" + percent2 + " coins) and the loyalty of ten of your men!```")
                                                                        .setThumbnail("https://cdn.discordapp.com/attachments/669674609938792471/675887557623676948/cts.gif")
                                                                        .setTimestamp(Instant.now())
                                                                        .setColor(new Color(92, 207, 247))
                                                                        .build());
                                                                ship.changeCoins((int) -percent2);
                                                                ship.changeHealth(-20);
                                                                ship.changeHappiness(-20);
                                                                ship.changePassengers(-10);
                                                            }
                                                        }
                                                        break;
                                                }
                                            },
                                            5, TimeUnit.MINUTES, () -> event.reply("Sorry, you took too long to respond and died."));
                            }else if(percent >=33 && percent < 66){
                                event.reply(new EmbedBuilder()
                                        .setTitle("As you approach, you realize that it is an abandoned ship")
                                        .setDescription("```You are awarded with  + " + percent2 + " amount of coins```")
                                        .setThumbnail("https://cdn.discordapp.com/attachments/669674609938792471/675887557623676948/cts.gif")
                                        .setTimestamp(Instant.now())
                                        .setColor(new Color(92, 207, 247))
                                        .build());
                                ship.changeCoins((int)percent2);
                            }else{
                                while(true){
                                    event.reply(new EmbedBuilder()
                                            .setTitle("As you approach, you realize that it is a merchant ship")
                                            .setDescription("```What do you want to do?\n1. Buy\n 2. Sell\n 3. Leave```")
                                            .setThumbnail("https://cdn.discordapp.com/attachments/669674609938792471/675887557623676948/cts.gif")
                                            .setTimestamp(Instant.now())
                                            .setColor(new Color(92, 207, 247))
                                            .build());
                                    waiter.waitForEvent(MessageReceivedEvent.class,

                                            //filtering
                                            g -> g.getAuthor().equals(event.getAuthor())
                                                    && g.getChannel().equals(event.getChannel())
                                                    && !g.getMessage().equals(event.getMessage()),

                                            // event executions
                                            g -> {
                                                switch(Integer.parseInt(g.getMessage().getContentRaw())){
                                                    case 1:
                                                        event.reply(new EmbedBuilder()
                                                                .setTitle("The man approaches you sensually")
                                                                .setDescription("```I have ... food. 10 provisions for 200 gold\n 1. Buy\n 2. Don't```")
                                                                .setThumbnail("https://cdn.discordapp.com/attachments/669674609938792471/675887557623676948/cts.gif")
                                                                .setTimestamp(Instant.now())
                                                                .setColor(new Color(92, 207, 247))
                                                                .build());
                                                        waiter.waitForEvent(MessageReceivedEvent.class,

                                                                //filtering
                                                                h -> h.getAuthor().equals(event.getAuthor())
                                                                        && h.getChannel().equals(event.getChannel())
                                                                        && !h.getMessage().equals(event.getMessage()),

                                                                // event executions
                                                                h -> {
                                                                    switch(Integer.parseInt(h.getMessage().getContentRaw())){
                                                                        
                                                                    }
                                                                },5, TimeUnit.MINUTES, () -> event.reply("Sorry, you took too long to respond and died."));

                                                }
                                            },5, TimeUnit.MINUTES, () -> event.reply("Sorry, you took too long to respond and died."));

                                }

                            }

                    }
                },
                5, TimeUnit.MINUTES, () -> event.reply("Sorry, you took too long to respond and died."));


        return ship;
    }
    }


