package org.ttpi.new_world_journey.engine.actions;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.entities.MessageChannel;
import org.ttpi.new_world_journey.engine.ships.Ship;

public class MechanicalFailure extends Action {
    private Ship ship;
    private EventWaiter waiter;
    private CommandEvent event;
    public MechanicalFailure(EventWaiter waiter, CommandEvent event) {
        super(30, new int[] {1,2,3});
        this.waiter = waiter;
        this.event = event;
    }
    public Ship execute(Ship ship, int argument) {
        System.out.println("[EVENT] - Mechanic Failure");
        this.ship = ship;
        double percent = (Math.random()*100) + 1;
        if(percent >= 1 && percent <= 20){
            executeSailTear(argument);
        }else if(percent > 21 && percent <= 40){
            executeRudderRepair(argument);
        }else if(percent > 41 && percent <= 60){
            executeLeak(argument);
        }else if(percent > 61 && percent <= 80){
            executeMastSplinter(argument);
        }else{
            executeCompassMalfunction();
        }

        return ship;
    }

    public void executeSailTear(int n){

    }
    public void executeRudderRepair(int n){

    }
    public void executeLeak(int n){

    }
    public void executeMastSplinter(int n){

    }
    public void executeCompassMalfunction(){

    }
}
