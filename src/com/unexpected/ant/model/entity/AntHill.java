package com.unexpected.ant.model.entity;

import com.unexpected.ant.model.AbstractEntity;
import com.unexpected.ant.model.Direction;

public class AntHill extends AbstractEntity {
    public void spawn() {
        getCell().addEntity(new Ant(Direction.NORTH));
    }
}
