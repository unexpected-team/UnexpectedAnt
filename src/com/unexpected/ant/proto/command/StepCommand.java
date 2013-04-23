package com.unexpected.ant.proto.command;

import com.unexpected.ant.proto.AbstractCommand;
import com.unexpected.ant.proto.ParameterNotFoundException;

public class StepCommand extends AbstractCommand {
	@Override
	public void execute() throws ParameterNotFoundException {
		for (int i = 0; i < (int) getParameter(0, 1); i++) {
			getGameContext().getTimer().schedule();
		}
	}

}
