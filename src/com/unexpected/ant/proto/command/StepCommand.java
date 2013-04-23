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
		int steps = (int) getParameter(0, 1);
		for (int i = 0; i < steps; i++) {
			getGameContext().getTimer().schedule();
		}
		getOutput().printf("%d step végrehajtva\n", steps);
	}
}
