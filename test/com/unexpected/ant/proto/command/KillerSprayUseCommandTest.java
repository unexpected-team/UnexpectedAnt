package com.unexpected.ant.proto.command;

import com.unexpected.ant.model.Entity;
import com.unexpected.ant.model.entity.KillerSpraySmell;
import org.junit.Test;

public class KillerSprayUseCommandTest extends com.unexpected.ant.proto.command.AbstractCommandTest<KillerSprayUseCommand> {
	@Test
	public void testExecute() throws Exception {
		command.setParameter(0, "c1");
		command.execute();
		boolean contains = false;
		for (Entity entity : c1.getEntities()) {
			if (entity instanceof KillerSpraySmell) {
				contains = true;
			}
		}

		assert contains;
	}

	@Override
	protected KillerSprayUseCommand initCommand() {
		return new KillerSprayUseCommand();
	}
}
