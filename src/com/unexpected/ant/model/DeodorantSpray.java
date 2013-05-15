package com.unexpected.ant.model;

import com.unexpected.ant.GameEngine;
import com.unexpected.ant.model.entity.DeodorantSpraySmell;
import com.unexpected.ant.model.entity.Smell;

public class DeodorantSpray extends Spray {
	public DeodorantSpray(int quantity) {
		super(quantity);
		view = GameEngine.INSTANCE.getViewFactory().createView(this);
	}

	@Override
	public Smell createSpraySmell() {
		return new DeodorantSpraySmell();
	}
}
