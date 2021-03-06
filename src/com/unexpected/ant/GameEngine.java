package com.unexpected.ant;


import com.unexpected.ant.gui.GameFrame;
import com.unexpected.ant.gui.SwingViewFactory;
import com.unexpected.ant.gui.ViewFactory;
import com.unexpected.ant.gui.view.SprayListener;
import com.unexpected.ant.model.*;
import com.unexpected.ant.model.entity.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum GameEngine {
	INSTANCE;
	private Spray deodorantSpray;
	private Spray killerSpray;
	private GameField gameField = new GameField();
	private GameFrame gameFrame = new GameFrame();
	private SprayListener sprayListener = new SprayListener();
	private Timer timer = new Timer();
	private ViewFactory viewFactory = new SwingViewFactory(gameFrame.getGamePanel());

	public Spray getDeodorantSpray() {
		return deodorantSpray;
	}

	public void setDeodorantSpray(Spray deodorantSpray) {
		this.deodorantSpray = deodorantSpray;
	}

	public GameField getGameField() {
		return gameField;
	}

	public void setGameField(GameField gameField) {
		this.gameField = gameField;
	}

	public GameFrame getGameFrame() {
		return gameFrame;
	}

	public void setGameFrame(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
	}

	public Spray getKillerSpray() {
		return killerSpray;
	}

	public void setKillerSpray(Spray killerSpray) {
		this.killerSpray = killerSpray;
	}

	public SprayListener getSprayListener() {
		return sprayListener;
	}

	public void setSprayListener(SprayListener sprayListener) {
		this.sprayListener = sprayListener;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public ViewFactory getViewFactory() {
		return viewFactory;
	}

	public void setViewFactory(ViewFactory viewFactory) {
		this.viewFactory = viewFactory;
	}

	public void reset() {
		gameFrame.getGamePanel().removeAll();
		timer.clear();
		initGameField(10, 8);
		killerSpray = new KillerSpray(10);
		deodorantSpray = new DeodorantSpray(10);
		gameFrame.repaint();
		gameFrame.getGamePanel().repaint();
	}

	public void gameOver() {
		long points = (int) (getTimer().getTick() * 10 + Math.random() * 10);
		JOptionPane.showMessageDialog(gameFrame, String.format("Játék vége! %d pontot szereztél.", points), "Játék vége",
		                              JOptionPane.PLAIN_MESSAGE);
		getTimer().stop();
	}

	private void initGameField(int x, int y) {
		gameField.clear();
		int fieldSizeX = 110;
		int fieldSizeY = 130;
		int marginTop = 0;

		if (x % 2 != 0 || y % 2 != 0) {
			throw new IllegalArgumentException("A pálya szélessége és magassága páros kell legyen!");
		}

        /*
        * if map is X = 6 and Y = 8, it looks like this (the numbers are the cell ids'):
        *
        *   0       8       16
        *       4       12      20
        *   1       9       17
        *       5       13      21
        *   2       10      18
        *       6       14      22
        *   3       11      19
        *       7       15      23
        */

		int fieldsNum = x * y / 2;

		Cell[] c = new Cell[fieldsNum];
		for (int i = 0; i < fieldsNum; i++) {
			c[i] = new Cell();
			gameField.getCells().add(c[i]);
			c[i].setPosition(
					((i - (i % y)) / y) * fieldSizeX * 2 + ((i % y) >= (y / 2) ? (fieldSizeX * 2 / 2) : 0)
					,
					marginTop + ((i % y) % (y / 2)) * fieldSizeY + ((i % y) >= (y / 2) ? (fieldSizeY / 2) : 0)
			                );
		}

		for (int i = 0; i < fieldsNum; i++) {
			int base = i + fieldsNum; // Because the fucking JAVA can't use modulo if the number is negative
			c[i].addNeighbour(Direction.NORTH, c[(base - 1 + (i % (y / 2) == 0 ? (y / 2) : 0)) % fieldsNum]);
			c[i].addNeighbour(Direction.NORTHEAST, c[(base + y / 2 - ((i % y) < (y / 2) ? 1 : 0) + (i % y == 0 ? y / 2 : 0)) % fieldsNum]);
			c[i].addNeighbour(Direction.NORTHWEST, c[(base - y / 2 - ((i % y) < (y / 2) ? 1 : 0) + (i % y == 0 ? y / 2 : 0)) % fieldsNum]);
		}
		putEntities();
	}

	private void putEntities() {
		List<Integer> randomList = new ArrayList<>();
		for (int i = 0; i < getGameField().getCells().size(); i++) {
			randomList.add(i);
		}
		Collections.shuffle(randomList);
		Entity[] entities = new Entity[]{
				new Food(), new AntHill(), new Obstacle(ObstacleType.PUDDLE), new Echidna(),
				new Stone(), new Stone(), new AntLion(), new AntLion(), new Echidna()
		};
		for (int i = 0; i < entities.length; i++) {
			getGameField().getCells().get(randomList.get(i)).addEntity(entities[i]);
		}
	}
}
