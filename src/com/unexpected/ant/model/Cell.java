package com.unexpected.ant.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.unexpected.ant.skeleton_test.OutputHelper.printCurrentMethod;

public class Cell {
    private List<Entity> entities = new ArrayList<>();
    private Map<Direction, Cell> neighbours = new HashMap<>();
    private Vector position;

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void addNeighbour(Direction direction, Cell cell) {
        printCurrentMethod();
        if (cell == null) {
            return;
        }
        neighbours.put(direction, cell);
        if (!this.equals(cell.getNeighbour(direction.getOpposite()))) {
            cell.addNeighbour(direction.getOpposite(), this);
        }
    }

    public boolean canBeSteppedOnBy(Entity subject) {
        printCurrentMethod();
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

    public List<Cell> getNeighbours() {
        return new ArrayList<>(neighbours.values());
    }

    public Vector getPosition() {
        return position;
    }

    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }

    public void setPosition(Vector position) {
        this.position = new Vector(position);
    }

    public void visitEntities(EntityVisitor entityVisitor) {
        printCurrentMethod();
        for (Entity entity : entities) {
            entity.acceptVisitor(entityVisitor);
        }
    }

    public boolean equals(Object other) {
        return other instanceof Cell && other != null && other == this;
    }
}
