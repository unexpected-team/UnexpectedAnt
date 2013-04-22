package com.unexpected.ant.proto.command;

import com.unexpected.ant.model.Cell;
import com.unexpected.ant.model.Entity;
import com.unexpected.ant.proto.AbstractCommand;
import com.unexpected.ant.proto.ParameterNotFoundException;

import java.util.Arrays;

/**
 *
 */
public class PutCommand extends AbstractCommand {

    @Override
    public void execute() throws ParameterNotFoundException {
        String name = getStringParameter(0);
        Object newInstance = parse(name);
        if (!(newInstance instanceof Entity)) {
            getOutput().println("Hiba, nem létező Entity.");
            return;
        }
        Object cell = parse(getStringParameter(1));
        if(!(cell instanceof Cell)) {
            getOutput().println("Hiba, nem létező cella.");
            return;
        }
        ((Entity) newInstance).setCells(Arrays.asList((Cell) cell));
    }
}
