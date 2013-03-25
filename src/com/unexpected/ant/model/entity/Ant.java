package com.unexpected.ant.model.entity;

import com.unexpected.ant.model.*;

import static com.unexpected.ant.skeleton_test.OutputHelper.printCurrentMethod;

/**
 * This class represents an ant in the game.
 */
public class Ant extends AbstractEntity {
    private Direction facingDirection;
    private Food food;

    /**
     * Constructor
     *
     * @param facingDirection The original facing direction of the ant
     */
    public Ant(Direction facingDirection) {
        this.facingDirection = facingDirection;
    }

    @Override
    public void acceptVisitor(EntityVisitor visitor) {
        printCurrentMethod(this);
        visitor.visit(this);
    }

    @Override
    public void action(long tickCount) {
        printCurrentMethod(this);
        move();
    }

    /**
     * The ant eats if it's hungry
     */
    public void eat() {
        printCurrentMethod(this);
        if (!hasFood()) {
            getVisitedByEntitiesOnSameCells(new EatVisitor());
        }
    }

    /**
     * Return whether the ant has food
     *
     * @return True, if the ant has food, false otherwise
     */
    public boolean hasFood() {
        printCurrentMethod(this);
        return food != null;
    }

    /**
     * The ant moves
     */
    public void move() {
        printCurrentMethod(this);
        remove();
        Cell nextCell = decideNextCell();
        moveTo(nextCell);
    }

    /**
     * The ant moves to the given cell
     *
     * @param cell The moves to this cell
     */
    public void moveTo(Cell cell) {
        printCurrentMethod(this);
        this.remove();
        cell.addEntity(this);
        this.cells.clear();
        this.cells.add(cell);

    }

    /**
     * The ant decides the next cell to be moved on to
     *
     * @return The cell
     */
    protected Cell decideNextCell() {
        printCurrentMethod(this);
        Cell nextCell = getCell();
        for (Cell cell : getCell().getNeighbours()) {
            if (cell.canBeSteppedOnBy(this)) {
                nextCell = cell;
            }
        }

        return nextCell;

    }

    /**
     * @return The facing direction
     */
    public Direction getFacingDirection() {
        printCurrentMethod(this);
        return facingDirection;
    }

    /**
     * Sets the facing direction
     *
     * @param facingDirection
     */
    public void setFacingDirection(Direction facingDirection) {
        printCurrentMethod(this);
        this.facingDirection = facingDirection;
    }

    /**
     * This class is for smelling the surrounding cells
     */
    protected class SmellVisitor extends EntityVisitorAdapter {
        //TODO: hogyan számoljuk, hogy merre menjen
        @Override
        public void visit(FoodSmell smell) {

        }

        @Override
        public void visit(AntSmell smell) {

        }
    }

    /**
     * This class is for eating food
     */
    protected class EatVisitor extends EntityVisitorAdapter {
        @Override
        public void visit(Food food) {
            if (!Ant.this.hasFood()) {
                food.remove();
                Ant.this.food = food;
            }
        }
    }
}
