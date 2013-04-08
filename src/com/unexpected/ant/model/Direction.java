package com.unexpected.ant.model;

import java.util.Arrays;

/**
 * Directions on the game field
 */
public enum Direction {
    NORTH, NORTHEAST, SOUTHEAST, SOUTH, SOUTHWEST, NORTHWEST;

    /**
     * Returns the opposite direction
     *
     * @return opposite direction
     */
    public Direction getOpposite() {
        switch (this) {
            case NORTH:
                return SOUTH;
            case NORTHEAST:
                return SOUTHWEST;
            case SOUTHEAST:
                return NORTHWEST;
            case SOUTH:
                return NORTH;
            case SOUTHWEST:
                return NORTHEAST;
            case NORTHWEST:
                return SOUTHEAST;
        }
        return NORTH;
    }

    public int value() {
        return Arrays.binarySearch(values(), this);
    }

    public Direction addRelativeDirection(RelativeDirection direction) {
        int dir = value();
        int relativeDir = direction.value();
        return values()[(dir + relativeDir) % values().length];
    }

    public RelativeDirection getRelativeDirectionTo(Direction direction) {
        int thisDirection = value();
        int paramDirection = direction.value();
        return RelativeDirection.values()[(values().length + paramDirection - thisDirection) % values().length];
    }
}
