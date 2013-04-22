package com.unexpected.ant.proto.command;

import com.unexpected.ant.proto.Command;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 *
 */
public class RemoveCommandTest extends AbstractCommandTest<RemoveCommand> {
    @Test
    public void testExecute() throws Exception {
        assert c1.getEntities().contains(a1);

        command.setParameter(0, "a1");
        command.execute();

        assert !(c1.getEntities().contains(a1));
    }

    @Override
    protected RemoveCommand initCommand() {
        return new RemoveCommand();
    }
}
