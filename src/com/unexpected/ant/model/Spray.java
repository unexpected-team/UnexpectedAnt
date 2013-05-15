package com.unexpected.ant.model;

import com.unexpected.ant.gui.View;
import com.unexpected.ant.model.entity.Smell;

import java.util.HashSet;
import java.util.Set;

public abstract class Spray {
	private int affectedRadius;

	protected View view;

	private int quantity;

	public Spray(int quantity) {
		this.quantity = quantity;
	}

	public int getRemainingQuantity() {
		return quantity;
	}

	public void infectArea(Cell cell) {
		if (quantity == 0) {
			return;
		}
		Set<Cell> cellsToInfect = new HashSet<>();
		cellsToInfect.add(cell);
		for (Cell neighbour : cell.getNeighbours()) {
			cellsToInfect.add(neighbour);
		}
		for (Cell infectable : cellsToInfect) {
			infectable.addEntity(createSpraySmell());
		}
		quantity--;
		view.update();
	}

	protected abstract Smell createSpraySmell();
}
