package com.unexpected.ant.proto.command;

import com.unexpected.ant.model.Cell;
import com.unexpected.ant.model.Direction;
import com.unexpected.ant.model.GameField;
import com.unexpected.ant.model.entity.Ant;
import com.unexpected.ant.model.entity.AntHill;
import com.unexpected.ant.proto.GameContext;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class GetOutputCommandTest {
	@Test
	public void testExecute() throws Exception {
		GetOutputCommand command = new GetOutputCommand();
		GameContext gameContext = new GameContext();
		GameField gameField = new GameField();
		Cell c1 = new Cell();
		Cell c2 = new Cell();
		AntHill h1 = new AntHill();
		Ant a1 = new Ant(Direction.NORTH);

		gameContext.addObject(c1);
		gameContext.addObject(c2);
		gameContext.addObject(h1);
		gameContext.addObject(a1);
		gameContext.setGameField(gameField);

		c1.addEntity(h1);
		c1.addEntity(a1);

		gameField.getCells().add(c1);
		gameField.getCells().add(c2);

		command.setGameContext(gameContext);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		command.setOutput(new PrintStream(out));

		command.execute();

		assertEquals("c1 || a1, h1\nc1 - c2 mezőnk van, a nem felsoroltak üresek.\n", out.toString());
	}
}
