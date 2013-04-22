package com.unexpected.ant.model.entity;

import com.unexpected.ant.model.AbstractEntity;
import com.unexpected.ant.model.Direction;

public class AntHill extends AbstractEntity {
	public Ant spawn() {
		Ant ant = new Ant(Direction.NORTH);
		getCell().addEntity(ant);
		return ant;
	}
}
