package com.unexpected.ant.model;

import java.util.List;

public interface Entity {
    public List<Cell> getCells();

    public void setCells(List<Cell> cells);

    public void addCell(Cell cell);

    public void removeCell(Cell cell);

    public void removeCells(List<Cell> cells);

    boolean canBeOnSameCellWith(Entity entity);

    void remove();
}
