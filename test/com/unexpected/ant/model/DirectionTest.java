package com.unexpected.ant.model;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class DirectionTest {
    @Test
    public void testAddRelativeDirection() throws Exception {
        assertEquals(Direction.NORTH, Direction.NORTH.addRelativeDirection(RelativeDirection.FORWARDS));
        assertEquals(Direction.SOUTH, Direction.NORTH.addRelativeDirection(RelativeDirection.BACKWARDS));
        assertEquals(Direction.NORTHEAST, Direction.NORTH.addRelativeDirection(RelativeDirection.RIGHTWARDS_FORWARDS));
        assertEquals(Direction.NORTH, Direction.SOUTHEAST.addRelativeDirection(RelativeDirection.LEFTWARDS_BACKWARDS));
        assertEquals(Direction.SOUTHEAST, Direction.SOUTH.addRelativeDirection(RelativeDirection.LEFTWARDS_FORWARDS));
    }

    @Test
    public void testGetRelativeDirectionTo() throws Exception {
        assertEquals(RelativeDirection.FORWARDS, Direction.NORTH.getRelativeDirectionTo(Direction.NORTH));
        assertEquals(RelativeDirection.BACKWARDS, Direction.NORTH.getRelativeDirectionTo(Direction.SOUTH));
        assertEquals(RelativeDirection.BACKWARDS, Direction.SOUTH.getRelativeDirectionTo(Direction.NORTH));


    }
}
