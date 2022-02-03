package example;

public class AttackingPlayer extends Player {
	@Override
	protected Player execute(Command command) {
		if (command == Command.STOP)
			return new IdlePlayer();
		return this;
	}
}
