package com.unexpected.ant.proto;

import com.unexpected.ant.Timer;
import com.unexpected.ant.model.Cell;
import com.unexpected.ant.model.Dynamic;
import com.unexpected.ant.model.GameField;
import com.unexpected.ant.model.entity.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * This is a helper class for the proto tests
 */
public class GameContext implements Serializable {
	private GameField gameField = new GameField();

	private Map<Object, String> objectNames = new HashMap<>();

	private Map<String, Object> objects = new HashMap<>();

	private Timer timer = new Timer();

	private boolean ignoreFeedback = false;

	public void addObject(Object object) {
		if (!objects.containsValue(object)) {
			addObjectWithId(generateId(object), object);
			if (object instanceof Dynamic) {
				timer.add((Dynamic) object);
			}
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

	public void load(GameContext context) {
		this.gameField = context.gameField;
		this.objectNames = context.objectNames;
		this.objects = context.objects;
		this.timer = context.timer;
	}

	public void reset() {
		gameField.getCells().clear();
		timer.clear();
		objectNames.clear();
		objects.clear();

	}

	public boolean isIgnoreFeedback() {
		return ignoreFeedback;
	}

	public void setIgnoreFeedback(boolean ignoreFeedback) {
		this.ignoreFeedback = ignoreFeedback;
	}
}
