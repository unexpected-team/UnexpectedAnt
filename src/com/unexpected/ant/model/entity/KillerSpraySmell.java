package com.unexpected.ant.model.entity;

import com.unexpected.ant.model.EntityVisitorAdapter;

/**
 * This class represent the killer spray which kills the ants of the same cells
 */
public class KillerSpraySmell extends Smell {
	@Override
	public void action(long tickCount) {
		super.action(tickCount);
        if(tickCount % 12 == 0)
            kill();
	}

	/**
	 * Kills the ants on the same cells
	 */
	public void kill() {
		getVisitedByEntitiesOnSameCells(new KillVisitor());
	}

	/**
	 * Used for the visitor pattern for killing ants
	 */
	protected class KillVisitor extends EntityVisitorAdapter {
		@Override
		public void visit(Ant ant) {
			ant.remove();
		}
	}
}
