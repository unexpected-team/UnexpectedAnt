package com.unexpected.ant.skeleton_test;

import java.util.HashMap;
import java.util.Map;

/**
 * Util class for method output in the skeleton test
 */
public abstract class OutputHelper {

    private static StackTraceElement root;

    private static Map<Object, String> outputObjectNames = new HashMap<>();

    /**
     * Print current method info, displays the caller object and the current method name
     *
     * @param caller
     */
    public static void printCurrentMethod(Object caller) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        StackTraceElement stackTraceElement = stackTrace[1];
        for (int i = 2; i < stackTrace.length; i++) {
            if (stackTrace[i].getMethodName().equals(root.getMethodName()) &&
                    stackTrace[i].getClassName().equals(root.getClassName())) {
                break;
            }
            System.out.print("\t");
        }

        System.out.printf("%s.%s()\n", getOutputNameFor(caller), stackTraceElement.getMethodName());
    }

    /**
     * Returns the output name for the object
     * Example:
     * <ul>
     * <li>First Ant object gets the name ant1</li>
     * <li>Second Ant object gets the name ant2</li>
     * </ul>
     * The method returns the same name for the same object, until reset is invoked
     *
     * @param object The object
     * @return The name for the object
     */
    private static String getOutputNameFor(Object object) {

        // if we already have a name, return that
        if (outputObjectNames.containsKey(object)) {
            return outputObjectNames.get(object);
        }
        // count the objects with same type
        int c = 1;
        for (Object o : outputObjectNames.keySet()) {
            if (o.getClass().equals(object.getClass())) {
                c++;
            }
        }
        // find out display name according to class name
        // com.unexpected.ant.model.entity.Ant --> ant
        String className = object.getClass().getName();
        className = className.substring(className.lastIndexOf(".") + 1);
        className = Character.toLowerCase(className.charAt(0)) + className.substring(1);
        // apply serial number to the object
        String name = className + c;
        //store it, so we find it next time
        outputObjectNames.put(object, name);
        return name;
    }

    /**
     * Resets the output, object names and indentation reset
     */
    public static void reset() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        StackTraceElement stackTraceElement = stackTrace[1];
        outputObjectNames.clear();
        setRoot(stackTraceElement);
    }

    /**
     * Sets indentation root to the given stackTraceElement
     *
     * @param stackTraceElement
     */
    public static void setRoot(StackTraceElement stackTraceElement) {
        root = stackTraceElement;
    }
}
