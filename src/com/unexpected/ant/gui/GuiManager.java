package com.unexpected.ant.gui;

import com.unexpected.ant.model.Cell;
import com.unexpected.ant.model.Entity;
import com.unexpected.ant.model.Vector;

/**
 * Class for gui global methods among views
 */
public class GuiManager {
	/**
	 * Returns the physical position of an entity based on the cell it lies on and other entities on the same cell
	 *
	 * @param entity The entity
	 * @return a vector containing the x and y coordinates for the position
	 */
	public Vector getPosition(Entity entity) {
		try {
			Cell cell = entity.getCells().get(0);
			return cell.getPosition().add(new Vector(55, 45));
//			int i = GameEngine.INSTANCE.getGameField().getCells().indexOf(cell);
//			return new Vector(i * 150, 0);
		} catch (Exception e) {
			return new Vector(0, 0);
		}
	}

	/**
	 * Returns the physical position of a cell
	 *
	 * @param cell The cell
	 * @return a vector containing the x and y coordinates for the position
	 */
	public Vector getPosition(Cell cell) {
		throw new UnsupportedOperationException();
	}
}
