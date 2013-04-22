package com.unexpected.ant.model.entity;

import com.unexpected.ant.model.AbstractEntity;
import com.unexpected.ant.model.EntityVisitorAdapter;

/**
 * This class represents an ant lion in the game. An ant lion does not move, but eats all the ants which step on the
 * cell(s) the ant lion stands on.
 */
public class AntLion extends AbstractEntity {
	@Override
	public void action(long tickCount) {
		super.action(tickCount);
		kill();
	}

	/**
	 * Kills the ants on the same cells
	 */
	public void kill() {
		getVisitedByEntitiesOnSameCells(new EatVisitor());
	}

	/**
	 * Used for eating ants
	 */
	protected class EatVisitor extends EntityVisitorAdapter {
		@Override
		public void visit(Ant ant) {
			ant.remove();
		}
	}
}
