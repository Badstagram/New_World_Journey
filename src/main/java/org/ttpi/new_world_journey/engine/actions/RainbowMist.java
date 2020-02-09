package org.ttpi.new_world_journey.engine.actions;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.entities.MessageChannel;
import org.ttpi.new_world_journey.engine.ships.Ship;

public class RainbowMist extends Action {
    private Ship ship;
    private EventWaiter waiter;
    private CommandEvent event;
    public RainbowMist(EventWaiter waiter, CommandEvent event) {
        super(1, new int[] {2});
        this.waiter = waiter;
        this.event = event;
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
