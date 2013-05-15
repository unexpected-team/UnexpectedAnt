package com.unexpected.ant.gui.view;

import com.unexpected.ant.gui.GuiManager;
import com.unexpected.ant.model.KillerSpray;

public class DeodorantSprayView extends SprayView {

	public DeodorantSprayView(KillerSpray entity, GuiManager guiManager) {
		super(entity, guiManager);
		init();
	}

	@Override
	protected String getAssetPath() {
		return "assets/killerspray.png";
	}

}
