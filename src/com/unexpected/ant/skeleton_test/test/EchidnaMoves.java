package com.unexpected.ant.skeleton_test.test;

import com.unexpected.ant.model.Cell;
import com.unexpected.ant.model.Direction;
import com.unexpected.ant.model.entity.Echidna;
import com.unexpected.ant.skeleton_test.AbstractTestCase;

public class EchidnaMoves extends AbstractTestCase {
    public EchidnaMoves() {
        super("Hangyászsün mozgása");
    }

    public void doRun() {
        Echidna echidna = new Echidna();
        Cell cell = new Cell();
        Cell northNeighbour = new Cell();
        cell.addNeighbour(Direction.NORTH, northNeighbour);
        echidna.moveTo(cell);
        echidna.move();
    }
}
