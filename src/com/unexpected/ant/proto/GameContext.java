package com.unexpected.ant.proto;

import com.unexpected.ant.Timer;
import com.unexpected.ant.model.Cell;
import com.unexpected.ant.model.GameField;
import com.unexpected.ant.model.entity.*;

import java.util.HashMap;
import java.util.Map;

/**
 * This is a helper class for the proto tests
 */
public class GameContext {
	private GameField gameField = new GameField();

	private Map<Object, String> objectNames = new HashMap<>();

	private Map<String, Object> objects = new HashMap<>();
	private Timer timer = new Timer();

	public void addObject(Object object) {
		if (!objects.containsValue(object)) {
			addObjectWithId(generateId(object), object);
		}
	}

	private void addObjectWithId(String s, Object object) {
		objectNames.put(object, s);
		objects.put(s, object);
	}

	private String generateId(Object object) {
		Map<Class, String> classIds = new HashMap<Class, String>() {
			{
				put(Cell.class, "c");
				put(Ant.class, "a");
				put(AntLion.class, "l");
				put(AntHill.class, "h");
				put(Echidna.class, "e");
				put(Food.class, "f");
				put(FoodSmell.class, "fs");
				put(AntSmell.class, "as");
				put(DeodorantSpraySmell.class, "ds");
				put(KillerSpraySmell.class, "ks");
				put(Stone.class, "s");
				put(Obstacle.class, "o");
			}
		};

		String prefix = classIds.get(object.getClass());
		int i = 1;
		while (getObjectById(prefix + i) != null) {
			i++;
		}
		return prefix + i;
	}

	public Object getObjectById(String objectId) {
		return objects.get(objectId);
	}

	public GameField getGameField() {
		return gameField;
	}

	public void setGameField(GameField gameField) {
		this.gameField = gameField;
	}

	public String getObjectId(Object o) {
		return objectNames.get(o);
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}
}
