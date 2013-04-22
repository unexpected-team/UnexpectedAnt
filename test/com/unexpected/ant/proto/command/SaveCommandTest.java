package com.unexpected.ant.proto.command;

import org.junit.Test;

public class SaveCommandTest extends AbstractCommandTest<SaveCommand> {

	@Test
	public void testExecute() throws Exception {
		command.setParameter(0, "output.dat");
		command.execute();
	}

	@Override
	protected SaveCommand initCommand() {
		return new SaveCommand();
	}


}
