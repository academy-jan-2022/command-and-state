package example;

public class DefendingPlayer extends Player {
	@Override
	protected Player execute(Command command) {
		if (command == Command.STOP)
			return new IdlePlayer();
		return this;
	}
}
