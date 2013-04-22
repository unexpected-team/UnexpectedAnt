package com.unexpected.ant.proto.command;

import com.unexpected.ant.model.Cell;
import com.unexpected.ant.model.Entity;
import com.unexpected.ant.model.GameField;
import com.unexpected.ant.proto.AbstractCommand;
import com.unexpected.ant.proto.ParameterNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Command for outputting the current state
 */
public class GetOutputCommand extends AbstractCommand {
	@Override
	public void execute() throws ParameterNotFoundException {
		GameField gameField = getGameContext().getGameField();
		Cell firstCell = null;
		Cell lastCell = null;
		for (Cell cell : gameField.getCells()) {
			if (firstCell == null)
				firstCell = cell;
			lastCell = cell;
//		    only run if the cell has at least one entity
			if (cell.getEntities().size() != 0) {
				getOutput().printf("%s ||", getGameContext().getObjectId(cell));
				boolean isFirst = true;
				List<Entity> entityList = new ArrayList<>(cell.getEntities());
				Collections.sort(entityList, new Comparator<Entity>() {
					@Override
					public int compare(Entity o1, Entity o2) {
						return getGameContext().getObjectId(o1).compareTo(getGameContext().getObjectId(o2));
					}
				});
				for (Entity entity : entityList) {
					getOutput().printf("%s%s",
							isFirst ? " " : ", ",
							getGameContext().getObjectId(entity));
					isFirst = false;
				}
				getOutput().print("\n");
			}
		}
		if (firstCell != null && lastCell != null) {
			getOutput().printf("%s - %s mezőnk van, a nem felsoroltak üresek.\n",
					getGameContext().getObjectId(firstCell), getGameContext().getObjectId(lastCell));
		}

	}
}
