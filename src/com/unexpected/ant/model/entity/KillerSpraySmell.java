package com.unexpected.ant.model.entity;

import com.unexpected.ant.model.Cell;
import com.unexpected.ant.model.EntityVisitorAdapter;

public class KillerSpraySmell extends Smell {
    @Override
    public void action(long tickCount) {
        super.action(tickCount);
        kill();
    }

    private void kill() {
        for (Cell cell : getCells()) {
            cell.visitByAllEntities(new KillerSprayVisitor());
        }
    }

    protected class KillerSprayVisitor extends EntityVisitorAdapter {
        public void visit(Ant ant) {
            ant.remove();
        }
    }
}
