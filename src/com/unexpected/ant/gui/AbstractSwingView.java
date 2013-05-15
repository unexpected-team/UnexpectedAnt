package com.unexpected.ant.gui;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractSwingView<T> extends JComponent implements View {
	protected GuiManager guiManager;
	protected T entity;

	public AbstractSwingView(T entity, GuiManager guiManager) {
		this.guiManager = guiManager;
		this.entity = entity;
		setPreferredSize(new Dimension(400, 400));
	}

	public int getZOrder() {
		return 0;
	}

	@Override
	public void update() {
		repaint();
	}

	public T getEntity() {
		return entity;
	}
}
