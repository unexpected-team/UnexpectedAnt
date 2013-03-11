package com.unexpected.ant.model;

import java.util.*;

public class Cell {
    private List<Entity> entities = new ArrayList<>();
    private Map<Direction, Cell> neighbours = new HashMap<>();
    private Vector vector;

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

    public Collection<Cell> getNeighbours() {
        return neighbours.values();
    }

    public Vector getVector() {
        return vector;
    }

    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }

    public void addNeighbour(Direction direction, Cell cell) {
        neighbours.put(direction, cell);
    }

    public void setVector(Vector vector) {
        this.vector = new Vector(vector);
    }

    public void visitEntities(EntityVisitor entityVisitor) {
        for (Entity entity : entities) {
            entity.acceptVisitor(entityVisitor);
        }
    }
}
