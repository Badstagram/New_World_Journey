package org.ttpi.new_world_journey.engine.actions;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.entities.MessageChannel;
import org.ttpi.new_world_journey.engine.ships.Ship;

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
        if (percent >= 1 && percent <= 20) {
            //executeScurvy(argument);
        } else if (percent > 20 && percent <= 30) {
            //executeDisentary(argument);
        } else {
            //executeFlu(argument);
        }
        return ship;
    }

    public void executeScurvy(int n){

    }
    public void executeDisentary(int n){

    }
    public void executeFlu(int n){

    }
}
