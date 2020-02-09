package org.ttpi.new_world_journey.engine.actions;
import net.dv8tion.jda.api.entities.MessageChannel;
import org.ttpi.new_world_journey.engine.ships.Ship;

public class Cthulu extends Action {
    private Ship ship;
    MessageChannel channel;
    String discordId;
    public Cthulu(String discordId, MessageChannel channel) {
        super(1, new int[] {2,3});
        channel = channel;
        discordId = discordId;
    }

    @Override
    public Ship execute(Ship ship, int argument) {
        switch (argument){
            case 1:
            case 2:
            default:
        }

        return ship;
    }
}
