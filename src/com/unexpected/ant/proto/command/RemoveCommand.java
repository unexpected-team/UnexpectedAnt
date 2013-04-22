package com.unexpected.ant.proto.command;

import com.unexpected.ant.model.Entity;
import com.unexpected.ant.proto.AbstractCommand;
import com.unexpected.ant.proto.ParameterNotFoundException;

/**
 *
 */
public class RemoveCommand extends AbstractCommand {

    @Override
    public void execute() throws ParameterNotFoundException {
        String entityId = getStringParameter(0);
        Entity entity = parse(entityId, Entity.class);
        if(entity != null) {
            entity.remove();
        }
    }
}
