package org.ttpi.new_world_journey.engine.actions;

import org.ttpi.new_world_journey.engine.ships.Ship;

public class Island extends Action {
    public Island() {
        super(10, new int[] {2,3});
    }

    public Ship execute(Ship ship, int argument) {
        double percent = (Math.random()*100) + 1;
        if (argument == 0){
            return ship;
        }else if(argument == 1){
            if(percent >= 1 && percent <= 33){
                executePirates();
            }else if(percent > 33 && percent <= 66){
                executeAbandonedShip();
            }else{
                executeMerchant();
            }
        }

        return ship;
    }

    public void executePirates(){

    }
    public void executeAbandonedShip(){

    }
    public void executeMerchant(){

    }
}
