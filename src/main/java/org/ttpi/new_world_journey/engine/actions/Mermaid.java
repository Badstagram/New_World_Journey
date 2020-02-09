package org.ttpi.new_world_journey.engine.actions;

import org.ttpi.new_world_journey.engine.ships.Ship;

public class Mermaid extends Action{
    public Mermaid() {
        super(10, new int[] {1,2,3});
    }
    public Ship execute(Ship ship, int argument) {
        double percent = (Math.random()*100) + 1;
        if (argument == 0){
            return ship;
        }else if(argument == 1){
            if(percent >= 1 && percent <= 50){
                executeMoreMen();
            }else{
                executeMoreWomen();
            }
        }

        return ship;
    }

    public void executeMoreMen(){

    }
    public void executeMoreWomen(){

    }
}
