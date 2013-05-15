package com.unexpected.ant.gui;

import com.unexpected.ant.model.Cell;
import com.unexpected.ant.model.DeodorantSpray;
import com.unexpected.ant.model.KillerSpray;
import com.unexpected.ant.model.entity.*;

/**
 * Interface for all view factories
 */
public interface ViewFactory {
    View createView(Ant ant);

    View createView(Echidna echidna);

    View createView(Cell cell);

    View createView(AntHill antHill);

    View createView(AntLion antLion);

    View createView(DeodorantSpraySmell deodorantSpraySmell);

    View createView(Food food);

    View createView(KillerSpraySmell killerSpraySmell);

    View createView(Obstacle obstacle);

    View createView(Stone stone);

	View createView(KillerSpray killerSpray);

	View createView(DeodorantSpray deodorantSpray);
}
