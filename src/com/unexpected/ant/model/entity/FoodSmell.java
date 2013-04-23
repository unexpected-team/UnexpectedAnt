package com.unexpected.ant.model.entity;

/**
 * This class represents the smell which comes from food
 */
public class FoodSmell extends Smell {
    @Override
    public void action(long tickCount) {
        if(tickCount % 5 == 0)
            decay();
    }
}
