package com.unexpected.ant.model.entity;

import com.unexpected.ant.GameEngine;
import com.unexpected.ant.model.EntityVisitor;

/**
 * This class represents the smell which comes from food
 */
public class FoodSmell extends Smell {
	public FoodSmell() {
		GameEngine.INSTANCE.getTimer().add(this);
	}

	@Override
	public void acceptVisitor(EntityVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public void action(long tickCount) {
		if (tickCount % 5 == 0)
			decay();
	}

	@Override
	public void decay() {

	}
}
