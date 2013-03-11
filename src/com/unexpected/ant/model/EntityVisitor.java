package com.unexpected.ant.model;

import com.unexpected.ant.model.entity.*;

public interface EntityVisitor {
    void visit(Entity entity);

    void visit(Ant ant);

    void visit(Echidna echidna);

    void visit(AntSmell antSmell);

    void visit(FoodSmell foodSmell);

    void visit(Food food);
}
