package com.unexpected.ant.gui.view;

import com.unexpected.ant.gui.AbstractEntitySwingView;
import com.unexpected.ant.gui.GuiManager;
import com.unexpected.ant.model.entity.AntLion;

/**
 * This class displays the antlions on the map.
 */
public class AntLionView extends AbstractEntitySwingView<AntLion> {
    public AntLionView(AntLion entity, GuiManager guiManager) {
        super(entity, guiManager);
    }

    /**
     * antlion picture
     * @return image
     */
    @Override
    protected String getAssetPath() {
        return "assets/antlion.png";
    }
}
