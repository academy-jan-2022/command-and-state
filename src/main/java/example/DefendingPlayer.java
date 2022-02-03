package example;

public class DefendingPlayer extends Player {
	private int turnsLeft = 2;

	@Override
	protected Player execute(Command command) {
		turnsLeft--;
		if (command == Command.STOP || turnsLeft == 0)
			return new IdlePlayer();

		return this;
	}
}
