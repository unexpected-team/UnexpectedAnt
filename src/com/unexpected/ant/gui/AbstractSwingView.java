package com.unexpected.ant.gui;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractSwingView<T> extends JComponent implements View {
	protected GuiManager guiManager;
	protected T entity;

	public AbstractSwingView(GuiManager guiManager, T entity) {
		this.guiManager = guiManager;
		this.entity = entity;
		setPreferredSize(new Dimension(400, 400));
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(getX(), getY(), getWidth(), getHeight());
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
