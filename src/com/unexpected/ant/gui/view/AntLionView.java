package com.unexpected.ant.gui.view;

import com.unexpected.ant.gui.AbstractEntitySwingView;
import com.unexpected.ant.gui.GuiManager;
import com.unexpected.ant.model.entity.AntLion;

/**
 * Author: Balu
 */
public class AntLionView extends AbstractEntitySwingView<AntLion> {
    public AntLionView(AntLion entity, GuiManager guiManager) {
        super(entity, guiManager);
    }

    @Override
    protected String getAssetPath() {
        return "assets/antlion.png";
    }
}
