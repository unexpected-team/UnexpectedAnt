package com.unexpected.ant.model;

import com.unexpected.ant.model.entity.*;

/**
 * Default implementation of the {@link EntityVisitor} interface, you should override one or more visit methods with
 * your custom implementations
 */
public abstract class EntityVisitorAdapter implements EntityVisitor {
    @Override
    public void visit(Entity entity) {

    }

    @Override
    public void visit(Ant ant) {
    }

    @Override
    public void visit(Echidna echidna) {
    }

    @Override
    public void visit(AntSmell antSmell) {
    }

    @Override
    public void visit(FoodSmell foodSmell) {
    }

    @Override
    public void visit(Food food) {
    }

}
