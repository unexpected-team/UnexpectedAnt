package com.unexpected.ant.model.entity;

import com.unexpected.ant.model.AbstractEntity;
import com.unexpected.ant.model.EntityVisitorAdapter;

public class Echidna extends AbstractEntity {
    private int hunger;
    private int sleepCounter;

    @Override
    public void action(long tickCount) {
        super.action(tickCount);
        if (isHungry()) {
            getVisitedByAllEntitiesOnSameCells(new EchidnaEatVisitor());
        }
    }

    public boolean isHungry() {
        return getHunger() > 0;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public boolean isAsleep() {
        return sleepCounter > 0;
    }

    public void move() {

    }

    public void sleep(int amount) {
        sleepCounter = amount;
    }

    protected class EchidnaEatVisitor extends EntityVisitorAdapter {
        public void visit(Ant ant) {
            hunger--;
            ant.remove();
        }
    }
}
