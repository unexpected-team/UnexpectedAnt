package com.unexpected.ant;


import com.unexpected.ant.gui.GameFrame;
import com.unexpected.ant.gui.SwingViewFactory;
import com.unexpected.ant.gui.ViewFactory;
import com.unexpected.ant.model.Cell;
import com.unexpected.ant.model.GameField;

public enum GameEngine {
	INSTANCE;
	private GameField gameField = new GameField();
	private GameFrame gameFrame = new GameFrame();
	private Timer timer = new Timer();
	private ViewFactory viewFactory = new SwingViewFactory(gameFrame.getGamePanel());

	private GameEngine() {
	}

	public void reset() {
		initGameField();
	}

	private void initGameField() {
		Cell[] c = new Cell[17];
		for (int i = 1; i < 6; i++) {
			c[i] = new Cell();
			gameField.getCells().add(c[i]);
		}
		c[1].setPosition(0, 0);
		c[2].setPosition(0, 1 * 130);
		c[3].setPosition(0, 2 * 130);
		c[5].setPosition(0, 2 * 130);
		c[4].setPosition(110, 130 / 2);
		c[5].setPosition(110, 130 + 130 / 2);
		gameFrame.repaint();
//		c[1].addNeighbour(Direction.SOUTHEAST, c[5]);
//		c[2].addNeighbour(Direction.SOUTHEAST, c[6]);
//		c[3].addNeighbour(Direction.SOUTHEAST, c[7]);
//		c[4].addNeighbour(Direction.SOUTHEAST, c[8]);
//		c[2].addNeighbour(Direction.NORTHEAST, c[5]);
//		c[3].addNeighbour(Direction.NORTHEAST, c[6]);
//		c[4].addNeighbour(Direction.NORTHEAST, c[7]);
//
//		c[9].addNeighbour(Direction.SOUTHEAST, c[13]);
//		c[10].addNeighbour(Direction.SOUTHEAST, c[14]);
//		c[11].addNeighbour(Direction.SOUTHEAST, c[15]);
//		c[12].addNeighbour(Direction.SOUTHEAST, c[16]);
//		c[10].addNeighbour(Direction.NORTHEAST, c[13]);
//		c[11].addNeighbour(Direction.NORTHEAST, c[14]);
//		c[12].addNeighbour(Direction.NORTHEAST, c[15]);
//
//		c[5].addNeighbour(Direction.SOUTHEAST, c[10]);
//		c[6].addNeighbour(Direction.SOUTHEAST, c[11]);
//		c[7].addNeighbour(Direction.SOUTHEAST, c[12]);
//
//		c[5].addNeighbour(Direction.NORTHEAST, c[9]);
//		c[6].addNeighbour(Direction.NORTHEAST, c[10]);
//		c[7].addNeighbour(Direction.NORTHEAST, c[11]);
//		c[8].addNeighbour(Direction.NORTHEAST, c[12]);
//
//		c[1].addNeighbour(Direction.SOUTH, c[2]);
//		c[2].addNeighbour(Direction.SOUTH, c[3]);
//		c[3].addNeighbour(Direction.SOUTH, c[4]);
//		c[5].addNeighbour(Direction.SOUTH, c[6]);
//		c[6].addNeighbour(Direction.SOUTH, c[7]);
//		c[7].addNeighbour(Direction.SOUTH, c[8]);
//		c[9].addNeighbour(Direction.SOUTH, c[10]);
//		c[10].addNeighbour(Direction.SOUTH, c[11]);
//		c[11].addNeighbour(Direction.SOUTH, c[12]);
//		c[13].addNeighbour(Direction.SOUTH, c[14]);
//		c[14].addNeighbour(Direction.SOUTH, c[15]);
//		c[15].addNeighbour(Direction.SOUTH, c[16]);
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
}
