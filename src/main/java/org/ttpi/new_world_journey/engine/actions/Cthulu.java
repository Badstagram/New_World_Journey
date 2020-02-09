package org.ttpi.new_world_journey.engine.actions;
import org.ttpi.new_world_journey.engine.ships.Ship;

public class Cthulu extends Action {
    private Ship ship;
    public Cthulu() {
        super(1, new int[] {2,3});
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
