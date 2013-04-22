package com.unexpected.ant.proto.command;

import org.junit.Test;

public class GetMethodsCommandTest extends AbstractCommandTest<GetMethodsCommand> {
	@Test
	public void testExecute() throws Exception {
		command.setParameter(0, "a1");
		command.execute();
		assert getOutput().length() > 200;
		System.out.println(getOutput());
	}

	@Override
	protected GetMethodsCommand initCommand() {
		return new GetMethodsCommand();
	}
}
