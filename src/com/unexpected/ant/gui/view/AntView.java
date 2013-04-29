package com.unexpected.ant.gui.view;

import com.unexpected.ant.gui.AbstractSwingView;
import com.unexpected.ant.gui.GuiManager;
import com.unexpected.ant.model.entity.Ant;

/**
 * View for ants
 */
public class AntView extends AbstractSwingView<Ant> {
	public AntView(Ant entity, GuiManager guiManager) {
		super(entity, guiManager);
	}

	@Override
	protected String getAssetPath() {
		throw new UnsupportedOperationException();
	}
}
