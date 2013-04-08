package com.unexpected.ant.model;

import com.unexpected.ant.model.entity.Echidna;

import java.util.List;

/**
 * All entities on the game field must implement this interface
 */
public interface Entity {
    /**
     * Adds a cell to the entity's shape
     *
     * @param cell The cell to be added
     */
    public void addCell(Cell cell);

    /**
     * Tells, whether this entity can be on the same cell with the entity given in the parameter
     *
     * @param entity
     * @return True if this entity can be on the same cell with the entity given, otherwise false
     */
    boolean canBeOnSameCellWith(Entity entity);

    boolean canBeSteppedOnBy(Echidna entity);

    /**
     * @return The list of cells which contain this entity
     */
    public List<Cell> getCells();

    /**
     * Remove the entity from the field
     */
    void remove();

    /**
     * Removes the given cell from the entity's shape
     *
     * @param cell The cell to be removed
     */
    public void removeCell(Cell cell);

    /**
     * Removes the cells from entity's shape
     *
     * @param cells Cells to be removed
     */
    public void removeCells(List<Cell> cells);


    /**
     * Set the cells which the entity's shape consists of
     *
     * @param cells Cells to be set
     */
    public void setCells(List<Cell> cells);

    /**
     * Accept a visitor, used for the visitor pattern, each entity to be visited should override this by <br>
     * <pre>
     *  public void acceptVisitor(EntityVisitor visitor) {
     *      visitor.visit(this);
     *  }
     * </pre>
     *
     * @param visitor The visitor that visits this entity
     */
    void acceptVisitor(EntityVisitor visitor);
}
