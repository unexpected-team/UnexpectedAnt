package com.unexpected.ant.gui.view;

import com.unexpected.ant.gui.AbstractSwingView;
import com.unexpected.ant.gui.GuiManager;
import com.unexpected.ant.model.KillerSpray;

import javax.swing.*;
import java.awt.*;

public abstract class SprayView extends AbstractSwingView<KillerSpray> {
	private JLabel label = new JLabel();

	public SprayView(KillerSpray entity, GuiManager guiManager) {
		super(entity, guiManager);
	}

	protected void init() {
		setLayout(new FlowLayout());
		Font font = label.getFont();
		font = font.deriveFont(30f);
		label.setFont(font);
		label.setForeground(Color.WHITE);
		ImageIcon imageIcon = new ImageIcon(getAssetPath());
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
