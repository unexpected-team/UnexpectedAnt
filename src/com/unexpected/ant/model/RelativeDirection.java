package com.unexpected.ant.model;

import java.util.Arrays;

/**
 * Relative direction to the facing direction
 */
public enum RelativeDirection {
    FORWARDS, RIGHTWARDS_FORWARDS, RIGHTWARDS_BACKWARDS, BACKWARDS, LEFTWARDS_BACKWARDS, LEFTWARDS_FORWARDS;

    public int value() {
        return Arrays.binarySearch(values(), this);
    }

}
