package org.ttpi.new_world_journey.engine.actions;

import org.ttpi.new_world_journey.engine.ships.Ship;

public class Diseases extends Action {

    public Diseases() {
        super(90, new int[]{2, 3});
    }

    public Ship execute(Ship ship, int argument) {
        double percent = (Math.random() * 100) + 1;
        if (percent >= 1 && percent <= 20) {
            executeScurvy(argument);
        } else if (percent > 20 && percent <= 30) {
            executeDisentary(argument);
        } else (percent > 30 && percent <= 100) {
            executeFlu(argument);

            return ship;
        }
    }

    public void executeScurvy(int n){

    }
    public void executeDisentary(int n){

    }
    public void executeFlu(int n){

    }
}
