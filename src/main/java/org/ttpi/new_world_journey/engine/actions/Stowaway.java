package org.ttpi.new_world_journey.engine.actions;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.entities.MessageChannel;
import org.ttpi.new_world_journey.engine.ships.Ship;

public class Stowaway extends Action {
    private Ship ship;
    private EventWaiter waiter;
    private CommandEvent event;
    public Stowaway(EventWaiter waiter, CommandEvent event) {
        super(90, new int[] {2});
        this.waiter = waiter;
        this.event = event;
    }

}
