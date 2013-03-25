package com.unexpected.ant.model.entity;

import com.unexpected.ant.model.*;

import static com.unexpected.ant.skeleton_test.OutputHelper.printCurrentMethod;

/**
 * This class represents the echidna which moves on the game field and eats ants.
 */
public class Echidna extends AbstractEntity {
    private int hunger;

    private int sleepCounter;

    private Direction facingDirection;

    public Echidna(Direction facingDirection) {
        this.facingDirection = facingDirection;
    }

    @Override
    public void action(long tickCount) {
        super.action(tickCount);
        if (isHungry()) {
            eat();
        }
    }

    /**
     * The echidna eats ants
     */
    public void eat() {
        printCurrentMethod(this);
        getVisitedByEntitiesOnSameCells(new EatVisitor());
    }

    @Override
    public void acceptVisitor(EntityVisitor visitor) {
        visitor.visit(this);
    }

    /**
     * Returns if the echidna is hungry
     *
     * @return True if hungry, false otherwise
     */
    public boolean isHungry() {
        return getHunger() > 0;
    }

    /**
     * Returns the level of hunger
     *
     * @return The level of hunger
     */
    public int getHunger() {
        return hunger;
    }

    /**
     * Sets the level of hunger
     *
     * @param hunger the level of hunger
     */
    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    /**
     * Returns if the echidna is sleeping
     *
     * @return True if sleeping, false otherwise
     */
    public boolean isAsleep() {
        return sleepCounter > 0;
    }

    /**
     * Command the echidna to move
     */
    public void move() {
        printCurrentMethod(this);
        Cell nextCell = decideNextCell();
        moveTo(nextCell);
    }

    /**
     * Decides about the next cell to move on to
     *
     * @return The next cell
     */
    public Cell decideNextCell() {
        printCurrentMethod(this);
        return getCell().getNeighbours().get(0);
    }

    /**
     * Commands the echidna to sleep for the given amount of time
     *
     * @param amount The amount of time to sleep for
     */
    public void sleep(int amount) {
        sleepCounter = amount;
    }

    /**
     * The echidna moves to the given cell
     *
     * @param cell The cell to move to
     */
    public void moveTo(Cell cell) {
        printCurrentMethod(this);
        this.remove();
        cell.addEntity(this);
        this.cells.clear();
        this.cells.add(cell);

    }

    /**
     * This class is part of the visitor pattern for eating ants
     */
    protected class EatVisitor extends EntityVisitorAdapter {
        public void visit(Ant ant) {
            printCurrentMethod(this);
            hunger--;
            ant.remove();
        }
    }

}
