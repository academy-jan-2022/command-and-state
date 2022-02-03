package example;

import java.util.List;

public abstract class Player {
	private List<Command> commands;

	public void queue(Command command) {
		commands.add(command);
	}

	public Player execute() {
		var current = this;
		for (Command command: commands) {
			current = current.execute(command);
		}
		return current;
	}

	protected abstract Player execute(Command command);
}
