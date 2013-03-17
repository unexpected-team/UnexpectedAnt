package com.unexpected.ant.model;

public enum Direction {
    NORTH, WEST, SOUTH, EAST;


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
