package com.unexpected.ant.model;

public class Vector {
    private int x;
    private int y;

    public Vector(Vector vector) {
        this.x = vector.getX();
        this.y = vector.getY();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
