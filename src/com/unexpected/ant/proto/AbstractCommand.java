package com.unexpected.ant.proto;

import com.unexpected.ant.model.Direction;
import com.unexpected.ant.model.RelativeDirection;
import com.unexpected.ant.model.entity.ObstacleType;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCommand implements Command {
	protected Map<Object, Object> parameters = new HashMap<>();

	private GameContext gameContext;

	private PrintStream output = System.out;

	@Override
	public GameContext getGameContext() {
		return gameContext;
	}

	@Override
	public void setGameContext(GameContext gameContext) {
		this.gameContext = gameContext;
	}

	@Override
	public String getName() {
		String className = getClass().getSimpleName(); // eg. LoadMapCommand
		String command = className.replace("Command", ""); //LoadMap
		command = Character.toLowerCase(command.charAt(0)) + command.substring(1); //loadMap
		return command;
	}

	@Override
	public PrintStream getOutput() {
		return output;
	}

	@Override
	public void setOutput(PrintStream output) {
		this.output = output;
	}

	public Object getParameter(Object name, boolean required) throws ParameterNotFoundException {
		if (required && !hasParameter(name)) {
			throw new ParameterNotFoundException(name);
		}
		return parameters.get(name);
	}

	public boolean hasParameter(Object name) {
		return parameters.containsKey(name);
	}

	@Override
	public String getStringParameter(Object name) throws ParameterNotFoundException {
		return (String) getParameter(name);
	}

	public Object getParameter(Object name) throws ParameterNotFoundException {
		return getParameter(name, true);
	}

	@Override
	public void setParameter(Object name, Object value) {
		parameters.put(name, value);
	}

	/**
	 * Casts a parameter to either a stored object, an integer or a string
	 * First tries to parse as a stored object, then as a long, finally as a string
	 *
	 * @param parameter the parameter to be parsed
	 * @return the parsed parameter
	 */
	public Object parse(String parameter) {
//	    try to parse it as an enum
		try {
			return Direction.valueOf(parameter);
		} catch (IllegalArgumentException ignored) {
		}

		try {
			return RelativeDirection.valueOf(parameter);
		} catch (IllegalArgumentException ignored) {
		}

		try {
			return ObstacleType.valueOf(parameter);
		} catch (IllegalArgumentException ignored) {
		}

//      Try to parse it as a new instance
		try {
			Object newInstance = Class.forName("com.unexpected.ant.model.entity." + parameter).newInstance();
			getGameContext().addObject(newInstance);
			return newInstance;
		} catch (Exception ignored) {
		}

//		try to parse it as an entity
		Object entityById = getGameContext().getObjectById(parameter);
		if (entityById != null) {
			return entityById;
		}

//		try to parse it as an integer
		try {
			return Integer.parseInt(parameter);
		} catch (NumberFormatException ignored) {
		}

//		fallback as a string
		return parameter;
	}

	/**
	 * Type forcing to T
	 * If type is not T print an error, else return with the parsed parameter
	 *
	 * @return the parsed object is null when error
	 */
	public <T> T parse(String paramter, Class<T> castType) {
		Object ob = parse(paramter);
		if (!(castType.isAssignableFrom(ob.getClass()))) {
			getOutput().println("Hiba, nem létező típus.");
			return null;
		} else {
			return (T) ob;
		}
	}

	protected Object getParameter(Object name, Object defaultVal) {
		try {
			return hasParameter(name) ? getParameter(name) : defaultVal;
		} catch (ParameterNotFoundException e) {
			throw new IllegalStateException();
		}
	}
}
