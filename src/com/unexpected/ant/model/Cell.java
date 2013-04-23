package com.unexpected.ant.model;

import java.io.Serializable;
import java.util.*;

/**
 * This cell represents one unit of the game field
 */
public class Cell implements Serializable {
	private Set<Entity> entities = new HashSet<>();
	private Map<Direction, Cell> neighbours = new HashMap<>();
	private Vector position;

	/**
	 * Adds an entity to the cell
	 *
	 * @param entity The entity to be added
	 */
	public void addEntity(Entity entity) {
		entities.add(entity);
	}

	/**
	 * Returns the entities on this cell as an unmodifiable set
	 *
	 * @return the entities
	 */
	public Set<Entity> getEntities() {
		return Collections.unmodifiableSet(entities);
	}

	/**
	 * Add neighbouring cell
	 *
	 * @param direction
	 * @param cell
	 */
	public void addNeighbour(Direction direction, Cell cell) {
		if (cell == null) {
			return;
		}
		neighbours.put(direction, cell);
		if (!this.equals(cell.getNeighbour(direction.getOpposite()))) {
			cell.addNeighbour(direction.getOpposite(), this);
		}
	}

	public boolean equals(Object other) {
		return other instanceof Cell && other != null && other == this;
	}

	/**
	 * Returns the neighbour in that direction
	 *
	 * @param direction
	 * @return The neighbour
	 */
	public Cell getNeighbour(Direction direction) {
		return neighbours.get(direction);
	}

	/**
	 * Returns whether the subject entity can step on this cell
	 *
	 * @param subject The subject entity
	 * @return true, if the subject can step on this cell, otherwise false
	 */
	public boolean canBeSteppedOnBy(Entity subject) {
		for (Entity entity : entities) {
			if (!entity.canBeOnSameCellWith(subject) || !subject.canBeOnSameCellWith(entity)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns all the neighbours of this cell
	 *
	 * @return The list of neighbours
	 */
	public List<Cell> getNeighbours() {
		return new ArrayList<>(neighbours.values());
	}

	public Map<Direction, Cell> getNeighboursMap() {
		return new HashMap<>(neighbours);
	}

	/**
	 * Returns the position of the cell on the game field
	 *
	 * @return The position
	 */
	public Vector getPosition() {
		return position;
	}

	/**
	 * Removes the given entity from the cell
	 *
	 * @param entity The entity to be removed
	 */
	public void removeEntity(Entity entity) {
		entities.remove(entity);
	}

	/**
	 * Sets the position of the cell on the game field. The position gets stored as a copy
	 *
	 * @param position The position
	 */
	public void setPosition(Vector position) {
		this.position = new Vector(position);
	}

	/**
	 * Visits the entities
	 *
	 * @param entityVisitor
	 */
	public void visitEntities(EntityVisitor entityVisitor) {
		Set<Entity> toBeVisited = new HashSet<>(entities);
		for (Entity entity : toBeVisited) {
			if (entities.contains(entity)) {
				entity.acceptVisitor(entityVisitor);
			}
		}
	}

    /**
     * Get the direction of the given cell based the current cell (only if it is it's neighbour)
     *
     * @param cell
     * @return the Direction
     */
    public Direction getNeighbourDirection(Cell cell) {
        if(!this.getNeighbours().contains(cell)) {
            return null;
        }
        return getKeyByValueInNeighbourMap(this.getNeighboursMap(), cell);
    }

    /**
     * Get the key in neighbours hash map based on the given value
     * @param map
     * @param value
     * @param <T>
     * @param <E>
     * @return the direction of the cell
     */
    public static <T, E> T getKeyByValueInNeighbourMap(Map<T, E> map, E value) {
        for(Map.Entry entry : map.entrySet()) {
            if(value.equals(entry.getValue())) {
                return (T)entry.getKey();
            }
        }
        return null;
    }
}
