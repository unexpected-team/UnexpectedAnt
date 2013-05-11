package com.unexpected.ant.gui.view;

import com.unexpected.ant.gui.AbstractEntitySwingView;
import com.unexpected.ant.gui.GuiManager;
import com.unexpected.ant.model.entity.Food;

/**
 * Author: Balu
 */
public class FoodView extends AbstractEntitySwingView<Food> {
    public FoodView(Food entity, GuiManager guiManager) {
        super(entity, guiManager);
    }

    @Override
    protected String getAssetPath() {
        return "assets/food.png";
    }
}
