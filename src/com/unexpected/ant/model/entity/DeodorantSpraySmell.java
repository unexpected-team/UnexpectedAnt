package com.unexpected.ant.model.entity;

import com.unexpected.ant.GameEngine;
import com.unexpected.ant.model.EntityVisitorAdapter;

/**
 * This class represents the deodorant which has been blown by the player onto the fields. The deodorant removes
 * the ant smell.
 */
public class DeodorantSpraySmell extends Smell {
    @Override
    public void action(long tickCount) {
        removeSmell();
        if (tickCount % 12 == 0)
            decay();
    }

    public DeodorantSpraySmell() {
        setIntensity(5);
        view = GameEngine.INSTANCE.getViewFactory().createView(this);
    }

    /**
     * Removes smell from the cells onto which the deodorant is blown
     */
    public void removeSmell() {
        getVisitedByEntitiesOnSameCells(new RemoveSmellVisitor());
    }

    /**
     * This class is part of the visitor pattern for removing smell
     */
    protected class RemoveSmellVisitor extends EntityVisitorAdapter {
        @Override
        public void visit(AntSmell antSmell) {
            antSmell.remove();
        }
    }
}
