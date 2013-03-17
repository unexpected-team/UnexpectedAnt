package com.unexpected.ant.skeleton_test;

public class OutputHelper {

    private static StackTraceElement root;

    public static void printCurrentMethod() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        StackTraceElement stackTraceElement = stackTrace[1];
        for (int i = 2; i < stackTrace.length; i++) {
            if (stackTrace[i].getMethodName().equals(root.getMethodName()) &&
                    stackTrace[i].getClassName().equals(root.getClassName())) {
                break;
            }
            System.out.print("\t");
        }
        String className = stackTraceElement.getClassName();
        className = className.substring(className.lastIndexOf(".") + 1);
        System.out.printf("%s.%s()\n", className, stackTraceElement.getMethodName());
    }

    public static void setRoot() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        StackTraceElement stackTraceElement = stackTrace[1];
        setRoot(stackTraceElement);
    }

    public static void setRoot(StackTraceElement stackTraceElement) {
        root = stackTraceElement;
    }
}
