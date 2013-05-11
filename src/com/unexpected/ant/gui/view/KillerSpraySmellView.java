package com.unexpected.ant.gui.view;

import com.unexpected.ant.gui.AbstractEntitySwingView;
import com.unexpected.ant.gui.GuiManager;
import com.unexpected.ant.model.entity.KillerSpraySmell;

/**
 * Author: Balu
 */
public class KillerSpraySmellView extends AbstractEntitySwingView<KillerSpraySmell> {
    public KillerSpraySmellView(KillerSpraySmell entity, GuiManager guiManager) {
        super(entity, guiManager);
    }

    @Override
    protected String getAssetPath() {
        return "assets/killerspraysmell.png";
    }
}
