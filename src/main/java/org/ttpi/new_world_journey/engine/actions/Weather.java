package org.ttpi.new_world_journey.engine.actions;

import org.ttpi.new_world_journey.engine.ships.Ship;

public class Weather extends Action {
    private Ship ship;
    public Weather() {
        super(90, new int[] {1,2,3});
    }
    public Ship execute(Ship ship, int argument) {
        double percent = (Math.random()*100) + 1;
            if(percent >= 1 && percent <= 20){
                executeFog();
            }else if(percent > 20 && percent <= 30){
                executeWhirlpool(argument);
            }else if(percent > 30 && percent <= 80){
                executeStorm(argument);
            }else if(percent > 80 && percent <= 89){
                executeHurricane(argument);
            }else{
                executeRainingFish();
            }

        return ship;
    }

    //Decisions for you coming across a whirlpool
    public void executeWhirlpool(int n){
        switch(n){
            case 0:
                //Lose half of passengers and ship is badly damaged
                ship.changePassengers(-1*(ship.getPassengers()/2));
                ship.changeHealth(-20);
                break;
            case 1:
                //Escape whirlpool, but everyone is scared
                ship.changePassengers(-2);
                ship.changeHappiness(-5);
                break;
            case 2:
                //The gods of the sea smile on you and you are saved
                ship.changeHappiness(15);
                ship.changeHealth(-15);
                break;
        }
    }
    public void executeFog(){
        //People escape in the fog
        if(ship.getHappiness() <= 40){
            ship.changePassengers(-5);
        }
        ship.
    }
    public void executeStorm(int n){

    }
    public void executeHurricane(int n){

    }
    public void executeRainingFish(){

    }
}
