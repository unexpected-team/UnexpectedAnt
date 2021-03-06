package com.unexpected.ant.proto;

import java.io.PrintStream;

public interface Command {
	void execute() throws ParameterNotFoundException;

	Object getParameter(Object name) throws ParameterNotFoundException;

	String getStringParameter(Object name) throws ParameterNotFoundException;

	boolean hasParameter(Object name);

	GameContext getGameContext();

	String getName();

	void setParameter(Object name, Object value);

	void setGameContext(GameContext gameContext);

	PrintStream getOutput();

	void setOutput(PrintStream output);
}
