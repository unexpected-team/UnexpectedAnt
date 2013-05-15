package com.unexpected.ant.model.entity;

import com.unexpected.ant.model.AbstractEntity;
import com.unexpected.ant.model.Cell;
import com.unexpected.ant.model.Direction;

import java.util.*;

/**
 * This class represents an entity which moves
 */
public abstract class MovingEntity extends AbstractEntity {
	public static final int HISTORY_SIZE = 8;
	protected Direction facingDirection;
	protected Queue<Cell> history = new LinkedList<>();
	private final Object lockObj = new Object();

	public MovingEntity(Direction facingDirection) {
		this.facingDirection = facingDirection;
	}

	/**
	 * Default constructor with North facing direction
	 */
	public MovingEntity() {
		this(Direction.NORTH);
	}

	@Override
	public boolean moveTo(Cell cell) {
		Cell original = getCell();
		boolean result = super.moveTo(cell);
		if (!result) {
			return false;
		}
		history.add(cell);
		if (history.size() > HISTORY_SIZE) {
			history.remove();
		}
		setFacingDirection(original.getNeighbourDirection(cell));
		return true;
	}

	/**
	 * @return The facing direction
	 */
	public Direction getFacingDirection() {
		return facingDirection;
	}

	/**
	 * Sets the facing direction
	 *
	 * @param facingDirection
	 */
	public void setFacingDirection(Direction facingDirection) {
		this.facingDirection = facingDirection;
		updateView();
	}

	/**
	 * Sets the facing direction to (current cell -> param cell) direction
	 *
	 * @param cell
	 */
	public void setFacingDirection(Cell cell) {
		if (this.getCells().size() != 1) {
			throw new UnsupportedOperationException("Csak olyan entitásra használható, ami egyszerre egy cellán tartózkodik.");
		}
		Direction newFacingDirection = this.getCell().getNeighbourDirection(cell);
		if (newFacingDirection != null) {
			this.setFacingDirection(newFacingDirection);
		}
	}

	/**
	 * The entity moves
	 */
	public void move() {
		synchronized (lockObj) {
			if (!isRemoved()) {
				while (true) {
					Set<Cell> excludes = new HashSet<>();
					Cell nextCell = decideNextCell(excludes);
					if (moveTo(nextCell)) {
						return;
					}
					excludes.add(nextCell);
				}
			}
		}
	}

	/**
	 * The entity decides the next cell to be moved on to
	 *
	 * @return The cell
	 */
	public Cell decideNextCell(Set<Cell> excludes) {
		Cell nextCell = getCell();
		// create a map, in which we store each cell's rating, better rating means better chances that
		// the ant will move to that cell
		Map<Cell, Double> stepOptions = new HashMap<>();
		for (Map.Entry<Direction, Cell> neighbourEntry : getCell().getNeighboursMap().entrySet()) {
			Cell neighbour = neighbourEntry.getValue();
			Direction direction = neighbourEntry.getKey();
			if (!excludes.contains(neighbour) && neighbour.canBeSteppedOnBy(this)) {
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

		if (bestOption != null) {
			nextCell = bestOption.getKey();
		}


		return nextCell;
	}

	public Cell decideNextCell() {
		return decideNextCell(new HashSet<Cell>());
	}

	public abstract double rateCell(Cell cell, Direction direction);

}
