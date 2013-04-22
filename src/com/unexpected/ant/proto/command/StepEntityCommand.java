package com.unexpected.ant.proto.command;

import com.unexpected.ant.model.Dynamic;
import com.unexpected.ant.proto.AbstractCommand;
import com.unexpected.ant.proto.ParameterNotFoundException;

public class StepEntityCommand extends AbstractCommand {
	@Override
	public void execute() throws ParameterNotFoundException {
		Object parsed = parse(getStringParameter(0));
		if (parsed == null || !(parsed instanceof Dynamic)) {
			getOutput().println("Az megadott objektum nem létezik vagy nem ütemezhető.");
			return;
		}
		Dynamic dynamic = (Dynamic) parsed;
		dynamic.action(0);
	}
}
