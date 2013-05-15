package com.unexpected.ant.gui;

import com.unexpected.ant.GameEngine;

public class Main {
	public static void main(String[] args) {
		GameEngine.INSTANCE.getGameFrame().setVisible(true);
		GameEngine.INSTANCE.getGameFrame().getGamePanel().repaint();
		GameEngine.INSTANCE.getGameFrame().repaint();
	}
}
