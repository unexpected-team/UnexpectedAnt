package com.unexpected.ant.model.entity;

import com.unexpected.ant.model.*;

public class Ant extends AbstractEntity {
    private Direction facingDirection;

    public Ant(Direction facingDirection) {
        this.facingDirection = facingDirection;
    }

    @Override
    public void acceptVisitor(EntityVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void action(long tickCount) {
        move();
    }

    public void move() {
    }

    protected Cell decideNextCell() {
        return getCells().get(0);
    }

    public Direction getFacingDirection() {
        return facingDirection;
    }

    public void setFacingDirection(Direction facingDirection) {
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
