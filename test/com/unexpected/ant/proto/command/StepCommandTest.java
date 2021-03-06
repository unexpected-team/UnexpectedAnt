package com.unexpected.ant.proto.command;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StepCommandTest extends AbstractCommandTest<StepCommand> {
	@Test
	public void testExecute() throws Exception {
		command.setParameter(0, 3);
		command.execute();

		assertEquals(3, gameContext.getTimer().getTick());
		assertEquals("3 step végrehajtva\n", getOutput());
	}

	@Test
	public void testExecuteWithoutParams() throws Exception {
		command.execute();

		assertEquals(1, gameContext.getTimer().getTick());
	}


	@Override
	protected StepCommand initCommand() {
		return new StepCommand();
	}
}
