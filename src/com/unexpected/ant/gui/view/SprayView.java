package com.unexpected.ant.gui.view;

import com.unexpected.ant.gui.AbstractSwingView;
import com.unexpected.ant.gui.GuiManager;
import com.unexpected.ant.model.Spray;

import javax.swing.*;
import java.awt.*;

public abstract class SprayView extends AbstractSwingView<Spray> {
	private JLabel label = new JLabel();

	public SprayView(Spray entity, GuiManager guiManager) {
		super(entity, guiManager);
		init();
	}

	protected void init() {
		setVisible(true);
		setLayout(new FlowLayout());
		Font font = label.getFont();
		font = font.deriveFont(30f);
		label.setFont(font);
		label.setForeground(Color.WHITE);
		ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource(getAssetPath()));
		imageIcon.setImage(imageIcon.getImage().getScaledInstance(-1, 40, 0));
		add(label);
		add(new JLabel(imageIcon));
		update();
	}

	protected abstract String getAssetPath();

	@Override
	public void update() {
		label.setText(String.valueOf(entity.getRemainingQuantity()));
		repaint();
	}
}
