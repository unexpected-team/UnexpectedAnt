package com.unexpected.ant.model.entity;

import com.unexpected.ant.model.AbstractEntity;
import com.unexpected.ant.model.Cell;
import com.unexpected.ant.model.EntityVisitor;
import com.unexpected.ant.model.EntityVisitorAdapter;

import static com.unexpected.ant.skeleton_test.OutputHelper.printCurrentMethod;

public class Echidna extends AbstractEntity {
    private int hunger;
    private int sleepCounter;

    @Override
    public void action(long tickCount) {
        super.action(tickCount);
        if (isHungry()) {
            eat();
        }
    }

    public void eat() {
        printCurrentMethod();
        getVisitedByEntitiesOnSameCells(new EatVisitor());
    }

    @Override
    public void acceptVisitor(EntityVisitor visitor) {
        visitor.visit(this);
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
        printCurrentMethod();
        Cell nextCell = decideNextCell();
        moveTo(nextCell);
    }

    public Cell decideNextCell() {
        printCurrentMethod();
        return getCell().getNeighbours().get(0);
    }

    public void sleep(int amount) {
        sleepCounter = amount;
    }

    public void moveTo(Cell cell) {
        printCurrentMethod();
        this.remove();
        cell.addEntity(this);
        this.cells.clear();
        this.cells.add(cell);

    }

    protected class EatVisitor extends EntityVisitorAdapter {
        public void visit(Ant ant) {
            printCurrentMethod();
            hunger--;
            ant.remove();
        }
    }

}
