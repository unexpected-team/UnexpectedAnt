package com.unexpected.ant.proto.command;

import com.unexpected.ant.model.Cell;
import com.unexpected.ant.model.Entity;
import com.unexpected.ant.proto.AbstractCommand;
import com.unexpected.ant.proto.ParameterNotFoundException;

import java.util.Arrays;

/**
 * Put a new entity (specified type) on the game field
 */
public class PutCommand extends AbstractCommand {

	@Override
	public void execute() throws ParameterNotFoundException {
		String name = getStringParameter(0);
		Object newInstance = parse(name);
//      if it is not an entity, print out an error, and return
		if (!(newInstance instanceof Entity)) {
			getOutput().println("Hiba, nem létező Entity.");
			return;
		}
//      if the destination place is not a cell, print out and error and return
		Object cell = parse(getStringParameter(1));
		if (!(cell instanceof Cell)) {
			getOutput().println("Hiba, nem létező cella.");
			return;
		}
//      if everything is OK, put the new Entity on the specified Cell
		((Entity) newInstance).setCells(Arrays.asList((Cell) cell));
		getOutput().printf("%s elhelyezve\n", getGameContext().getObjectId(newInstance));
	}
}
