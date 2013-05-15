package com.unexpected.ant.model;

import com.unexpected.ant.GameEngine;
import com.unexpected.ant.gui.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class represent the default implementation of an entity on the game field
 */
public abstract class AbstractEntity implements Entity, Dynamic {
	protected List<Cell> cells = new ArrayList<>();

	protected View view;

	public AbstractEntity() {
		GameEngine.INSTANCE.getTimer().add(this);
	}

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
		updateView();
	}

	@Override
	public boolean canBeOnSameCellWith(Entity entity) {
		return true;
	}

	/**
	 * Returns the first cell of the shape, useful for entities containing only one cell
	 *
	 * @return The first cell
	 */
	public Cell getCell() {
		if (getCells().size() == 0)
			return null;
		return getCells().get(0);
	}

	/**
	 * The given visitor gets visited by all entity on same cells
	 *
	 * @param entityVisitor The visitor to be visited
	 */
	protected void getVisitedByEntitiesOnSameCells(EntityVisitor entityVisitor) {
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
		for (Cell cell : getCells()) {
			cell.removeEntity(this);
		}
		cells.clear();
		GameEngine.INSTANCE.getTimer().remove(this);
		updateView();
	}

	@Override
	public void removeCell(Cell cell) {
		cells.remove(cell);
		updateView();
	}

	@Override
	public void removeCells(List<Cell> cells) {
		this.cells.removeAll(cells);
		updateView();
	}

	/**
	 * Sets one cell for the entity's shape
	 *
	 * @param cell
	 */
	public void setCell(Cell cell) {
		cells.clear();
		cells.add(cell);
		cell.addEntity(this);
		updateView();
	}

	@Override
	public void setCells(List<Cell> cells) {
		this.cells = new ArrayList<>(cells);
		for (Cell cell : cells) {
			cell.addEntity(this);
		}
		updateView();
	}

	protected void updateView() {
		if (view != null) {
			view.update();
		}
	}

	public boolean isRemoved() {
		return getCell() == null;
	}

	/**
	 * Move to the given cell
	 *
	 * @param cell The moves to this cell
	 */
	public boolean moveTo(Cell cell) {
		for (Cell cell1 : getCells()) {
			cell1.removeEntity(this);
		}
		cell.addEntity(this);
		this.cells.clear();
		this.cells.add(cell);
		updateView();
		return true;
	}
}
