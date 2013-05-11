package com.unexpected.ant.gui.view;

import com.unexpected.ant.gui.AbstractEntitySwingView;
import com.unexpected.ant.gui.GuiManager;
import com.unexpected.ant.model.entity.Ant;

/**
 * View for ants
 */
public class AntView extends AbstractEntitySwingView<Ant> {
	public AntView(Ant entity, GuiManager guiManager) {
		super(entity, guiManager);
	}

	@Override
	protected String getAssetPath() {
		return "assets/ant.png";
	}

	@Override
	public double getRotation() {
		return Math.PI * 2 * entity.getFacingDirection().value() / 6;
	}
}
