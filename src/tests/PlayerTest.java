package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.player.Player;

public class PlayerTest {
	Player player = new Player();
	@Test
	public void validLocation(){
		assertTrue(player.getPlayerLocation() != null);
	}

	

}
