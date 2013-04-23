package com.unexpected.ant.proto.command;

import com.unexpected.ant.model.Entity;
import com.unexpected.ant.proto.AbstractCommand;
import com.unexpected.ant.proto.ParameterNotFoundException;

/**
 * Remove the Entity from the game field
 */
public class RemoveCommand extends AbstractCommand {

    @Override
    public void execute() throws ParameterNotFoundException {
        String entityId = getStringParameter(0);
        Entity entity = parse(entityId, Entity.class);
//      if it is exist, simple remove it
        if(entity != null) {
            entity.remove();
        }
    }
}
