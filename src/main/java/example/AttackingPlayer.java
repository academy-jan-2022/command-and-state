package example;

public class AttackingPlayer extends Player {
	private int turnsLeft = 1;

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
