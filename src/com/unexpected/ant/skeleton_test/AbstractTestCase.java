package com.unexpected.ant.skeleton_test;

/**
 * This is the abstract base class for all skeleton tests. You should implement the doRun method.
 */
public abstract class AbstractTestCase implements TestCase {
    private String name;

    /**
     * Default constructor which defaults the test name to the class name
     */
    public AbstractTestCase() {
        this.name = getClass().getSimpleName();
    }

    /**
     * Constructor with name parameter
     *
     * @param name Name of the test case
     */
    public AbstractTestCase(String name) {
        this.name = name;
    }

    /**
     * Abstract method to be overriden by actual test cases
     */
    protected abstract void doRun();

    /**
     * Runs the test case
     */
    @Override
    public void run() {
        OutputHelper.reset();
        doRun();
    }

    /**
     * @return The name of the test case
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the test case
     *
     * @param name Name of the test case
     */
    public void setName(String name) {
        this.name = name;
    }
}
