package com.unexpected.ant;

import com.unexpected.ant.skeleton_test.TestCase;
import com.unexpected.ant.skeleton_test.TestDoesNotExistException;
import com.unexpected.ant.skeleton_test.TestRunner;
import com.unexpected.ant.skeleton_test.test.BuildGameField;

import java.util.List;
import java.util.Scanner;

public class Main {
    TestRunner testRunner = new TestRunner();

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        testRunner.addTestCase(new BuildGameField());
        displayTestCases();
        Scanner scanner = new Scanner(System.in);

        try {
            testRunner.run(scanner.nextInt() - 1);
        } catch (TestDoesNotExistException e) {
            System.out.println("Ilyen teszt nem létezik");
        }
    }

    public void displayTestCases() {
        List<TestCase> testCases = testRunner.getTestCases();
        for (int i = 0; i < testCases.size(); i++) {
            TestCase testCase = testCases.get(i);
            System.out.printf("%d. %s\n", i + 1, testCase.getName());
        }
    }
}
