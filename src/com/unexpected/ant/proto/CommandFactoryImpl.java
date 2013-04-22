package com.unexpected.ant.proto;

import com.unexpected.ant.proto.command.*;

public class CommandFactoryImpl implements CommandFactory {
	@Override
	public Command createFromString(String s) throws CommandNotFoundException {
		if (s.contains(".")) {
			RunMethodCommand command = new RunMethodCommand();
			command.setParameter("entityId", s.substring(0, s.indexOf(".")));
			command.setParameter("method", s.substring(s.indexOf(".")));
			return command;
		}
		Command[] commands = new Command[]{
				new ExitCommand(),
				new GetOutputCommand(),
				new HelpCommand(),
				new LoadCommand(),
				new RunMethodCommand(),
				new SaveCommand(),
				new StepCommand(),
				new StepEntityCommand()
		};
		for (Command command : commands) {
			if (command.getName().equals(s)) {
				return command;
			}
		}
		throw new CommandNotFoundException();
	}
}
