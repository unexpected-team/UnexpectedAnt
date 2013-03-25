package com.unexpected.ant.model.entity;

import com.unexpected.ant.model.AbstractEntity;
import com.unexpected.ant.model.Entity;

import static com.unexpected.ant.skeleton_test.OutputHelper.printCurrentMethod;

/**
 * This class represent obstacles which ants cannot step on
 */
public class Obstacle extends AbstractEntity {
    private ObstacleType obstacleType;

    /**
     * Constructor with obstacle type
     *
     * @param obstacleType The type of this obstacle
     */
    public Obstacle(ObstacleType obstacleType) {
        this.obstacleType = obstacleType;
    }

    /**
     * Gets the obstacle type
     *
     * @return The obstacle type
     */
    public ObstacleType getObstacleType() {
        return obstacleType;
    }

    /**
     * Sets the obstacle type
     *
     * @param obstacleType The obstacle type
     */
    public void setObstacleType(ObstacleType obstacleType) {
        this.obstacleType = obstacleType;
    }

    @Override
    public boolean canBeOnSameCellWith(Entity entity) {
        printCurrentMethod(this);
        return false;
    }
}
