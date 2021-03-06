package com.unexpected.ant.model;

import com.unexpected.ant.GameEngine;
import com.unexpected.ant.model.entity.KillerSpraySmell;
import com.unexpected.ant.model.entity.Smell;

public class KillerSpray extends Spray {
	public KillerSpray(int quantity) {
		super(quantity);
		view = GameEngine.INSTANCE.getViewFactory().createView(this);
	}

	@Override
	public Smell createSpraySmell() {
		return new KillerSpraySmell();
	}
}
