package com.unexpected.ant.proto.command;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 *
 */
public class PutCommandTest extends AbstractCommandTest<PutCommand> {
    @Test
    public void testExecute() throws Exception {
        command.setParameter(0, "Ant");
        command.setParameter(1, "c2");
        command.execute();
        command.execute();

        assertEquals(2, c2.getEntities().size());
    }

    @Override
    protected PutCommand initCommand() {
        return new PutCommand();
    }
}
