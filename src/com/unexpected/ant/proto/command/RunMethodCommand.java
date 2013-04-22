package com.unexpected.ant.proto.command;

import com.unexpected.ant.proto.AbstractCommand;
import com.unexpected.ant.proto.ParameterNotFoundException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Command class for running objects' methods.
 */
public class RunMethodCommand extends AbstractCommand {
	@Override
	public void execute() throws ParameterNotFoundException {
//		entity from the given entity id
		Object entity = getGameContext().getObjectById(getStringParameter("entityId"));
		Class<?> entityClass = entity.getClass();

		List<Object> parameters = getMethodParameters();

		try {
			Method method = entityClass.getMethod(getStringParameter("method"), getParameterClasses());
//					invoke the method and store the return value
			Object returnValue = method.invoke(entity, parameters.toArray());
//			uncomment this if you want to output the return value
//			getOutput().printf("Sikeres futtatás! Visszatérési érték: %s\n", String.valueOf(returnValue));
		} catch (NoSuchMethodException e) {
			getOutput().println("A keresett metódus nem létezik (lehet, hogy hibás paramétereket vagy metódusnevet adtál meg.");
		} catch (InvocationTargetException | IllegalAccessException e) {
			getOutput().println("Hiba történt a metódus meghívásakor.");
		}


	}

	private Class[] getParameterClasses() {
		List<Class> parameterClasses = new ArrayList<>();
		for (Object parameter : getMethodParameters()) {
			parameterClasses.add(parameter.getClass());
		}
		return parameterClasses.toArray(new Class[parameterClasses.size()]);
	}

	/**
	 * Returns the method parameters for execution
	 *
	 * @return the method parameters
	 */
	public List<Object> getMethodParameters() {
		int i = 0;
		List<Object> parameters = new ArrayList<>();
		while (hasParameter(i)) {
			try {
				parameters.add(parse(getStringParameter(i)));
			} catch (ParameterNotFoundException ignored) {
			}
			i++;
		}
		return parameters;
	}

}
