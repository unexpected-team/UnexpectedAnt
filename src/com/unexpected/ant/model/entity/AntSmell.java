package com.unexpected.ant.model.entity;

import com.unexpected.ant.model.EntityVisitor;

public class AntSmell extends Smell {
    @Override
    public void acceptVisitor(EntityVisitor visitor) {
        visitor.visit(this);
    }
}
