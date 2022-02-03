package example;

public class IdlePlayer extends Player {
	@Override
	protected Player execute(Command command) {
		if (command == Command.DANCE)
			return new DancingPlayer();
		return null;
	}
}
