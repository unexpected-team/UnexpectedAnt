package com.unexpected.ant;


import com.unexpected.ant.gui.SwingViewFactory;
import com.unexpected.ant.gui.ViewFactory;

public enum GameEngine {
	INSTANCE;
	private ViewFactory viewFactory = new SwingViewFactory();
	private Timer timer = new Timer();

	public ViewFactory getViewFactory() {
		return viewFactory;
	}

	public Timer getTimer() {
		return timer;
	}
}
