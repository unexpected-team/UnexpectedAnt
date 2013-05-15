package com.unexpected.ant.gui.view;

import com.unexpected.ant.gui.GuiManager;
import com.unexpected.ant.model.DeodorantSpray;

public class DeodorantSprayView extends SprayView {

	public DeodorantSprayView(DeodorantSpray entity, GuiManager guiManager) {
		super(entity, guiManager);
		update();
	}

	@Override
	protected String getAssetPath() {
		return "assets/deodorantspray.png";
	}

}
