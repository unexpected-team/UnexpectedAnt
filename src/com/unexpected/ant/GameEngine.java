package com.unexpected.ant;


import com.unexpected.ant.gui.GameFrame;
import com.unexpected.ant.gui.SwingViewFactory;
import com.unexpected.ant.gui.ViewFactory;
import com.unexpected.ant.gui.view.SprayListener;
import com.unexpected.ant.model.*;

public enum GameEngine {
	INSTANCE;
	private Spray deodorantSpray = new DeodorantSpray(10);
	private GameField gameField = new GameField();
	private GameFrame gameFrame = new GameFrame();
	private Spray killerSpray = new KillerSpray(10);
	private SprayListener sprayListener = new SprayListener();
	private Timer timer = new Timer();
	private ViewFactory viewFactory = new SwingViewFactory(gameFrame.getGamePanel());

	private GameEngine() {
	}

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
		initGameField();
	}

	private void initGameField() {
		Cell[] c = new Cell[33];
		for (int i = 1; i < 33; i++) {
			c[i] = new Cell();
			gameField.getCells().add(c[i]);
			c[i].setPosition((i - 1) / 4 * 110,
			                 ((i - 1) % 4) * 130 + ((i - 1) / 4 % 2 == 1 ? 65 : 0));
		}
		gameFrame.repaint();
		c[1].addNeighbour(Direction.SOUTHEAST, c[5]);
		c[2].addNeighbour(Direction.SOUTHEAST, c[6]);
		c[3].addNeighbour(Direction.SOUTHEAST, c[7]);
		c[4].addNeighbour(Direction.SOUTHEAST, c[8]);
		c[2].addNeighbour(Direction.NORTHEAST, c[5]);
		c[3].addNeighbour(Direction.NORTHEAST, c[6]);
		c[4].addNeighbour(Direction.NORTHEAST, c[7]);

		c[9].addNeighbour(Direction.SOUTHEAST, c[13]);
		c[10].addNeighbour(Direction.SOUTHEAST, c[14]);
		c[11].addNeighbour(Direction.SOUTHEAST, c[15]);
		c[12].addNeighbour(Direction.SOUTHEAST, c[16]);
		c[10].addNeighbour(Direction.NORTHEAST, c[13]);
		c[11].addNeighbour(Direction.NORTHEAST, c[14]);
		c[12].addNeighbour(Direction.NORTHEAST, c[15]);

		c[5].addNeighbour(Direction.SOUTHEAST, c[10]);
		c[6].addNeighbour(Direction.SOUTHEAST, c[11]);
		c[7].addNeighbour(Direction.SOUTHEAST, c[12]);

		c[5].addNeighbour(Direction.NORTHEAST, c[9]);
		c[6].addNeighbour(Direction.NORTHEAST, c[10]);
		c[7].addNeighbour(Direction.NORTHEAST, c[11]);
		c[8].addNeighbour(Direction.NORTHEAST, c[12]);

		c[1].addNeighbour(Direction.SOUTH, c[2]);
		c[2].addNeighbour(Direction.SOUTH, c[3]);
		c[3].addNeighbour(Direction.SOUTH, c[4]);
		c[5].addNeighbour(Direction.SOUTH, c[6]);
		c[6].addNeighbour(Direction.SOUTH, c[7]);
		c[7].addNeighbour(Direction.SOUTH, c[8]);
		c[9].addNeighbour(Direction.SOUTH, c[10]);
		c[10].addNeighbour(Direction.SOUTH, c[11]);
		c[11].addNeighbour(Direction.SOUTH, c[12]);
		c[13].addNeighbour(Direction.SOUTH, c[14]);
		c[14].addNeighbour(Direction.SOUTH, c[15]);
		c[15].addNeighbour(Direction.SOUTH, c[16]);
	}
}
