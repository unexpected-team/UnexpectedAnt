package com.unexpected.ant.skeleton_test;

import com.unexpected.ant.skeleton_test.test.*;
import org.junit.Test;

public class TestRunnerTest {
    @Test
    public void testRunAll() throws Exception {
        TestRunner testRunner = new TestRunner();
        testRunner.addTestCase(new BuildGameField());
        testRunner.addTestCase(new AntMoves());
        testRunner.addTestCase(new EchidnaMoves());
        testRunner.addTestCase(new AntEncountersObstacle());
        testRunner.addTestCase(new EchidnaEatsAnt());
        testRunner.addTestCase(new AntLionEatsAnt());
        testRunner.addTestCase(new AntEatsFood());
        testRunner.addTestCase(new KillerSprayKillsAnt());
        testRunner.addTestCase(new DeodorantSprayRemovesAntSmell());
        testRunner.runAll();
    }
}
