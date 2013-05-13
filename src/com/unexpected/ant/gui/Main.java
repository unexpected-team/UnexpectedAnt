package com.unexpected.ant.gui;

import com.unexpected.ant.GameEngine;
import com.unexpected.ant.model.entity.*;

public class Main {
	public static void main(String[] args) {
		GameEngine.INSTANCE.reset();
		GameEngine.INSTANCE.getGameField().getCells().get(0).addEntity(new Food());
		GameEngine.INSTANCE.getGameField().getCells().get(1).addEntity(new AntHill());
		GameEngine.INSTANCE.getGameField().getCells().get(2).addEntity(new Obstacle(ObstacleType.PUDDLE));
		GameEngine.INSTANCE.getGameField().getCells().get(5).addEntity(new Echidna());
		GameEngine.INSTANCE.getGameField().getCells().get(6).addEntity(new Food());
		GameEngine.INSTANCE.getGameFrame().setVisible(true);
		GameEngine.INSTANCE.getGameFrame().repaint();
		GameEngine.INSTANCE.getTimer().start();
	}
}
