package com.unexpected.ant.model;

import com.unexpected.ant.model.entity.AntSmell;
import com.unexpected.ant.model.entity.Echidna;
import org.junit.Test;

public class CellTest {
    @Test
    public void testVisitByAllEntities() throws Exception {
        Cell cell = new Cell();
        cell.addEntity(new Echidna(Direction.SOUTHWEST));
        cell.addEntity(new Echidna(Direction.SOUTHWEST));
        cell.addEntity(new AntSmell());
        TestVisitor entityVisitor = new TestVisitor();
        cell.visitEntities(entityVisitor);
        assert entityVisitor.antSmellCounter == 1;
        assert entityVisitor.echnidnaCounter == 2;

    }

    private class TestVisitor extends EntityVisitorAdapter {
        public int echnidnaCounter;
        public int antSmellCounter;

        @Override
        public void visit(Echidna e) {
            echnidnaCounter++;
        }

        @Override
        public void visit(AntSmell a) {
            antSmellCounter++;
        }

    }
}
