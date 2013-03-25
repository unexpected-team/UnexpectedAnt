package com.unexpected.ant.model.entity;

import com.unexpected.ant.model.EntityVisitorAdapter;

import static com.unexpected.ant.skeleton_test.OutputHelper.printCurrentMethod;

/**
 * This class represents the deodorant which has been blown by the player onto the fields. The deodorant removes
 * the ant smell.
 */
public class DeodorantSpraySmell extends Smell {
    @Override
    public void action(long tickCount) {
        super.action(tickCount);
        removeSmell();
    }

    /**
     * Removes smell from the cells onto which the deodorant is blown
     */
    public void removeSmell() {
        printCurrentMethod(this);
        getVisitedByEntitiesOnSameCells(new RemoveSmellVisitor());
    }

    /**
     * This class is part of the visitor pattern for removing smell
     */
    protected class RemoveSmellVisitor extends EntityVisitorAdapter {
        @Override
        public void visit(AntSmell antSmell) {
            printCurrentMethod(this);
            antSmell.remove();
        }
    }
}
