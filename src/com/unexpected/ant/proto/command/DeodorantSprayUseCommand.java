package com.unexpected.ant.proto.command;

import com.unexpected.ant.model.Cell;
import com.unexpected.ant.model.entity.DeodorantSpraySmell;
import com.unexpected.ant.proto.AbstractCommand;
import com.unexpected.ant.proto.ParameterNotFoundException;

public class DeodorantSprayUseCommand extends AbstractCommand {
	@Override
	public void execute() throws ParameterNotFoundException {
		Cell cell = parse(getStringParameter(0), Cell.class);
		if (cell != null) {
			DeodorantSpraySmell deodorantSpraySmell = new DeodorantSpraySmell();
			getGameContext().addObject(deodorantSpraySmell);
			cell.addEntity(deodorantSpraySmell);
		}
	}
}
