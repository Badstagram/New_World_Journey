package org.ttpi.new_world_journey.engine.actions;

import org.ttpi.new_world_journey.engine.ships.Ship;

public class Kraken extends Action {
    public int[] restrictedMonths = {1, 2};
    private Ship ship;

    public Ship execute(Ship ship, int argument) {
        switch (argument){
            case 1:
            case 2:
            default:
        }

        return ship;
    }
}
