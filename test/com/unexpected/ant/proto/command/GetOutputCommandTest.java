package com.unexpected.ant.proto.command;

import com.unexpected.ant.model.GameField;
import com.unexpected.ant.model.entity.AntHill;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetOutputCommandTest extends AbstractCommandTest<GetOutputCommand> {
	@Test
	public void testExecute() throws Exception {
		AntHill h1 = new AntHill();

		gameContext.addObject(c1);
		gameContext.addObject(c2);
		gameContext.addObject(h1);
		gameContext.addObject(a1);

		c1.addEntity(h1);
		c1.addEntity(a1);

		GameField gameField = gameContext.getGameField();
		gameField.getCells().add(c1);
		gameField.getCells().add(c2);


		command.execute();

		assertEquals("c1 || a1, h1\nc1 - c2 mezőnk van, a nem felsoroltak üresek.\n", getOutput());
	}

	@Override
	protected GetOutputCommand initCommand() {
		return new GetOutputCommand();
	}
}
