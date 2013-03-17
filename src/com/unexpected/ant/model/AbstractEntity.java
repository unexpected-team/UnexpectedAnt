package com.unexpected.ant.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.unexpected.ant.skeleton_test.OutputHelper.printCurrentMethod;

public abstract class AbstractEntity implements Entity, Dynamic {
    protected List<Cell> cells = new ArrayList<>();


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
        printCurrentMethod();
        return true;
    }

    protected void getVisitedByEntitiesOnSameCells(EntityVisitor entityVisitor) {
        printCurrentMethod();
        for (Cell cell : getCells()) {
            cell.visitEntities(entityVisitor);
        }
    }

    public void remove() {
        printCurrentMethod();
        for (Cell cell : getCells()) {
            cell.removeEntity(this);
        }
    }

    @Override
    public List<Cell> getCells() {
        return Collections.unmodifiableList(cells);
    }

    public Cell getCell() {
        return getCells().get(0);
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
