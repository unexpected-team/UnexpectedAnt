package com.unexpected.ant.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GameField implements Serializable {
	private List<Cell> cells = new ArrayList<>();


	public List<Cell> getCells() {
		return cells;
	}

	public void setCells(List<Cell> cells) {
		this.cells = cells;
	}

	public void clear() {
		getCells().clear();
	}
}
