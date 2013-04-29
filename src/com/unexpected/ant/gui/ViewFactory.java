package com.unexpected.ant.gui;

import com.unexpected.ant.model.entity.Ant;
import com.unexpected.ant.model.entity.Echidna;

/**
 * Interface for all view factories
 */
public interface ViewFactory {
	/**
	 *
	 */
	public View createView(Ant ant);

	public View createView(Echidna echidna);

}
