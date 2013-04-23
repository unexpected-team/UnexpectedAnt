package com.unexpected.ant.proto.command;

import com.unexpected.ant.model.Dynamic;
import com.unexpected.ant.proto.AbstractCommand;
import com.unexpected.ant.proto.ParameterNotFoundException;

/**
 * Step an Dynamic one time
 */
public class StepEntityCommand extends AbstractCommand {
	@Override
	public void execute() throws ParameterNotFoundException {
		Object parsed = parse(getStringParameter(0));
//      if the given name is not an entity
		if (parsed == null || !(parsed instanceof Dynamic)) {
			getOutput().println("Az megadott objektum nem létezik vagy nem ütemezhető.");
			return;
		}
		Dynamic dynamic = (Dynamic) parsed;
		int param = getParameter(1, 1);
		if (param == 1) {
//          Call it's action with 0 parameter - it will call all of the methods we need to step it by one
			dynamic.action(0);
		} else {
			for (int i = 1; i <= param; i++) {
				dynamic.action(i);
			}
		}
	}
}
