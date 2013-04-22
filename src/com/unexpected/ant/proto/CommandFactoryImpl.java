package com.unexpected.ant.proto;

public class CommandFactoryImpl implements CommandFactory {
	@Override
	public Command createFromString(String s) throws CommandNotFoundException {
		Command[] commands = new Command[]{

		};
		for (Command command : commands) {
			if (command.getName().equals(s)) {
				return command;
			}
		}
		throw new CommandNotFoundException();
	}
}
