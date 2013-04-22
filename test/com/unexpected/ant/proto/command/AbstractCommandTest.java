package com.unexpected.ant.proto.command;

import com.unexpected.ant.model.Cell;
import com.unexpected.ant.model.Direction;
import com.unexpected.ant.model.entity.Ant;
import com.unexpected.ant.model.entity.Echidna;
import com.unexpected.ant.proto.Command;
import com.unexpected.ant.proto.GameContext;
import org.junit.Before;

public abstract class AbstractCommandTest<T extends Command> {
	protected T command = initCommand();

	protected abstract T initCommand();

	protected GameContext gameContext = new GameContext();
	protected Ant a1 = new Ant(Direction.NORTH);
	protected Cell c1 = new Cell();
	protected Cell c2 = new Cell();
	private Echidna e1 = new Echidna(Direction.NORTH);

	@Before
	public void setUp() throws Exception {
		command.setGameContext(gameContext);
		gameContext.addObject(a1);
		gameContext.addObject(c1);
		gameContext.addObject(c2);
		a1.moveTo(c1);
		c1.addNeighbour(Direction.SOUTH, c2);
	}
}
