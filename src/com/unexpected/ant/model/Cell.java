package com.unexpected.ant.model;

import java.util.List;
import java.util.Map;

public class Cell {
    private Position position;
    private List<Entity> entities;
    private Map<Direction, Cell> neighbours;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = new Position(position);
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }

    public Cell getNeighbour(Direction direction) {
        return neighbours.get(direction);
    }


    public void visitByAllEntities(Visitable visitable) {
        for (Entity entity : entities) {
            visitable.visit(entity);
        }
    }

    public boolean canBeSteppedOnBy(Entity subject) {
        for (Entity entity : entities) {
            if (!entity.canBeOnSameCellWith(subject) || !subject.canBeOnSameCellWith(entity)) {
                return false;
            }
        }
        return true;
    }
}
