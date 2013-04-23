package com.unexpected.ant.proto.command;

import com.unexpected.ant.proto.AbstractCommand;
import com.unexpected.ant.proto.ParameterNotFoundException;

public class IgnoreFeedbackCommand extends AbstractCommand {
	@Override
	public void execute() throws ParameterNotFoundException {
		Object ignore = getParameter(0);
		getGameContext().setIgnoreFeedback(!ignore.equals(0));
	}
}
