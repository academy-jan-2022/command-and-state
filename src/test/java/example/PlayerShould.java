package example;

import static example.Command.*;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerShould {
	@Test void
	become_idle_on_stop_when_dancing() {
		Player player = new DancingPlayer();
		player.queue(STOP);
		var result = player.execute();
		assertInstanceOf(IdlePlayer.class, result);
	}

	@Test void
	start_dancing_when_idle() {
		Player player = new IdlePlayer();
		player.queue(DANCE);
		var result = player.execute();
		assertInstanceOf(DancingPlayer.class, result);
	}

	@Test void
	stay_idle_when_asked_to_stop() {
		Player player = new IdlePlayer();
		player.queue(STOP);
		var result = player.execute();
		assertInstanceOf(IdlePlayer.class, result);
	}

	@Test void
	start_attacking_when_idle() {
		Player player = new IdlePlayer();
		player.queue(ATTACK);
		var result = player.execute();
		assertInstanceOf(AttackingPlayer.class, result);
	}

	@Test void
	stop_attacking_when_asked_to_stop() {
		Player player = new AttackingPlayer();
		player.queue(STOP);
		var result = player.execute();
		assertInstanceOf(IdlePlayer.class, result);
	}

	@ParameterizedTest
	@CsvSource({"ATTACK", "DANCE", "DEFEND"}) void
	keep_attacking_on_other_commands(Command command) {
		Player player = new AttackingPlayer();
		player.queue(command);
		var result = player.execute();
		assertInstanceOf(AttackingPlayer.class, result);
	}

	@ParameterizedTest
	@CsvSource({"ATTACK", "DANCE", "DEFEND"}) void
	keep_dancing_when_told_to_do_other_actions(Command command) {
		Player player = new DancingPlayer();
		player.queue(command);
		var result = player.execute();
		assertInstanceOf(DancingPlayer.class, result);
	}

	@Test void
	stop_defending_when_asked_to_stop() {
		Player player = new DefendingPlayer();
		player.queue(STOP);
		var result = player.execute();
		assertInstanceOf(IdlePlayer.class, result);
	}

	@ParameterizedTest
	@CsvSource({"ATTACK", "DANCE", "DEFEND"}) void
	keep_defending_when_told_to_do_other_actions(Command command) {
		Player player = new DefendingPlayer();
		player.queue(command);
		var result = player.execute();
		assertInstanceOf(DefendingPlayer.class, result);
	}
}
