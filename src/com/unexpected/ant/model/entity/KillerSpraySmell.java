package com.unexpected.ant.model.entity;

import com.unexpected.ant.model.EntityVisitorAdapter;

public class KillerSpraySmell extends Smell {
    @Override
    public void action(long tickCount) {
        super.action(tickCount);
        kill();
    }

    private void kill() {
        getVisitedByEntitiesOnSameCells(new KillVisitor());
    }

    protected class KillVisitor extends EntityVisitorAdapter {
        @Override
        public void visit(Ant ant) {
            ant.remove();
        }
    }
}
