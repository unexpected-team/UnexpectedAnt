package com.unexpected.ant.model.entity;

import com.unexpected.ant.model.AbstractEntity;
import com.unexpected.ant.model.Direction;

public class AntHill extends AbstractEntity {
    @Override
    public void action(long tickCount) {
        if(tickCount % 50 == 0)
            spawn();
    }

    public Ant spawn() {
		Ant ant = new Ant(Direction.NORTH);
		getCell().addEntity(ant);
		return ant;
	}
}
