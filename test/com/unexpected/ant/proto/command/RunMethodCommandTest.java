package com.unexpected.ant.proto.command;

import com.unexpected.ant.model.Direction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RunMethodCommandTest extends AbstractCommandTest<RunMethodCommand> {

	@Test
	public void testExecuteAddCell() throws Exception {
		command.setParameter("entityId", "a1");
		command.setParameter("method", "addCell");
		command.setParameter(0, "c1");

		command.execute();
		assert a1.getCells().contains(c1);
	}

	@Test
	public void testExecuteSetFacingDirection() throws Exception {
		command.setParameter("entityId", "a1");
		command.setParameter("method", "setFacingDirection");
		command.setParameter(0, "NORTHWEST");

		command.execute();

		assertEquals(Direction.NORTHWEST, a1.getFacingDirection());
	}

	@Test
	public void testParse() throws Exception {
		assertEquals(a1, command.parse(gameContext.getObjectId(a1)));
		assertEquals(45, command.parse("45"));
		assertEquals("kutya", command.parse("kutya"));
		assertEquals(Direction.NORTH, command.parse("NORTH"));
	}

	@Override
	protected RunMethodCommand initCommand() {
		return new RunMethodCommand();
	}
}
