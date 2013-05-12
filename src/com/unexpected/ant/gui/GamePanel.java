package com.unexpected.ant.gui;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

	public GamePanel() {
		setLayout(null);
		setOpaque(false);
	}

	@Override
	public Component add(Component compParam) {
		Component component = super.add(compParam);
		if (compParam instanceof AbstractEntitySwingView<?>) {
			int zOrder = ((AbstractSwingView<?>) compParam).getZOrder();
			zOrder = Math.min(zOrder, getComponentCount() - 1);
			setComponentZOrder(component, zOrder);
		}
		return component;
	}
}
