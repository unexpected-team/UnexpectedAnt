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

		Method method = null;
		methodSearch:
		for (Method m : entityClass.getMethods()) {
			if (m.getName().equals(getStringParameter("method")) && parameters.size() == m.getParameterTypes().length) {
				for (int i = 0; i < m.getParameterTypes().length; i++) {
					// if there is a parameter which is not assignable, continue search with another method
					try {
						if (!(m.getParameterTypes()[i].isAssignableFrom(parameters.get(i).getClass()) ||
								m.getParameterTypes()[i].isPrimitive() &&
										parameters.get(i).getClass().getDeclaredField("TYPE").get(parameters.get(i)).equals(m.getParameterTypes()[i]))) {
							continue methodSearch;
						}
					} catch (IllegalAccessException | NoSuchFieldException ignored) {
					}
				}
				// we found the proper method
				method = m;
				break;
			}
		}
		if (method == null) {
			getOutput().println("A keresett metódus nem létezik (lehet, hogy hibás paramétereket vagy metódusnevet adtál meg).");
			return;
		}

		try {
//			invoke the method and store the return value
			Object returnValue = method.invoke(entity, parameters.toArray());
//			uncomment this if you want to output the return value
			if (!getGameContext().isIgnoreFeedback()) {
				getOutput().printf("Sikeres futtatás! Visszatérési érték: %s\n", String.valueOf(returnValue));
			}
			getGameContext().addObject(returnValue);
		} catch (IllegalAccessException | InvocationTargetException e) {
			getOutput().println("Hiba történt a metódus meghívásakor.");
		}
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
