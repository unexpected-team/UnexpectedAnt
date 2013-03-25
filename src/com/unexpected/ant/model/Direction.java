package com.unexpected.ant.model;

/**
 * Directions on the game field
 */
public enum Direction {
    NORTH, WEST, SOUTH, EAST;

    /**
     * Returns the opposite direction
     *
     * @return opposite direction
     */
    public Direction getOpposite() {
        switch (this) {
            case EAST:
                return WEST;
            case WEST:
                return EAST;
            case SOUTH:
                return NORTH;
            case NORTH:
                return SOUTH;
        }
        return NORTH;
    }
}
