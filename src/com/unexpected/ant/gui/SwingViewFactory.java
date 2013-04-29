package com.unexpected.ant.gui;

import com.unexpected.ant.gui.view.AntView;
import com.unexpected.ant.gui.view.EchidnaView;
import com.unexpected.ant.model.entity.Ant;
import com.unexpected.ant.model.entity.Echidna;

/**
 * View factory which creates swing components
 */
public class SwingViewFactory implements ViewFactory {
	private GuiManager guiManager = new GuiManager();

	@Override
	public View createView(Ant ant) {
		return new AntView(ant, guiManager);
	}

	@Override
	public View createView(Echidna echidna) {
		return new EchidnaView(echidna, guiManager);
	}
}
