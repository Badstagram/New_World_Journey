package org.ttpi.new_world_journey.engine.events;

import org.ttpi.new_world_journey.engine.ships.Ship;

public class Kraken {
    private int weight = 10;
    private Ship ship;

    public Ship execute(Ship ship, int argument) {
        switch (argument){
            case 1:
            case 2:
            default:
        }

        return ship;
    }

    public int getWeight() {
        return weight;
    }
}
