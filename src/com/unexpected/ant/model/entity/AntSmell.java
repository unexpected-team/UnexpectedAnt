package com.unexpected.ant.model.entity;

import com.unexpected.ant.model.EntityVisitor;

/**
 * This class represents the smell of the ants, which come from the ants
 */
public class AntSmell extends Smell {
    @Override
    public void acceptVisitor(EntityVisitor visitor) {
        visitor.visit(this);
    }
}
