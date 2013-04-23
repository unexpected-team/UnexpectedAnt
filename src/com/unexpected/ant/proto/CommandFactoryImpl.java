package com.unexpected.ant.proto;

import com.unexpected.ant.proto.command.*;

public class CommandFactoryImpl implements CommandFactory {
	private GameContext gameContext;

	public CommandFactoryImpl(GameContext gameContext) {
		this.gameContext = gameContext;
	}

	@Override
	public Command createFromString(String s) throws CommandNotFoundException {
		if (s.contains(".")) {
			RunMethodCommand command = new RunMethodCommand();
			command.setParameter("entityId", s.substring(0, s.indexOf(".")));
			command.setParameter("method", s.substring(s.indexOf(".") + 1));
			command.setGameContext(gameContext);
			return command;
		}
		Command[] commands = new Command[]{
				new DeodorantSprayUseCommand(),
				new ExitCommand(),
				new GetMethodsCommand(),
				new GetOutputCommand(),
				new GetStatusCommand(),
				new HelpCommand(),
				new KillerSprayUseCommand(),
				new LoadCommand(),
				new LoadMapCommand(),
				new IgnoreFeedbackCommand(),
				new PutCommand(),
				new RemoveCommand(),
				new RunMethodCommand(),
				new SaveCommand(),
				new StepCommand(),
				new StepEntityCommand()
		};
		for (Command command : commands) {
			if (command.getName().equals(s)) {
				command.setGameContext(gameContext);
				return command;
			}
		}
		throw new CommandNotFoundException();
	}

	public GameContext getGameContext() {
		return gameContext;
	}

	public void setGameContext(GameContext gameContext) {
		this.gameContext = gameContext;
	}
}
