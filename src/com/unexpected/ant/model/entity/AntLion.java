package com.unexpected.ant.model.entity;

import com.unexpected.ant.model.AbstractEntity;
import com.unexpected.ant.model.EntityVisitorAdapter;

import static com.unexpected.ant.skeleton_test.OutputHelper.printCurrentMethod;

public class AntLion extends AbstractEntity {
    @Override
    public void action(long tickCount) {
        super.action(tickCount);
        kill();
    }

    public void kill() {
        printCurrentMethod();
        getVisitedByEntitiesOnSameCells(new EatVisitor());
    }


    protected class EatVisitor extends EntityVisitorAdapter {
        public void visit(Ant ant) {
            printCurrentMethod();
            ant.remove();
        }
    }
}
