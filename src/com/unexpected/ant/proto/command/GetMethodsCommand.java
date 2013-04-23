package com.unexpected.ant.proto.command;

import com.unexpected.ant.proto.AbstractCommand;
import com.unexpected.ant.proto.ParameterNotFoundException;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Command for printing the available methods of an object
 */
public class GetMethodsCommand extends AbstractCommand {
	@Override
	public void execute() throws ParameterNotFoundException {
//      If the object does not exist
		if (getGameContext().getObjectById(getStringParameter(0)) == null) {
			getOutput().println("Nem létező objektum.");
            return;
		}
//      Sort it in abc order
		List<Method> methods = Arrays.asList(parse(getStringParameter(0)).getClass().getMethods());
		Collections.sort(methods, new Comparator<Method>() {
			@Override
			public int compare(Method o1, Method o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
//		Iterate and print out the methods
        for (Method method : methods) {
			getOutput().printf("%s%s(", getVisibilityCharacter(method), method.getName());
//          If it is the first parameter, don't need to print a coma, else it do
			boolean first = true;
			for (Class<?> type : method.getParameterTypes()) {
				getOutput().printf("%s%s", first ? "" : ", ", type.getSimpleName());
				first = false;
			}
			getOutput().printf("): %s\n", method.getReturnType().getSimpleName());

		}

	}

//  Get the visibility of the method
	private char getVisibilityCharacter(Method method) {
//		private
		if (Modifier.isPrivate(method.getModifiers()))
			return '-';
//		protected
		if (Modifier.isProtected(method.getModifiers()))
			return '#';
//		public
		if (Modifier.isPublic(method.getModifiers()))
			return '+';
//		package
		return '~';
	}
}
