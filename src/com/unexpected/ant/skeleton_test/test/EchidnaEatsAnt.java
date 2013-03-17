package com.unexpected.ant.skeleton_test.test;

import com.unexpected.ant.model.Cell;
import com.unexpected.ant.model.Direction;
import com.unexpected.ant.model.entity.Ant;
import com.unexpected.ant.model.entity.Echidna;
import com.unexpected.ant.skeleton_test.AbstractTestCase;

public class EchidnaEatsAnt extends AbstractTestCase {
    @Override
    protected void doRun() {
        Cell cell = new Cell();
        Echidna echidna = new Echidna();
        echidna.setHunger(5);
        Ant ant = new Ant(Direction.NORTH);

        ant.moveTo(cell);
        echidna.moveTo(cell);

        echidna.eat();
    }
}
