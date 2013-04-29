package com.unexpected.ant.gui;

import com.unexpected.ant.model.Entity;
import com.unexpected.ant.model.Vector;

import javax.swing.*;
import java.awt.*;

/**
 * Base class for entity swing views
 *
 * @param <T> The entity class
 */
public abstract class AbstractSwingView<T extends Entity> extends JComponent implements View {
	protected T entity;
	protected GuiManager guiManager;

	protected abstract String getAssetPath();

	public AbstractSwingView(T entity, GuiManager guiManager) {
		this.entity = entity;
		this.guiManager = guiManager;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Image image = new ImageIcon(getAssetPath()).getImage();
		Vector position = guiManager.getPosition(entity);
		g.drawImage(image, position.getX(), position.getY(), null);
	}

	@Override
	public void update() {
		revalidate();
	}
}
