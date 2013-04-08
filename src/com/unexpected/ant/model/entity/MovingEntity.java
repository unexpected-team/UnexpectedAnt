package com.unexpected.ant.model.entity;

import com.unexpected.ant.model.AbstractEntity;
import com.unexpected.ant.model.Cell;
import com.unexpected.ant.model.Direction;

import java.util.HashMap;
import java.util.Map;

import static com.unexpected.ant.skeleton_test.OutputHelper.printCurrentMethod;

/**
 * This class represents an entity which moves
 */
public abstract class MovingEntity extends AbstractEntity {
    protected Direction facingDirection;

    public MovingEntity(Direction facingDirection) {
        this.facingDirection = facingDirection;
    }

    /**
     * @return The facing direction
     */
    public Direction getFacingDirection() {
        printCurrentMethod(this);
        return facingDirection;
    }

    /**
     * Sets the facing direction
     *
     * @param facingDirection
     */
    public void setFacingDirection(Direction facingDirection) {
        printCurrentMethod(this);
        this.facingDirection = facingDirection;
    }

    /**
     * The entity moves
     */
    public void move() {
        printCurrentMethod(this);
        remove();
        Cell nextCell = decideNextCell();
        moveTo(nextCell);
    }

    /**
     * The entity decides the next cell to be moved on to
     *
     * @return The cell
     */
    public Cell decideNextCell() {
        printCurrentMethod(this);
        Cell nextCell = getCell();
        // create a map, in which we store each cell's rating, better rating means better chances that
        // the ant will move to that cell
        Map<Cell, Double> stepOptions = new HashMap<>();
        for (Map.Entry<Direction, Cell> neighbourEntry : getCell().getNeighboursMap().entrySet()) {
            Cell neighbour = neighbourEntry.getValue();
            Direction direction = neighbourEntry.getKey();
            if (neighbour.canBeSteppedOnBy(this)) {
                //add neighbour to the options with weight
                stepOptions.put(neighbour, rateCell(neighbour, direction));
            }
        }

        Map.Entry<Cell, Double> bestOption = null;
        for (Map.Entry<Cell, Double> stepOption : stepOptions.entrySet()) {
            // if we find a better direction, upgrade the best to the new found one
            if (bestOption == null || stepOption.getValue() > bestOption.getValue()) {
                bestOption = stepOption;
            }
        }


        return nextCell;
    }

    public abstract double rateCell(Cell cell, Direction direction);

    /**
     * The ant moves to the given cell
     *
     * @param cell The moves to this cell
     */
    public void moveTo(Cell cell) {
        printCurrentMethod(this);
        this.remove();
        cell.addEntity(this);
        this.cells.clear();
        this.cells.add(cell);
    }

}
