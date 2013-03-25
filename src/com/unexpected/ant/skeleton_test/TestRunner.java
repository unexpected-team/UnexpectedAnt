package com.unexpected.ant.skeleton_test;

import java.util.*;

/**
 * Class for running tests
 */
public class TestRunner {
    private List<TestCase> testCases = new ArrayList<>();
    private Map<String, TestCase> testCasesMap = new HashMap<>();

    public void addTestCase(TestCase testCase) {
        testCasesMap.put(testCase.getName(), testCase);
        testCases.add(testCase);
    }

    /**
     * Returns all test cases as a non-modifiable list
     *
     * @return test cases
     */
    public List<TestCase> getTestCases() {
        return Collections.unmodifiableList(testCases);
    }

    /**
     * Run a test with the given name
     *
     * @param name
     * @throws TestDoesNotExistException if the test does not exist
     */
    public void run(String name) throws TestDoesNotExistException {
        if (testCasesMap.containsKey(name)) {
            testCasesMap.get(name).run();
        }
        throw new TestDoesNotExistException();
    }

    /**
     * Runs the test with the given number
     *
     * @param num number of test
     * @throws TestDoesNotExistException if the test does not exist
     */
    public void run(int num) throws TestDoesNotExistException {
        if (testCases.size() <= num || num < 0) {
            throw new TestDoesNotExistException();
        }
        System.out.println("--------------------------------------------------");
        testCases.get(num).run();
        System.out.println("--------------------------------------------------");
    }

    /**
     * Runs all tests
     */
    public void runAll() {
        for (TestCase testCase : testCasesMap.values()) {
            testCase.run();
        }
    }
}
