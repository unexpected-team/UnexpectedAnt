package com.unexpected.ant.proto.command;

import com.unexpected.ant.model.Cell;
import com.unexpected.ant.model.GameField;
import com.unexpected.ant.proto.GameContext;
import org.junit.Before;
import org.junit.Test;

public class SaveCommandTest {
	SaveCommand saveCommand;

	@Before
	public void setUp() throws Exception {
		saveCommand = new SaveCommand();
		GameField gameField = new GameField();
		gameField.getCells().add(new Cell());
		saveCommand.setParameter(0, "output.xml");
		GameContext gameContext = new GameContext();
		gameContext.setGameField(gameField);
		saveCommand.setGameContext(gameContext);
	}

	@Test
	public void testExecute() throws Exception {
		saveCommand.execute();
	}
}
