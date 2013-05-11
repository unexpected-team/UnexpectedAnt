package com.unexpected.ant.gui.view;

import com.unexpected.ant.gui.AbstractEntitySwingView;
import com.unexpected.ant.gui.GuiManager;
import com.unexpected.ant.model.entity.DeodorantSpraySmell;

/**
 * Author: Balu
 */
public class DeodorantSpraySmellView extends AbstractEntitySwingView<DeodorantSpraySmell> {
    public DeodorantSpraySmellView(DeodorantSpraySmell entity, GuiManager guiManager) {
        super(entity, guiManager);
    }

    @Override
    protected String getAssetPath() {
        return "assets/deodorantspray.png";
    }
}
