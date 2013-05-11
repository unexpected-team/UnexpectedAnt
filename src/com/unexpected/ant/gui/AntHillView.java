package com.unexpected.ant.gui;

import com.unexpected.ant.model.entity.AntHill;

public class AntHillView extends AbstractEntitySwingView<AntHill> {
	public AntHillView(AntHill entity, GuiManager guiManager) {
		super(entity, guiManager);
		setSize(80, 80);
		setBounds();
	}

	@Override
	protected String getAssetPath() {
		return "assets/anthill.png";
	}
}
