package com.unexpected.ant.gui;

import com.unexpected.ant.GameEngine;
import com.unexpected.ant.model.Direction;
import com.unexpected.ant.model.entity.*;

public class Main {
    public static void main(String[] args) {
        GameEngine.INSTANCE.reset();
        GameEngine.INSTANCE.getGameField().getCells().get(0).addEntity(new Food());
        GameEngine.INSTANCE.getGameField().getCells().get(1).addEntity(new Stone());
        GameEngine.INSTANCE.getGameField().getCells().get(4).addEntity(new Ant(Direction.NORTH));
        GameEngine.INSTANCE.getGameField().getCells().get(2).addEntity(new Obstacle(ObstacleType.PUDDLE));
        GameEngine.INSTANCE.getGameField().getCells().get(1).addEntity(new AntHill());
        GameEngine.INSTANCE.getGameFrame().setVisible(true);
        GameEngine.INSTANCE.getGameFrame().repaint();
    }
}
