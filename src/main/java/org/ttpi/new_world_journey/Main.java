package org.ttpi.new_world_journey;

import org.ttpi.new_world_journey.engine.Engine;

public class Main {
    public static void main(String[] args) {
        Engine controller = new Engine("1", "mayflower");
        controller.nextTick();
        controller.getShip();
        controller.getCurrentMonth();
        controller.getTargetDistance();
        controller.getShipName();
        controller.getTicksThisMonth();


    }
}
