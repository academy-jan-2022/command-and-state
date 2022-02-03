package example;

public class DancingPlayer extends Player {
	@Override
	protected Player execute(Command command) {
		if (command == Command.STOP)
			return new IdlePlayer();
		return null;
	}
}
