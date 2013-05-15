package com.unexpected.ant.gui.view;

import com.unexpected.ant.gui.GuiManager;
import com.unexpected.ant.model.KillerSpray;

public class KillerSprayView extends SprayView {

	public KillerSprayView(KillerSpray entity, GuiManager guiManager) {
		super(entity, guiManager);
	}

	@Override
	protected String getAssetPath() {
		return "assets/killerspray.png";
	}

}
