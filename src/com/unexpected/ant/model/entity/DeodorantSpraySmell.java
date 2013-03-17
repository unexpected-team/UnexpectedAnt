package com.unexpected.ant.model.entity;

import com.unexpected.ant.model.EntityVisitorAdapter;

import static com.unexpected.ant.skeleton_test.OutputHelper.printCurrentMethod;

public class DeodorantSpraySmell extends Smell {
    @Override
    public void action(long tickCount) {
        super.action(tickCount);
        removeSmell();
    }

    public void removeSmell() {
        printCurrentMethod();
        getVisitedByEntitiesOnSameCells(new RemoveSmellVisitor());
    }

    protected class RemoveSmellVisitor extends EntityVisitorAdapter {
        @Override
        public void visit(AntSmell antSmell) {
            printCurrentMethod();
            antSmell.remove();
        }
    }
}
