package com.unexpected.ant.skeleton_test.test;

import com.unexpected.ant.model.Cell;
import com.unexpected.ant.model.entity.AntSmell;
import com.unexpected.ant.model.entity.DeodorantSpraySmell;
import com.unexpected.ant.skeleton_test.AbstractTestCase;

public class DeodorantSprayRemovesAntSmell extends AbstractTestCase {
    @Override
    protected void doRun() {
        Cell cell = new Cell();
        AntSmell antSmell = new AntSmell();
        DeodorantSpraySmell deodorantSpray = new DeodorantSpraySmell();

        antSmell.setCell(cell);
        deodorantSpray.setCell(cell);

        deodorantSpray.removeSmell();
    }
}
