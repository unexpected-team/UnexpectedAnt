package com.unexpected.ant.model.entity;

import com.unexpected.ant.model.*;

import static com.unexpected.ant.skeleton_test.OutputHelper.printCurrentMethod;

public class Ant extends AbstractEntity {
    private Direction facingDirection;

    public Ant(Direction facingDirection) {
        this.facingDirection = facingDirection;
    }

    @Override
    public void acceptVisitor(EntityVisitor visitor) {
        printCurrentMethod();
        visitor.visit(this);
    }

    @Override
    public void action(long tickCount) {
        printCurrentMethod();
        move();
    }

    public void move() {
        printCurrentMethod();
        remove();
        Cell nextCell = decideNextCell();
        moveTo(nextCell);
    }

    public void moveTo(Cell cell) {
        printCurrentMethod();
        this.remove();
        cell.addEntity(this);
        this.cells.clear();
        this.cells.add(cell);

    }

    protected Cell decideNextCell() {
        printCurrentMethod();
        Cell nextCell = getCell();
        for (Cell cell : getCell().getNeighbours()) {
            if (cell.canBeSteppedOnBy(this)) {
                nextCell = cell;
            }
        }

        return nextCell;

    }

    public Direction getFacingDirection() {
        printCurrentMethod();
        return facingDirection;
    }

    public void setFacingDirection(Direction facingDirection) {
        printCurrentMethod();
        this.facingDirection = facingDirection;
    }

    protected class SmellVisitor extends EntityVisitorAdapter {
        //TODO: hogyan számoljuk, hogy merre menjen
        @Override
        public void visit(FoodSmell smell) {

        }

        @Override
        public void visit(AntSmell smell) {

        }
    }

    protected class EatVisitor extends EntityVisitorAdapter {
        @Override
        public void visit(Food food) {
            food.remove();

        }
    }
}
