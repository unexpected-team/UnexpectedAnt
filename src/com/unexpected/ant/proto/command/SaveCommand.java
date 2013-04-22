package com.unexpected.ant.proto.command;

import com.unexpected.ant.model.GameField;
import com.unexpected.ant.proto.AbstractCommand;
import com.unexpected.ant.proto.ParameterNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class SaveCommand extends AbstractCommand {
	@Override
	public void execute() throws ParameterNotFoundException {
		File saveFile = new File(getStringParameter(0));
		try {
			JAXBContext context = JAXBContext.newInstance(GameField.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.marshal(getGameContext().getGameField(), saveFile);
			getOutput().println("Result saved to " + saveFile.getName());
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
