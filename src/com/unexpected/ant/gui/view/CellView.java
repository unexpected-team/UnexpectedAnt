package com.unexpected.ant.gui.view;

import com.unexpected.ant.GameEngine;
import com.unexpected.ant.gui.AbstractSwingView;
import com.unexpected.ant.gui.GuiManager;
import com.unexpected.ant.model.Cell;
import com.unexpected.ant.model.Vector;

import javax.swing.*;
import java.awt.*;

public class CellView extends AbstractSwingView<Cell> {
	public CellView(Cell entity, GuiManager guiManager) {
		super(entity, guiManager);
		addMouseListener(GameEngine.INSTANCE.getSprayListener());
	}

    /**
     * ant picture
     * @return image
     */
	protected String getAssetPath() {
		return "/assets/tile.png";
	}

	@Override
	public int getZOrder() {
		return 2;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image image = new ImageIcon(getClass().getResource(getAssetPath())).getImage();
		g.drawImage(image, 0, 0, null);
	}

	@Override
	public void update() {
		Vector position = entity.getPosition();
		setBounds(position.getX(), position.getY(), getWidth(), getHeight());
		super.update();
	}

	@Override
	public int getWidth() {
		return 150;
	}

	@Override
	public int getHeight() {
		return 134;
	}

}

