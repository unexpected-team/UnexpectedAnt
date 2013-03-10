package com.unexpected.ant.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cell {
    private List<Entity> entities = new ArrayList<>();
    private Map<Direction, Cell> neighbours = new HashMap<>();
    private Position position;

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public boolean canBeSteppedOnBy(Entity subject) {
        for (Entity entity : entities) {
            if (!entity.canBeOnSameCellWith(subject) || !subject.canBeOnSameCellWith(entity)) {
                return false;
            }
        }
        return true;
    }

    public Cell getNeighbour(Direction direction) {
        return neighbours.get(direction);
    }

    public Position getPosition() {
        return position;
    }

    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }

    public void setNeighbour(Direction direction, Cell cell) {
        neighbours.put(direction, cell);
    }

    public void setPosition(Position position) {
        this.position = new Position(position);
    }

    public void visitByAllEntities(EntityVisitor entityVisitor) {
        for (Entity entity : entities) {
            entityVisitor.visit(entity);
        }
    }
}
