package example;

import static example.Command.*;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import org.junit.jupiter.api.Test;

public class PlayerShould {
	@Test void
	become_idle_on_stop_when_dancing() {
		Player player = new DancingPlayer();
		player.queue(STOP);
		var result = player.execute();
		assertInstanceOf(IdlePlayer.class, result);
	}

	@Test void
	keep_dancing_when_told_to_attack() {
		Player player = new DancingPlayer();
		player.queue(ATTACK);
		var result = player.execute();
		assertInstanceOf(DancingPlayer.class, result);
	}
}
