package com.unexpected.ant.model.entity;

import com.unexpected.ant.model.EntityVisitorAdapter;

/**
 * This class is for smelling the surrounding cells
 */
abstract class SmellVisitor extends EntityVisitorAdapter {
    protected int smell = 0;

    public int getSmell() {
        return smell;
    }
}
