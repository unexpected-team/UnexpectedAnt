package com.unexpected.ant.model.entity;

import com.unexpected.ant.GameEngine;
import com.unexpected.ant.model.Cell;
import com.unexpected.ant.model.Direction;
import com.unexpected.ant.model.EntityVisitor;
import com.unexpected.ant.model.EntityVisitorAdapter;

/**
 * This class represents an ant in the game.
 */
public class Ant extends MovingEntity {
	private boolean hasFood = false;

	/**
	 * Constructor
	 *
	 * @param facingDirection The original facing direction of the ant
	 */
	public Ant(Direction facingDirection) {
		super(facingDirection);
		view = GameEngine.INSTANCE.getViewFactory().createView(this);
	}

	/**
	 * Default constructor with North facing direction
	 */
	public Ant() {
		this(Direction.NORTH);
	}

	@Override
	public void acceptVisitor(EntityVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public void action(long tickCount) {
		if (!isRemoved()) {
			eat();
			if (tickCount % 10 == 0) {
				move();
				createSmell();
			}
		}
	}

	/**
	 * The ant eats if it's hungry
	 */
	public void eat() {
		if (!hasFood) {
			getVisitedByEntitiesOnSameCells(new EatVisitor());
		}
	}


	public double rateCell(Cell cell, Direction direction) {
		int directionValue = direction.getRelativeDirectionTo(getFacingDirection()).value();
		int weight = Math.abs(directionValue - Direction.values().length / 2);
		SmellVisitor smellVisitor = new SmellVisitor();
		cell.visitEntities(smellVisitor);
		int historyPoint = 5;
		for (Cell historyCell : history) {
			if (historyCell.equals(cell)) {
				historyPoint--;
			}
		}

		return weight / 2 + smellVisitor.getSmell() * 5 + Math.random() * 2 + historyPoint / 2;
	}

	public AntSmell createSmell() {
		AntSmell antSmell = new AntSmell(this);
		getCell().addEntity(antSmell);
		return antSmell;
	}

	/**
	 * This class is for eating food
	 */
	protected class EatVisitor extends EntityVisitorAdapter {
		@Override
		public void visit(Food food) {
			if (!Ant.this.hasFood) {
				food.remove();
				Ant.this.hasFood = true;
			}
		}
	}

	class SmellVisitor extends com.unexpected.ant.model.entity.SmellVisitor {

		@Override
		public void visit(FoodSmell foodSmell) {
			smell += foodSmell.getIntensity() * 2;
		}

		@Override
		public void visit(AntSmell antSmell) {
			smell += antSmell.getIntensity();
		}
	}
}
