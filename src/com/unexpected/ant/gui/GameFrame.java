package com.unexpected.ant.gui;

import javax.swing.*;
import java.awt.*;

/**
 * JFrame for the game field
 */
public class GameFrame extends JFrame {
	public GamePanel gamePanel = new GamePanel();
	private JLabel background;


	public GameFrame() throws HeadlessException {
		init();
	}

	private void init() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(null);
		background = new JLabel(new ImageIcon("assets/bg.png"));
		background.setBounds(0, 0, 2000, 2000);
		setExtendedState(MAXIMIZED_BOTH);
		gamePanel.setBounds(100, 100, 2000, 2000);
		add(gamePanel);
		add(background);
	}

	public GamePanel getGamePanel() {
		return gamePanel;
	}

	public void setGamePanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
}
