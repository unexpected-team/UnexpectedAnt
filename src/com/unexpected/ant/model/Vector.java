package com.unexpected.ant.model;

/**
 * Class for representing a 2D coordinate on the game field
 */
public class Vector {
    private int x;
    private int y;

    /**
     * Default constructor, which defaults x and y to 0;
     */
    public Vector() {
        this(0, 0);
    }

    /**
     * Copy constructor
     *
     * @param vector Vector to be copied
     */
    public Vector(Vector vector) {
        this.x = vector.getX();
        this.y = vector.getY();
    }

    /**
     * Constructor with init values for x, y
     *
     * @param x
     * @param y
     */
    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
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
