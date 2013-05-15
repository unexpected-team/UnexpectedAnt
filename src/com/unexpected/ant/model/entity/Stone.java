package com.unexpected.ant.model.entity;

import com.unexpected.ant.model.*;

/**
 * Stone, the echidna can kick this if the neighbouring cell does not contain another stone, the ants have to go
 * around it
 */
public class Stone extends Obstacle {
	/**
	 * Default constructor
	 */
	public Stone() {
		super(ObstacleType.STONE);
	}

	@Override
	public void setObstacleType(ObstacleType obstacleType) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Kick the stone from the given direction. Direction means which direction the stone is kicked
	 *
	 * @param direction
	 * @return
	 */
	public boolean kick(Direction direction) {

		StoneVisitor stoneVisitor = new StoneVisitor();
		Cell neighbour = getCell().getNeighbour(direction);
		neighbour.visitEntities(stoneVisitor);
		if (!stoneVisitor.hasStone) {
			this.moveTo(neighbour);
			return true;
		}
		return false;
	}

	@Override
	public boolean canBeOnSameCellWith(Entity entity) {
		return entity instanceof Echidna;
	}

	@Override
	public void acceptVisitor(EntityVisitor visitor) {
		visitor.visit(this);
	}

	private class StoneVisitor extends EntityVisitorAdapter {
		public boolean hasStone;

		@Override
		public void visit(Stone stone) {
			hasStone = true;
		}
	}
}
