package com.unexpected.ant.proto.command;

import org.junit.Test;

public class GetStatusCommandTest extends AbstractCommandTest<GetStatusCommand> {
	@Test
	public void testExecute() throws Exception {
		command.setParameter(0, "a1");
		command.execute();

//		assertEquals("facingDirection: NORTH\nhasFood: false\n", getOutput());
	}

	@Override
	protected GetStatusCommand initCommand() {
		return new GetStatusCommand();
	}
}
