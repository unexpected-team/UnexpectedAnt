package com.unexpected.ant.skeleton_test;

import java.util.*;

public class TestRunner {
    private Map<String, TestCase> testCasesMap = new HashMap<>();
    private List<TestCase> testCases = new ArrayList<>();

    public void addTestCase(TestCase testCase) {
        testCasesMap.put(testCase.getName(), testCase);
        testCases.add(testCase);
    }

    public void run(String name) {
        if (testCasesMap.containsKey(name)) {
            testCasesMap.get(name).run();
        }
    }

    public List<TestCase> getTestCases() {
        return Collections.unmodifiableList(testCases);
    }

    public void run(int num) throws TestDoesNotExistException {
        if (testCases.size() <= num || num < 0) {
            throw new TestDoesNotExistException();
        }
        testCases.get(num).run();
    }

    public void runAll() {
        for (TestCase testCase : testCasesMap.values()) {
            testCase.run();
        }

    }
}
