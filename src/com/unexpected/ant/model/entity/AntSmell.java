package com.unexpected.ant.model.entity;

import com.unexpected.ant.model.EntityVisitor;

/**
 * This class represents the smell of the ants, which come from the ants
 */
public class AntSmell extends Smell {
    private Ant ant;

    public AntSmell(Ant ant) {
        this.ant = ant;
    }

    public AntSmell() {
        this(null);
    }

    @Override
    public void acceptVisitor(EntityVisitor visitor) {
        visitor.visit(this);
    }

    public Ant getAnt() {
        return ant;
    }

    public void setAnt(Ant ant) {
        this.ant = ant;
    }
}
