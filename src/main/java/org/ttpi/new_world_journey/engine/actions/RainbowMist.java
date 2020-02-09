package org.ttpi.new_world_journey.engine.actions;

import org.ttpi.new_world_journey.engine.ships.Ship;

public class RainbowMist extends Action {
    public RainbowMist() {
        super(1, new int[] {2});
    }
    public Ship execute(Ship ship, int argument) {
        switch (argument){
            case 1:
            case 2:
            default:
        }

        return ship;
    }
}
