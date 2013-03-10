package com.unexpected.ant.model.entity;

import com.unexpected.ant.model.AbstractEntity;

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
}
