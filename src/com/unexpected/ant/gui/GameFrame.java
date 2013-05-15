package com.unexpected.ant.gui;

import com.unexpected.ant.GameEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

/**
 * JFrame for the game field
 */
public class GameFrame extends JFrame {
	private GamePanel gamePanel = new GamePanel();
	private JLabel background;


	public GameFrame() throws HeadlessException {
		init();
	}

    /**
     * Initialize window
     */
	private void init() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception ignored) {
		}
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("A Hangyás játék by Unexpected");
		setLayout(null);
		initMenu();
		background = new JLabel(new ImageIcon(getClass().getResource("/assets/bg.png")));
		background.setBounds(0, 0, 2000, 2000);
		gamePanel.setBounds(0, 0, 2000, 2000);
		setBounds(100, 20, 1155, 648);
		add(gamePanel);
		add(background);
	}

    /**
     * Initialize menu
     */
	private void initMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menü");
		menuBar.add(menu);
		JMenuItem newGameItem = new JMenuItem("Új játék");
		newGameItem.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GameEngine.INSTANCE.reset();
				GameEngine.INSTANCE.getTimer().start();
				gamePanel.repaint();
			}
		});
		menu.add(newGameItem);
		JMenuItem exitItem = new JMenuItem("Kilépés");
		exitItem.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispatchEvent(new WindowEvent(GameFrame.this, WindowEvent.WINDOW_CLOSING));
			}
		});
		menu.add(exitItem);
		setJMenuBar(menuBar);
	}

	public GamePanel getGamePanel() {
		return gamePanel;
	}

	public void setGamePanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
}
