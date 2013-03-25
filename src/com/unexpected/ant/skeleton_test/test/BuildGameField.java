package com.unexpected.ant.skeleton_test.test;

import com.unexpected.ant.model.Cell;
import com.unexpected.ant.model.Direction;
import com.unexpected.ant.skeleton_test.AbstractTestCase;

public class BuildGameField extends AbstractTestCase {
    @Override
    protected void doRun() {
        Cell topleftCell = new Cell();
        Cell toprightCell = new Cell();
        Cell bottomleftCell = new Cell();
        Cell bottomrightCell = new Cell();

        topleftCell.addNeighbour(Direction.SOUTH, bottomleftCell);
        topleftCell.addNeighbour(Direction.EAST, toprightCell);

        bottomrightCell.addNeighbour(Direction.WEST, bottomleftCell);
        bottomrightCell.addNeighbour(Direction.NORTH, toprightCell);
    }
}
