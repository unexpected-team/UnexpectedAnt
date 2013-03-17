package com.unexpected.ant.skeleton_test.test;

import com.unexpected.ant.model.Cell;
import com.unexpected.ant.model.Direction;
import com.unexpected.ant.model.entity.Ant;
import com.unexpected.ant.model.entity.Obstacle;
import com.unexpected.ant.model.entity.ObstacleType;
import com.unexpected.ant.skeleton_test.AbstractTestCase;

public class AntEncountersObstacle extends AbstractTestCase {
    public AntEncountersObstacle() {
        super("Hangya találkozik egy akadállyal");
    }

    public void doRun() {
        Ant ant = new Ant(Direction.NORTH);
        Cell cell = new Cell();
        Cell northNeighbour = new Cell();
        Cell southNeighbour = new Cell();
        northNeighbour.addEntity(new Obstacle(ObstacleType.PUDDLE));
        cell.addNeighbour(Direction.NORTH, northNeighbour);
        cell.addNeighbour(Direction.SOUTH, southNeighbour);
        ant.moveTo(cell);
        ant.move();
    }
}
