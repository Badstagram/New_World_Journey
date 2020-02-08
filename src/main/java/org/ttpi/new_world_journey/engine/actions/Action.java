package org.ttpi.new_world_journey.engine.actions;

public class Action {
    private int weight;
    public int[] restrictedMonths;

    public Action(int weight, int[] restrictedMonths) {
        this.restrictedMonths = restrictedMonths;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
