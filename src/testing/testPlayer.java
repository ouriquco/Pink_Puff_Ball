package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cs151Project.controllers.Handler;
import cs151Project.controllers.Id;
import cs151Project.models.Player;
import cs151Project.models.Tile;

class testPlayer {

	@Test
	//test the position of Kirby
	void testPlayerMethod() {
		
		Handler handler = new Handler();
		handler.createLevel();
		
		Player player = new Player(300, 440, 64, 64, true, Id.player, handler);
		
		player.update();
		assertTrue(player.x >0);
		
		
	}
	
	@Test
	//test the status of kirby
	void testKirby() {
		
		Handler handler = new Handler();
		handler.createLevel();
		
		Player player = new Player(300, 440, 64, 64, true, Id.player, handler);
		
		player.update();
		assertTrue(player.standing);
		
		
	}
	
	@Test
	//test the velocity of kirby, since he is standing, should be 0
	void testKirbyVel() {
		
		Handler handler = new Handler();
		handler.createLevel();
		
		Player player = new Player(300, 440, 64, 64, true, Id.player, handler);
		
		player.update();
		assertTrue(player.velX ==0);
		
		
	}
	

}
