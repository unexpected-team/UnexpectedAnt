package com.unexpected.ant.model;

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
}
