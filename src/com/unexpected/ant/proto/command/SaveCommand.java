package com.unexpected.ant.proto.command;

import com.unexpected.ant.proto.AbstractCommand;
import com.unexpected.ant.proto.ParameterNotFoundException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveCommand extends AbstractCommand {
	@Override
	public void execute() throws ParameterNotFoundException {
		try {
			ObjectOutputStream saveFile = new ObjectOutputStream(new FileOutputStream(getStringParameter(0)));
			saveFile.writeObject(getGameContext());
			saveFile.close();
			getOutput().println("Sikeres mentés.");
		} catch (IOException e) {
			getOutput().println("Hiba történt a mentéskor.");
		}

	}
}
