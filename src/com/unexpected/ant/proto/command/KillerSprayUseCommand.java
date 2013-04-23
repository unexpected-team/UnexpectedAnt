package com.unexpected.ant.proto.command;

import com.unexpected.ant.model.Cell;
import com.unexpected.ant.model.entity.KillerSpraySmell;
import com.unexpected.ant.proto.AbstractCommand;
import com.unexpected.ant.proto.ParameterNotFoundException;

/**
 * Command for using killer spray - put KillerSpraySmell on the specified cell and on it's neighbours
 */
public class KillerSprayUseCommand extends AbstractCommand {
	@Override
	public void execute() throws ParameterNotFoundException {
		Cell cell = parse(getStringParameter(0), Cell.class);
//      if the cell is not null...
		if (cell != null) {
//          ... create a KillerSpraySmell
			KillerSpraySmell killerSpraySmell = new KillerSpraySmell();
			getGameContext().addObject(killerSpraySmell);
//          ... and put it on the cell and it's neighbours
			cell.addEntity(killerSpraySmell);
            for (Cell neighbourCell : cell.getNeighbours()) {
                neighbourCell.addEntity(killerSpraySmell);
            }
        }
	}
}
