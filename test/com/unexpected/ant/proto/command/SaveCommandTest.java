package com.unexpected.ant.proto.command;

import com.unexpected.ant.model.Cell;
import com.unexpected.ant.model.Direction;
import com.unexpected.ant.model.GameField;
import org.junit.Test;

public class SaveCommandTest extends AbstractCommandTest<SaveCommand> {

	@Test
	public void testExecute() throws Exception {
		GameField gameField = gameContext.getGameField();
		gameContext.reset();
		Cell[] c = new Cell[17];
		for (int i = 1; i < 17; i++) {
			c[i] = new Cell();
			gameContext.addObject(c[i]);
			gameField.getCells().add(c[i]);
		}
		c[1].addNeighbour(Direction.SOUTHEAST, c[5]);
		c[2].addNeighbour(Direction.SOUTHEAST, c[6]);
		c[3].addNeighbour(Direction.SOUTHEAST, c[7]);
		c[4].addNeighbour(Direction.SOUTHEAST, c[8]);
		c[2].addNeighbour(Direction.NORTHEAST, c[5]);
		c[3].addNeighbour(Direction.NORTHEAST, c[6]);
		c[4].addNeighbour(Direction.NORTHEAST, c[7]);

		c[9].addNeighbour(Direction.SOUTHEAST, c[13]);
		c[10].addNeighbour(Direction.SOUTHEAST, c[14]);
		c[11].addNeighbour(Direction.SOUTHEAST, c[15]);
		c[12].addNeighbour(Direction.SOUTHEAST, c[16]);
		c[10].addNeighbour(Direction.NORTHEAST, c[13]);
		c[11].addNeighbour(Direction.NORTHEAST, c[14]);
		c[12].addNeighbour(Direction.NORTHEAST, c[15]);

		c[5].addNeighbour(Direction.SOUTHEAST, c[10]);
		c[6].addNeighbour(Direction.SOUTHEAST, c[11]);
		c[7].addNeighbour(Direction.SOUTHEAST, c[12]);

		c[5].addNeighbour(Direction.NORTHEAST, c[9]);
		c[6].addNeighbour(Direction.NORTHEAST, c[10]);
		c[7].addNeighbour(Direction.NORTHEAST, c[11]);
		c[8].addNeighbour(Direction.NORTHEAST, c[12]);

		c[1].addNeighbour(Direction.SOUTH, c[2]);
		c[2].addNeighbour(Direction.SOUTH, c[3]);
		c[3].addNeighbour(Direction.SOUTH, c[4]);
		c[5].addNeighbour(Direction.SOUTH, c[6]);
		c[6].addNeighbour(Direction.SOUTH, c[7]);
		c[7].addNeighbour(Direction.SOUTH, c[8]);
		c[9].addNeighbour(Direction.SOUTH, c[10]);
		c[10].addNeighbour(Direction.SOUTH, c[11]);
		c[11].addNeighbour(Direction.SOUTH, c[12]);
		c[13].addNeighbour(Direction.SOUTH, c[14]);
		c[14].addNeighbour(Direction.SOUTH, c[15]);
		c[15].addNeighbour(Direction.SOUTH, c[16]);


		command.setParameter(0, "output.dat");
		command.execute();
	}

	@Override
	protected SaveCommand initCommand() {
		return new SaveCommand();
	}


}
