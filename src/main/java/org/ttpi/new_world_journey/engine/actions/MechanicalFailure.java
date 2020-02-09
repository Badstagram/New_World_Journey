package org.ttpi.new_world_journey.engine.actions;

import org.ttpi.new_world_journey.engine.ships.Ship;

public class MechanicalFailure extends Action {
    public MechanicalFailure() {
        super(30, new int[] {1,2,3});
    }
    public Ship execute(Ship ship, int argument) {
        double percent = (Math.random()*100) + 1;
        if(percent >= 1 && percent <= 20){
            executeSailTear(argument);
        }else if(percent > 21 && percent <= 40){
            executeRudderRepair(argument);
        }else if(percent > 41 && percent <= 60){
            executeLeak(argument);
        }else if(percent > 61 && percent <= 80){
            executeMastSplinter(argument);
        }else{
            executeCompassMalfunction();
        }

        return ship;
    }

    public void executeSailTear(int n){

    }
    public void executeRudderRepair(int n){

    }
    public void executeLeak(int n){

    }
    public void executeMastSplinter(int n){

    }
    public void executeCompassMalfunction(){

    }
}
