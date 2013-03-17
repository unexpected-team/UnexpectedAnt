package com.unexpected.ant.model.entity;

import com.unexpected.ant.model.EntityVisitorAdapter;

import static com.unexpected.ant.skeleton_test.OutputHelper.printCurrentMethod;

public class KillerSpraySmell extends Smell {
    @Override
    public void action(long tickCount) {
        super.action(tickCount);
        kill();
    }

    public void kill() {
        printCurrentMethod();
        getVisitedByEntitiesOnSameCells(new KillVisitor());
    }

    protected class KillVisitor extends EntityVisitorAdapter {
        @Override
        public void visit(Ant ant) {
            printCurrentMethod();
            ant.remove();
        }
    }
}
