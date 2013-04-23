package com.unexpected.ant.model.entity;

import com.unexpected.ant.model.Cell;
import com.unexpected.ant.model.Direction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class MovingEntityTest {
    @Test
    public void testSetFacingDirection() throws Exception {
        Cell c1 = new Cell();
        Cell c2 = new Cell();
        c1.addNeighbour(Direction.SOUTH, c2);
        Ant a1 = new Ant(Direction.NORTH);
        a1.moveTo(c1);
        a1.setFacingDirection(c2);

        assertEquals(Direction.SOUTH, a1.getFacingDirection());
    }
}
