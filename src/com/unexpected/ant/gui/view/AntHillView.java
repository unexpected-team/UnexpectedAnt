package com.unexpected.ant.gui.view;

import com.unexpected.ant.gui.AbstractEntitySwingView;
import com.unexpected.ant.gui.GuiManager;
import com.unexpected.ant.model.entity.AntHill;

/**
 * This class displays the anthills on the map.
 */
public class AntHillView extends AbstractEntitySwingView<AntHill> {
	public AntHillView(AntHill entity, GuiManager guiManager) {
		super(entity, guiManager);
		setSize(80, 80);
		setBounds();
	}

    /**
     * anthill picture
     * @return image
     */
	@Override
	protected String getAssetPath() {
		return "assets/anthill.png";
	}
}
