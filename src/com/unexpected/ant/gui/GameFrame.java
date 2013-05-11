package com.unexpected.ant.gui;

import javax.swing.*;
import java.awt.*;

/**
 * JFrame for the game field
 */
public class GameFrame extends JFrame {
	public GamePanel gamePanel = new GamePanel();

	public GameFrame() throws HeadlessException {
		init();
	}

	private void init() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(600, 600);
		add(gamePanel);
	}

	public GamePanel getGamePanel() {
		return gamePanel;
	}

	public void setGamePanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
}
