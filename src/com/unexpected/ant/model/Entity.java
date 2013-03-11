package com.unexpected.ant.model;

import java.util.List;

public interface Entity {
    public void addCell(Cell cell);

    boolean canBeOnSameCellWith(Entity entity);

    public List<Cell> getCells();

    void remove();

    public void removeCell(Cell cell);

    public void removeCells(List<Cell> cells);

    public void setCells(List<Cell> cells);

    void acceptVisitor(EntityVisitor visitor);
}
