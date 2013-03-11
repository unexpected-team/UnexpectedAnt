package com.unexpected.ant.model.entity;

import com.unexpected.ant.model.AbstractEntity;
import com.unexpected.ant.model.EntityVisitorAdapter;

public class AntLion extends AbstractEntity {
    @Override
    public void action(long tickCount) {
        super.action(tickCount);
        kill();
    }

    private void kill() {
        getVisitedByEntitiesOnSameCells(new EatVisitor());
    }

    protected class EatVisitor extends EntityVisitorAdapter {
        public void visit(Ant ant) {
            ant.remove();
        }
    }
}
