package com.unexpected.ant.model.entity;

import com.unexpected.ant.GameEngine;
import com.unexpected.ant.model.AbstractEntity;
import com.unexpected.ant.model.EntityVisitor;

/**
 * This class represents the food which the ants want to catch
 */
public class Food extends AbstractEntity {
	public Food() {
		view = GameEngine.INSTANCE.getViewFactory().createView(this);
	}

	public FoodSmell createSmell() {
		FoodSmell smell = new FoodSmell();
		getCell().addEntity(smell);
		return smell;
	}

	@Override
	public void acceptVisitor(EntityVisitor visitor) {
		visitor.visit(this);
	}
}
