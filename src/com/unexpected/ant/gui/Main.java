package com.unexpected.ant.gui;

import com.unexpected.ant.GameEngine;
import com.unexpected.ant.model.Direction;
import com.unexpected.ant.model.entity.Ant;
import com.unexpected.ant.model.entity.AntHill;
import com.unexpected.ant.model.entity.AntLion;
import com.unexpected.ant.model.entity.Echidna;

public class Main {
    public static void main(String[] args) {
        GameEngine.INSTANCE.reset();
        GameEngine.INSTANCE.getGameField().getCells().get(0).addEntity(new Echidna(Direction.SOUTHWEST));
        GameEngine.INSTANCE.getGameField().getCells().get(1).addEntity(new AntLion());
        GameEngine.INSTANCE.getGameField().getCells().get(4).addEntity(new Ant(Direction.NORTH));
        GameEngine.INSTANCE.getGameField().getCells().get(2).addEntity(new Echidna(Direction.NORTH));
        GameEngine.INSTANCE.getGameField().getCells().get(1).addEntity(new AntHill());
        GameEngine.INSTANCE.getGameFrame().setVisible(true);
        GameEngine.INSTANCE.getGameFrame().repaint();
    }
}
