package com.unexpected.ant.gui;

import com.unexpected.ant.model.Cell;
import com.unexpected.ant.model.entity.Ant;
import com.unexpected.ant.model.entity.AntHill;
import com.unexpected.ant.model.entity.Echidna;

/**
 * Interface for all view factories
 */
public interface ViewFactory {
	View createView(Ant ant);

	View createView(Echidna echidna);

	View createView(Cell cell);

	View createView(AntHill antHill);
}
