/*
 * Copyright 2020 Test Team Pls Ignore.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ttpi.new_world_journey.engine.actions;
import org.ttpi.new_world_journey.engine.ships.Ship;


public class ShipAppears extends Action {
    private Ship ship;

    public ShipAppears() {
        super(90, new int[] {1,2,3});
    }

    public Ship execute(Ship ship, int argument) {
        double percent = (Math.random()*100) + 1;
        if (argument == 0){
            return ship;
        }else if(argument == 1){
            if(percent >= 1 && percent <= 33){

            }else if(percent > 33 && percent <= 66){

            }else{

            }
        }

        return ship;
    }

    public void executePirates(int argument){
        switch(argument){
            case 0:
            case 1:
            case 2:
        }
    }
    public void executeAbandonedShip(int argument){
        switch(argument){
            case 0:
            case 1:
            case 2:
        }
    }
    public void executeMerchant(int argument){
        switch(argument){
            case 0:
            case 1:
            case 2:
        }
    }
}
