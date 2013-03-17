package com.unexpected.ant.skeleton_test.test;

import com.unexpected.ant.model.Cell;
import com.unexpected.ant.model.Direction;
import com.unexpected.ant.model.entity.Ant;
import com.unexpected.ant.skeleton_test.AbstractTestCase;

public class AntMoves extends AbstractTestCase {
    public void doRun() {
        Ant ant = new Ant(Direction.NORTH);
        Cell cell = new Cell();
        Cell northNeighbour = new Cell();
        cell.addNeighbour(Direction.NORTH, northNeighbour);
        cell.addEntity(ant);
        ant.move();
    }
}
