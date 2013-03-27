package com.unexpected.ant;

import com.unexpected.ant.skeleton_test.TestCase;
import com.unexpected.ant.skeleton_test.TestDoesNotExistException;
import com.unexpected.ant.skeleton_test.TestRunner;
import com.unexpected.ant.skeleton_test.test.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    TestRunner testRunner = new TestRunner();

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        addTestCases();
        while (true) {
            displayTestCases();
            System.out.print("Írd be a teszteset számát(0=kilép): ");
            Scanner scanner = new Scanner(System.in);
            int testCase = scanner.nextInt();
            //exit on 0
            if (testCase == 0) {
                break;
            }
            try {
                // try to run the test
                testRunner.run(testCase - 1);
            } catch (TestDoesNotExistException e) {
                // if test does not exist
                System.out.println("Ilyen teszt nem létezik");
            }
        }
    }

    private void addTestCases() {
        testRunner.addTestCase(new BuildGameField());
        testRunner.addTestCase(new AntMoves());
        testRunner.addTestCase(new EchidnaMoves());
        testRunner.addTestCase(new AntEncountersObstacle());
        testRunner.addTestCase(new EchidnaEatsAnt());
        testRunner.addTestCase(new AntLionEatsAnt());
        testRunner.addTestCase(new AntEatsFood());
        testRunner.addTestCase(new KillerSprayKillsAnt());
        testRunner.addTestCase(new DeodorantSprayRemovesAntSmell());
    }

    public void displayTestCases() {
        List<TestCase> testCases = testRunner.getTestCases();
        for (int i = 0; i < testCases.size(); i++) {
            TestCase testCase = testCases.get(i);
            System.out.printf("%d. %s\n", i + 1, testCase.getName());
        }
    }
}
