package com.unexpected.ant.gui.view;

import com.unexpected.ant.gui.AbstractEntitySwingView;
import com.unexpected.ant.gui.GuiManager;
import com.unexpected.ant.model.entity.Stone;

/**
 * Author: Balu
 */
public class StoneView extends AbstractEntitySwingView<Stone> {
    public StoneView(Stone entity, GuiManager guiManager) {
        super(entity, guiManager);
    }

    @Override
    protected String getAssetPath() {
        return "assets/stone.png";
    }
}
