package com.unexpected.ant.model.entity;

import com.unexpected.ant.GameEngine;
import com.unexpected.ant.model.Cell;
import com.unexpected.ant.model.Direction;
import com.unexpected.ant.model.EntityVisitor;
import com.unexpected.ant.model.EntityVisitorAdapter;

/**
 * This class represents the echidna which moves on the game field and eats ants.
 */
public class Echidna extends MovingEntity {
	private int hunger = 5;
	private int sleepCounter = 0;

	public Echidna(Direction facingDirection) {
		super(facingDirection);
		view = GameEngine.INSTANCE.getViewFactory().createView(this);
	}

	public Echidna() {
		super();
		view = GameEngine.INSTANCE.getViewFactory().createView(this);
	}

	@Override
	public void action(long tickCount) {
		if (isHungry() && !isAsleep()) {
			eat();
		}
		if (tickCount % 8 == 0 && !isAsleep()) {
			move();
		}
		if (sleepCounter == 1) {
			setHunger(5);
		}
		if (isAsleep()) {
			sleepCounter--;
		}
	}

	@Override
	public boolean moveTo(Cell cell) {
		KickVisitor kickVisitor = new KickVisitor(getCell().getNeighbourDirection(cell));
		cell.visitEntities(kickVisitor);
		if(!kickVisitor.success) {
			return false;
		}
		return super.moveTo(cell);
	}

	/**
	 * The echidna eats ants
	 */
	public void eat() {
		getVisitedByEntitiesOnSameCells(new EatVisitor());
	}

	@Override
	public void acceptVisitor(EntityVisitor visitor) {
		visitor.visit(this);
	}

	/**
	 * Returns if the echidna is hungry
	 *
	 * @return True if hungry, false otherwise
	 */
	public boolean isHungry() {
		return getHunger() > 0;
	}

	/**
	 * Returns the level of hunger
	 *
	 * @return The level of hunger
	 */
	public int getHunger() {
		return hunger;
	}

	/**
	 * Sets the level of hunger
	 *
	 * @param hunger the level of hunger
	 */
	public void setHunger(int hunger) {
		this.hunger = hunger;
	}

	/**
	 * Returns if the echidna is sleeping
	 *
	 * @return True if sleeping, false otherwise
	 */
	public boolean isAsleep() {
		return sleepCounter > 0;
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

	/**
	 * Commands the echidna to sleep for the given amount of time
	 *
	 * @param amount The amount of time to sleep for
	 */
	public void sleep(int amount) {
		sleepCounter = amount;
	}

	/**
	 * This class is part of the visitor pattern for eating ants
	 */
	protected class EatVisitor extends EntityVisitorAdapter {
		public void visit(Ant ant) {
			hunger--;
			ant.remove();
			if (!isHungry()) {
				sleep(40);
			}
		}
	}

	protected class SmellVisitor extends com.unexpected.ant.model.entity.SmellVisitor {

		@Override
		public void visit(AntSmell antSmell) {
			smell += antSmell.getIntensity() * 2;
		}
	}

	protected class KickVisitor extends EntityVisitorAdapter {
		private Direction direction;
		public boolean success = true;

		public KickVisitor(Direction direction) {
			this.direction = direction;
		}

		@Override
		public void visit(Stone stone) {
			success = stone.kick(direction);
		}
	}
}
