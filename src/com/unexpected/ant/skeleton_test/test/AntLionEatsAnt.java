package com.unexpected.ant.skeleton_test.test;

import com.unexpected.ant.model.Cell;
import com.unexpected.ant.model.Direction;
import com.unexpected.ant.model.entity.Ant;
import com.unexpected.ant.model.entity.AntLion;
import com.unexpected.ant.skeleton_test.AbstractTestCase;

public class AntLionEatsAnt extends AbstractTestCase {
    @Override
    protected void doRun() {
        Cell cell = new Cell();
        AntLion antLion = new AntLion();
        Ant ant = new Ant(Direction.NORTH);

        ant.moveTo(cell);
        antLion.setCell(cell);

        antLion.kill();
    }
}
