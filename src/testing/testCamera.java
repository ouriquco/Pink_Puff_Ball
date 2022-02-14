package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cs151Project.controllers.Handler;
import cs151Project.controllers.Id;
import cs151Project.models.Camera;
import cs151Project.models.Player;

class testCamera {

	@Test
	//test the position of the camera
	void test() {
		Handler handler = new Handler();
		handler.createLevel();
		
		Player player = new Player(300, 440, 64, 64, true, Id.player, handler);
		
		Camera cam = new Camera();
		cam.update(player);
		
		assertTrue(cam.getX() ==0);
	}

}
