package com.unexpected.ant.proto.command;

import com.unexpected.ant.proto.AbstractCommand;
import com.unexpected.ant.proto.GameContext;
import com.unexpected.ant.proto.ParameterNotFoundException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Load a mapfile.map into the game
 */
public class LoadCommand extends AbstractCommand {
	@Override
	public void execute() throws ParameterNotFoundException {
//      it's using the GameContext's methods
		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(getStringParameter(0)));
			GameContext ctx = (GameContext) objectInputStream.readObject();
			getGameContext().load(ctx);
			objectInputStream.close();
			if (!getGameContext().isIgnoreFeedback()) {
				getOutput().println("Sikeres betöltés.");
			}
		} catch (IOException | ClassNotFoundException e) {
			getOutput().println("Hiba történt a betöltéskor");
		}
	}
}
