package com.unexpected.ant.gui.view;

import com.unexpected.ant.gui.AbstractSwingView;
import com.unexpected.ant.gui.GuiManager;
import com.unexpected.ant.model.entity.Echidna;

/**
 * View for echidnas
 */
public class EchidnaView extends AbstractSwingView<Echidna> {

	public EchidnaView(Echidna entity, GuiManager guiManager) {
		super(entity, guiManager);
	}

	@Override
	protected String getAssetPath() {
		throw new UnsupportedOperationException();
	}
}
