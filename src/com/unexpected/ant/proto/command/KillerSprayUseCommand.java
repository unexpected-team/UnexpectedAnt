package com.unexpected.ant.proto.command;

import com.unexpected.ant.model.Cell;
import com.unexpected.ant.model.entity.KillerSpraySmell;
import com.unexpected.ant.proto.AbstractCommand;
import com.unexpected.ant.proto.ParameterNotFoundException;

public class KillerSprayUseCommand extends AbstractCommand {
	@Override
	public void execute() throws ParameterNotFoundException {
		Cell cell = parse(getStringParameter(0), Cell.class);
		if (cell != null) {
			KillerSpraySmell killerSpraySmell = new KillerSpraySmell();
			getGameContext().addObject(killerSpraySmell);
			cell.addEntity(killerSpraySmell);
		}
	}
}
