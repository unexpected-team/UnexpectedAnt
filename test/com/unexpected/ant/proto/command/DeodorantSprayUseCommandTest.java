package com.unexpected.ant.proto.command;

import com.unexpected.ant.model.Entity;
import com.unexpected.ant.model.entity.DeodorantSpraySmell;
import org.junit.Test;

public class DeodorantSprayUseCommandTest extends AbstractCommandTest<DeodorantSprayUseCommand> {
	@Test
	public void testExecute() throws Exception {
		command.setParameter(0, "c1");
		command.execute();
		boolean contains = false;
		for (Entity entity : c1.getEntities()) {
			if (entity instanceof DeodorantSpraySmell) {
				contains = true;
			}
		}

		assert contains;
	}

	@Override
	protected DeodorantSprayUseCommand initCommand() {
		return new DeodorantSprayUseCommand();
	}
}
