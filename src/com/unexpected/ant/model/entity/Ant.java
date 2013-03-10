package com.unexpected.ant.model.entity;

import com.unexpected.ant.model.AbstractEntity;
import com.unexpected.ant.model.Cell;
import com.unexpected.ant.model.Direction;

public class Ant extends AbstractEntity {
    private Direction facingDirection;

    public Ant(Direction facingDirection) {
        this.facingDirection = facingDirection;
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
}
