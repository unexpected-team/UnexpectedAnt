package com.unexpected.ant.proto.command;

import com.unexpected.ant.proto.AbstractCommand;
import com.unexpected.ant.proto.ParameterNotFoundException;

/**
 * Exit from the program
 */
public class ExitCommand extends AbstractCommand {
	@Override
	public void execute() throws ParameterNotFoundException {
		throw new ExitRequestedException();
	}
}
