package example;

public class DancingPlayer extends Player {
	private int remainingTurns = 3;
	@Override
	protected Player execute(Command command) {
		remainingTurns--;
		if (command == Command.STOP || remainingTurns == 0)
			return new IdlePlayer();
		return this;
	}
}
