package com.unexpected.ant.proto;

public class CommandResolverImpl implements CommandResolver {

	protected CommandFactory commandFactory;

	public CommandResolverImpl(CommandFactory commandFactory) {
		this.commandFactory = commandFactory;
	}

	@Override
	public Command resolve(String line) throws CommandNotFoundException {
		String[] split = line.split(" ");
		Command command = commandFactory.createFromString(split[0]);
		int counter = 0;
		for (int i = 1; i < split.length; i++) {
			if (split[i].charAt(0) == '-') {
				if (split.length > i + 1 && split[i + 1].charAt(0) != '-') {
					command.setParameter(split[i].substring(1), split[i + 1]);
					i++;
				} else {
					command.setParameter(split[i].substring(1), true);
				}
			} else {
				command.setParameter(Integer.toString(counter), split[i]);
			}
		}
		return command;
	}
}
