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
        decideNextCell();
    }

    protected Cell decideNextCell() {
        printCurrentMethod();
        return null;
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
