package com.unexpected.ant.gui;

import com.unexpected.ant.gui.view.AntHillView;
import com.unexpected.ant.gui.view.AntView;
import com.unexpected.ant.gui.view.CellView;
import com.unexpected.ant.gui.view.EchidnaView;
import com.unexpected.ant.model.Cell;
import com.unexpected.ant.model.entity.Ant;
import com.unexpected.ant.model.entity.AntHill;
import com.unexpected.ant.model.entity.Echidna;

import java.awt.*;

/**
 * View factory which creates swing components
 */
public class SwingViewFactory implements ViewFactory {
	private Container container;
	private GuiManager guiManager = new GuiManager();

	public SwingViewFactory(Container container) {
		this.container = container;
	}

	@Override
	public View createView(Ant ant) {
		AntView view = new AntView(ant, guiManager);
		container.add(view);
		return view;
	}

	@Override
	public View createView(Echidna echidna) {
		EchidnaView view = new EchidnaView(echidna, guiManager);
		container.add(view);
		return view;
	}

	@Override
	public View createView(Cell cell) {
		CellView view = new CellView(cell, guiManager);
		container.add(view);
		return view;
	}

	@Override
	public View createView(AntHill antHill) {
		AntHillView view = new AntHillView(antHill, guiManager);
		container.add(view);
		return view;
	}
}
