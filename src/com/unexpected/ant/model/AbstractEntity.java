package com.unexpected.ant.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.unexpected.ant.skeleton_test.OutputHelper.printCurrentMethod;

/**
 * This class represent the default implementation of an entity on the game field
 */
public abstract class AbstractEntity implements Entity, Dynamic {
    protected List<Cell> cells = new ArrayList<>();

    @Override
    public void acceptVisitor(EntityVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void action(long tickCount) {

    }

    @Override
    public void addCell(Cell cell) {
        cells.add(cell);
    }

    @Override
    public boolean canBeOnSameCellWith(Entity entity) {
        printCurrentMethod(this);
        return true;
    }

    /**
     * Returns the first cell of the shape, useful for entities containing only one cell
     *
     * @return The first cell
     */
    public Cell getCell() {
        return getCells().get(0);
    }

    /**
     * The given visitor gets visited by all entity on same cells
     *
     * @param entityVisitor The visitor to be visited
     */
    protected void getVisitedByEntitiesOnSameCells(EntityVisitor entityVisitor) {
        printCurrentMethod(this);
        for (Cell cell : getCells()) {
            cell.visitEntities(entityVisitor);
        }
    }

    @Override
    public List<Cell> getCells() {
        return Collections.unmodifiableList(cells);
    }

    @Override
    public void remove() {
        printCurrentMethod(this);
        for (Cell cell : getCells()) {
            cell.removeEntity(this);
        }
    }

    @Override
    public void removeCell(Cell cell) {
        cells.remove(cell);
    }

    @Override
    public void removeCells(List<Cell> cells) {
        this.cells.removeAll(cells);
    }

    /**
     * Sets one cell for the entity's shape
     *
     * @param cell
     */
    public void setCell(Cell cell) {
        printCurrentMethod(this);
        cells.clear();
        cells.add(cell);
        cell.addEntity(this);
    }

    @Override
    public void setCells(List<Cell> cells) {
        this.cells = new ArrayList<>(cells);
    }
}
