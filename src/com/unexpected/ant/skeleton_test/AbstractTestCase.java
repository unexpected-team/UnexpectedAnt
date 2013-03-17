package com.unexpected.ant.skeleton_test;

public abstract class AbstractTestCase implements TestCase {
    private String name;


    public AbstractTestCase() {
        this.name = getClass().getSimpleName();
    }

    public AbstractTestCase(String name) {
        this.name = name;
    }

    protected abstract void doRun();

    @Override
    public void run() {
        OutputHelper.setRoot();
        doRun();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
