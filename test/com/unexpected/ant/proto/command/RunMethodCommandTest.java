package com.unexpected.ant.proto.command;

import com.unexpected.ant.model.Direction;
import com.unexpected.ant.model.entity.AntHill;
import com.unexpected.ant.model.entity.Echidna;
import org.junit.Test;

import static org.junit.Assert.*;

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
	public void testExecuteAddReturnedObjectToGameContext() throws Exception {
		gameContext.reset();
		AntHill h1 = new AntHill();
		h1.setCell(c1);
		gameContext.addObject(h1);
		command.setParameter("entityId", "h1");
		command.setParameter("method", "spawn");

		assertNull(gameContext.getObjectById("a1"));
		command.execute();
		assertNotNull(gameContext.getObjectById("a1"));
	}

	@Test
	public void testIntegerToIntConversion() throws Exception {
		Echidna e1 = new Echidna();
		assert !e1.isAsleep();
		gameContext.addObject(e1);
		command.setParameter("entityId", "e1");
		command.setParameter("method", "sleep");
		command.setParameter(0, "4");
		command.execute();
		assert e1.isAsleep();
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
