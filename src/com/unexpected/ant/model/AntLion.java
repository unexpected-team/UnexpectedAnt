package com.unexpected.ant.model;

import com.unexpected.ant.model.entity.Ant;

public class AntLion extends AbstractEntity {
    @Override
    public void action(long tickCount) {
        super.action(tickCount);
        kill();
    }

    private void kill() {
        getVisitedByAllEntitiesOnSameCells(new AntLionVisitor());
    }

    protected class AntLionVisitor extends EntityVisitorAdapter {
        public void visit(Ant ant) {
            ant.remove();
        }
    }
}
