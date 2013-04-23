package com.unexpected.ant.proto.command;

import com.unexpected.ant.proto.AbstractCommand;
import com.unexpected.ant.proto.ParameterNotFoundException;

/**
 * Increment the timer's time (tick) with the given amount
 */
public class StepCommand extends AbstractCommand {
	@Override
	public void execute() throws ParameterNotFoundException {
//      running the given number of schedule
		for (int i = 0; i < (int) getParameter(0, 1); i++) {
			getGameContext().getTimer().schedule();
		}
	}

}
