package com.unexpected.ant.skeleton_test.test;

import com.unexpected.ant.model.Cell;
import com.unexpected.ant.model.Direction;
import com.unexpected.ant.model.entity.Ant;
import com.unexpected.ant.model.entity.Food;
import com.unexpected.ant.skeleton_test.AbstractTestCase;

public class AntEatsFood extends AbstractTestCase {
    @Override
    protected void doRun() {
        Cell cell = new Cell();
        Ant ant = new Ant(Direction.NORTH);
        Food food = new Food();

        ant.moveTo(cell);
        food.setCell(cell);

        ant.eat();
    }
}
