package com.unexpected.ant.model;

import com.unexpected.ant.model.entity.*;

/**
 * Visitor class for visiting entities using the visitor pattern. You should add a visit method for all the types
 * you want to visit.
 */
public interface EntityVisitor {
    void visit(Entity entity);

    void visit(Ant ant);

    void visit(Echidna echidna);

    void visit(AntSmell antSmell);

    void visit(FoodSmell foodSmell);

    void visit(Food food);

    void visit(Stone stone);
}
