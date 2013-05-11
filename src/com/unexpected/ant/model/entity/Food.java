package com.unexpected.ant.model.entity;

import com.unexpected.ant.GameEngine;
import com.unexpected.ant.model.AbstractEntity;

/**
 * This class represents the food which the ants want to catch
 */
public class Food extends AbstractEntity {
    public Food() {
        view = GameEngine.INSTANCE.getViewFactory().createView(this);
    }
}
