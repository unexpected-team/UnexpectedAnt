package com.unexpected.ant.proto.command;

import com.unexpected.ant.model.Direction;
import org.junit.Test;

public class StepEntityCommandTest extends AbstractCommandTest<StepEntityCommand> {
	@Test
	public void testExecute() throws Exception {
		a1.setFacingDirection(Direction.NORTH);
		command.setParameter(0, "a1");

		command.execute();
		assert c2.getEntities().contains(a1);
		assert !c1.getEntities().contains(a1);
	}

	@Override
	protected StepEntityCommand initCommand() {
		return new StepEntityCommand();
	}
}
