package com.unexpected.ant.model;


import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GameField implements Serializable {
	@XmlElement
	private List<Cell> cells = new ArrayList<>();


	public List<Cell> getCells() {
		return cells;
	}

	public void setCells(List<Cell> cells) {
		this.cells = cells;
	}
}
