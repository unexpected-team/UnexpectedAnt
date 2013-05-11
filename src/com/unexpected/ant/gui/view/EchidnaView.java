package com.unexpected.ant.gui.view;

import com.unexpected.ant.gui.AbstractEntitySwingView;
import com.unexpected.ant.gui.GuiManager;
import com.unexpected.ant.model.entity.Echidna;

/**
 * View for echidnas
 */
public class EchidnaView extends AbstractEntitySwingView<Echidna> {
	public EchidnaView(Echidna entity, GuiManager guiManager) {
		super(entity, guiManager);
	}

	@Override
	protected String getAssetPath() {
		if (entity.isAsleep())
			return "assets/echidna_sleeps.png";
		return "assets/echidna.png";
	}
}
