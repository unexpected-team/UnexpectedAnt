package com.unexpected.ant.skeleton_test.test;

import com.unexpected.ant.model.Cell;
import com.unexpected.ant.model.Direction;
import com.unexpected.ant.model.entity.Ant;
import com.unexpected.ant.model.entity.KillerSpraySmell;
import com.unexpected.ant.skeleton_test.AbstractTestCase;

public class KillerSprayKillsAnt extends AbstractTestCase {
    @Override
    protected void doRun() {
        Cell cell = new Cell();
        KillerSpraySmell spray = new KillerSpraySmell();
        Ant ant = new Ant(Direction.NORTH);

        ant.moveTo(cell);
        spray.setCell(cell);

        spray.kill();
    }
}
