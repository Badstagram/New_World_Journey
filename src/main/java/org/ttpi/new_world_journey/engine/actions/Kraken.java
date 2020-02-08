package org.ttpi.new_world_journey.engine.actions;

import org.ttpi.new_world_journey.engine.ships.Ship;

public class Kraken extends Action {
    private Ship ship;

    public Kraken() {
        super(10, new int[]{2,3});
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
