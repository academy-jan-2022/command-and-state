package example;

public class DefendingPlayer extends Player {
	private int turnsLeft = 2;

	@Override
	protected Player execute(Command command) {
		if (command == Command.STOP)
			return new IdlePlayer();
		turnsLeft--;
		if (turnsLeft == 0)
			return new IdlePlayer();

		return this;
	}
}
