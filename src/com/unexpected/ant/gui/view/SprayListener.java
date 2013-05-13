package com.unexpected.ant.gui.view;

import com.unexpected.ant.GameEngine;
import com.unexpected.ant.model.Cell;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SprayListener extends MouseAdapter {
	@Override
	public void mouseClicked(MouseEvent e) {
		if (!(e.getComponent() instanceof CellView)) {
			return;
		}
		CellView clicked = (CellView) e.getComponent();
		Cell cell = clicked.getEntity();
		if (e.getButton() == MouseEvent.BUTTON1) {
			GameEngine.INSTANCE.getKillerSpray().infectArea(cell);
		}
		if (e.getButton() == MouseEvent.BUTTON3) {
			GameEngine.INSTANCE.getDeodorantSpray().infectArea(cell);
		}
	}
}
