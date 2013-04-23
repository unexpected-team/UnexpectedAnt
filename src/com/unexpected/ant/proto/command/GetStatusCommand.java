package com.unexpected.ant.proto.command;

import com.unexpected.ant.proto.AbstractCommand;
import com.unexpected.ant.proto.ParameterNotFoundException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Command for printing an object's attributes
 */
public class GetStatusCommand extends AbstractCommand {
	@Override
	public void execute() throws ParameterNotFoundException {
		Object obj = getParameter(0);
		List<Field> fields = new ArrayList<>();
		for (Class<?> clazz = obj.getClass(); !clazz.equals(Object.class); clazz = clazz.getSuperclass()) {
			Collections.addAll(fields, clazz.getDeclaredFields());
		}
		Collections.sort(fields, new Comparator<Field>() {
			@Override
			public int compare(Field o1, Field o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});

		for (Field field : fields) {
			try {
				field.setAccessible(true);
				Object value = field.get(obj);
				if (!(value instanceof Iterable<?>)) {
					getOutput().printf("%s: %s\n", field.getName(), value);
				}
			} catch (IllegalAccessException ignored) {
			}
		}

	}
}
