package com.unexpected.ant.model.entity;

import com.unexpected.ant.model.EntityVisitorAdapter;

import static com.unexpected.ant.skeleton_test.OutputHelper.printCurrentMethod;

/**
 * This class represent the killer spray which kills the ants of the same cells
 */
public class KillerSpraySmell extends Smell {
    @Override
    public void action(long tickCount) {
        super.action(tickCount);
        kill();
    }

    /**
     * Kills the ants on the same cells
     */
    public void kill() {
        printCurrentMethod(this);
        getVisitedByEntitiesOnSameCells(new KillVisitor());
    }

    /**
     * Used for the visitor pattern for killing ants
     */
    protected class KillVisitor extends EntityVisitorAdapter {
        @Override
        public void visit(Ant ant) {
            printCurrentMethod(this);
            ant.remove();
        }
    }
}
