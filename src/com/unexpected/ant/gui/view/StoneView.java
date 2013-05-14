package com.unexpected.ant.gui.view;

import com.unexpected.ant.gui.AbstractEntitySwingView;
import com.unexpected.ant.gui.GuiManager;
import com.unexpected.ant.model.entity.Stone;

/**
 * This class displays the stones on the map.
 */
public class StoneView extends AbstractEntitySwingView<Stone> {
    public StoneView(Stone entity, GuiManager guiManager) {
        super(entity, guiManager);
    }

    /**
     * stone picture
     * @return image
     */
    @Override
    protected String getAssetPath() {
        return "assets/stone.png";
    }
}
