package com.unexpected.ant.gui.view;

import com.unexpected.ant.gui.AbstractEntitySwingView;
import com.unexpected.ant.gui.GuiManager;
import com.unexpected.ant.model.entity.Obstacle;

/**
 * This class displays the obstacles on the map.
 */
public class ObstacleView extends AbstractEntitySwingView<Obstacle> {
	public ObstacleView(Obstacle entity, GuiManager guiManager) {
		super(entity, guiManager);
	}

    /**
     * otstacle picture
     */
	@Override
	protected String getAssetPath() {
		switch (entity.getObstacleType()) {
			case STONE:
				return "assets/stone.png";
			case PUDDLE:
				return "assets/puddle.png";
		}
		throw new InternalError();
	}
}
