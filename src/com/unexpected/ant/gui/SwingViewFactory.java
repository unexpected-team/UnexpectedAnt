package com.unexpected.ant.gui;

import com.unexpected.ant.gui.view.*;
import com.unexpected.ant.gui.view.AntHillView;
import com.unexpected.ant.gui.view.AntView;
import com.unexpected.ant.gui.view.CellView;
import com.unexpected.ant.gui.view.EchidnaView;
import com.unexpected.ant.model.Cell;
import com.unexpected.ant.model.DeodorantSpray;
import com.unexpected.ant.model.KillerSpray;
import com.unexpected.ant.model.entity.*;

import java.awt.*;

/**
 * View factory which creates swing components
 */
public class SwingViewFactory implements ViewFactory {
    private Container container;
    private GuiManager guiManager = new GuiManager();

    public SwingViewFactory(Container container) {
        this.container = container;
    }

    @Override
    public View createView(Ant ant) {
        AntView view = new AntView(ant, guiManager);
        container.add(view);
        return view;
    }

    @Override
    public View createView(Echidna echidna) {
        EchidnaView view = new EchidnaView(echidna, guiManager);
        container.add(view);
        return view;
    }

	@Override
	public View createView(Cell cell) {
		CellView view = new CellView(cell, guiManager);
		container.add(view);
		return view;
	}

    @Override
    public View createView(AntHill antHill) {
        AntHillView view = new AntHillView(antHill, guiManager);
        container.add(view);
        return view;
    }

    @Override
    public View createView(AntLion antLion) {
        AntLionView view = new AntLionView(antLion, guiManager);
        container.add(view);
        return view;
    }

    @Override
    public View createView(DeodorantSpraySmell deodorantSpraySmell) {
        DeodorantSpraySmellView view = new DeodorantSpraySmellView(deodorantSpraySmell, guiManager);
        container.add(view);
        return view;
    }

    @Override
    public View createView(Food food) {
        FoodView view = new FoodView(food, guiManager);
        container.add(view);
        return view;
    }

    @Override
    public View createView(KillerSpraySmell killerSpraySmell) {
        KillerSpraySmellView view = new KillerSpraySmellView(killerSpraySmell, guiManager);
        container.add(view);
        return view;
    }

    @Override
    public View createView(Obstacle obstacle) {
        ObstacleView view = new ObstacleView(obstacle, guiManager);
        container.add(view);
        return view;
    }

    @Override
    public View createView(Stone stone) {
        StoneView view = new StoneView(stone, guiManager);
        container.add(view);
        return view;
    }

	@Override
	public View createView(KillerSpray killerSpray) {
		KillerSprayView view = new KillerSprayView(killerSpray, guiManager);
		view.setBounds(300, 0, 200, 50);
		container.add(view);
		return view;
	}

	@Override
	public View createView(DeodorantSpray deodorantSpray) {
		DeodorantSprayView view = new DeodorantSprayView(deodorantSpray, guiManager);
		view.setBounds(520, 0, 200, 50);
		container.add(view);
		return view;
	}
}
