package com.unexpected.ant.gui;

import com.unexpected.ant.GameEngine;
import com.unexpected.ant.model.entity.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) {
        /**
         * Set random position for entity
         */
        Integer[] num = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49};

        /**
         * As the Collections.shuffle method need a list for the parameter we convert our array into List using the Arrays class.
         */
        List<Integer> list = Arrays.asList(num);

        /**
         *   Here we just simply used the shuffle method of Collections class to shuffle out defined array.
         */
        Collections.shuffle(list);

        /**
         * Build GameField
         */
		GameEngine.INSTANCE.reset();
		GameEngine.INSTANCE.getGameField().getCells().get(list.get(0)).addEntity(new Food());
		GameEngine.INSTANCE.getGameField().getCells().get(list.get(1)).addEntity(new AntHill());
		GameEngine.INSTANCE.getGameField().getCells().get(list.get(2)).addEntity(new Obstacle(ObstacleType.PUDDLE));
		GameEngine.INSTANCE.getGameField().getCells().get(list.get(3)).addEntity(new Echidna());
		GameEngine.INSTANCE.getGameField().getCells().get(list.get(4)).addEntity(new Food());
        GameEngine.INSTANCE.getGameField().getCells().get(list.get(5)).addEntity(new Stone());
        GameEngine.INSTANCE.getGameField().getCells().get(list.get(6)).addEntity(new Stone());
        GameEngine.INSTANCE.getGameField().getCells().get(list.get(7)).addEntity(new AntLion());
        GameEngine.INSTANCE.getGameField().getCells().get(list.get(8)).addEntity(new AntLion());
		GameEngine.INSTANCE.getGameFrame().setVisible(true);
		GameEngine.INSTANCE.getGameFrame().repaint();
		GameEngine.INSTANCE.getTimer().start();
	}
}
