package com.unexpected.ant.model.entity;

import com.unexpected.ant.model.AbstractEntity;
import com.unexpected.ant.model.Entity;

import static com.unexpected.ant.skeleton_test.OutputHelper.printCurrentMethod;

public class Obstacle extends AbstractEntity {
    private ObstacleType obstacleType;

    public Obstacle(ObstacleType obstacleType) {
        this.obstacleType = obstacleType;
    }

    public ObstacleType getObstacleType() {
        return obstacleType;
    }

    public void setObstacleType(ObstacleType obstacleType) {
        this.obstacleType = obstacleType;
    }

    @Override
    public boolean canBeOnSameCellWith(Entity entity) {
        printCurrentMethod();
        return false;
    }
}
