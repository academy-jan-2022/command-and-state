package example;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
	private final List<Command> commands = new ArrayList<>();

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
