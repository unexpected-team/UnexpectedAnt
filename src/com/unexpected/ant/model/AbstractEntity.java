package com.unexpected.ant.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractEntity implements Entity, Dynamic {
    private List<Cell> cells = new ArrayList<>();


    @Override
    public void action(long tickCount) {

    }

    public void acceptVisitor(EntityVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void addCell(Cell cell) {
        cells.add(cell);
    }

    @Override
    public boolean canBeOnSameCellWith(Entity entity) {
        return true;
    }

    protected void getVisitedByEntitiesOnSameCells(EntityVisitor entityVisitor) {
        for (Cell cell : getCells()) {
            cell.visitEntities(entityVisitor);
        }
    }

    public void remove() {
        for (Cell cell : getCells()) {
            cell.removeEntity(this);
        }
    }

    @Override
    public List<Cell> getCells() {
        return Collections.unmodifiableList(cells);
    }

    @Override
    public void removeCell(Cell cell) {
        cells.remove(cell);
    }

    @Override
    public void removeCells(List<Cell> cells) {
        this.cells.removeAll(cells);
    }

    @Override
    public void setCells(List<Cell> cells) {
        this.cells = new ArrayList<>(cells);
    }
}
