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
public abstract class AbstractEntitySwingView<T extends Entity> extends AbstractSwingView {
	protected T entity;

	protected abstract String getAssetPath();

	public AbstractEntitySwingView(T entity, GuiManager guiManager) {
		super(entity, guiManager);
		this.entity = entity;
		setSize(40, 40);
		setBounds();
	}

	protected void setBounds() {
		Vector position = getPosition();
		setBounds(position.getX(), position.getY(), getWidth(), getHeight());
	}

	public Vector getPosition() {
		return guiManager.getPosition(entity);
	}

    /**
     * Graphics draw
     * @param g
     */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (entity.getCells().isEmpty()) {
			return;
		}
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

		//rotate
		g2d.rotate(getRotation(), getWidth() / 2, getHeight() / 2);

		//draw scaled image
		g2d.drawImage(getImage(), 0, 0, getWidth(), getHeight(), null);
	}

	public double getRotation() {
		return 0;
	}

	protected Image getImage() {
		return new ImageIcon(getClass().getClassLoader().getResource(getAssetPath())).getImage();
	}

	@Override
	public void update() {
		setBounds();
		super.update();
	}
}
