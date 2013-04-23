package com.unexpected.ant.proto.command;

import org.junit.Test;

public class IgnoreFeedbackCommandTest extends com.unexpected.ant.proto.command.AbstractCommandTest<IgnoreFeedbackCommand> {
	@Test
	public void testExecuteIgnore() throws Exception {
		command.setParameter(0, "1");
		command.execute();
		assert gameContext.isIgnoreFeedback();
	}

	@Test
	public void testExecuteNotIgnore() throws Exception {
		command.setParameter(0, "0");
		command.execute();
		assert !gameContext.isIgnoreFeedback();
	}

	@Override
	protected IgnoreFeedbackCommand initCommand() {
		return new IgnoreFeedbackCommand();
	}
}
