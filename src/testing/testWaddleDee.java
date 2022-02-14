package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cs151Project.controllers.Handler;
import cs151Project.controllers.Id;
import cs151Project.models.WaddleDee;

class testWaddleDee {

	@Test
	void testWdVelocity() {
		Handler handler = new Handler();
		handler.createLevel();
						
		WaddleDee wd = new WaddleDee(800, 440, 64, 64, 0, 1800, true, Id.waddleDee, handler);
		
		wd.update();
		
		assertTrue(wd.velX !=0);
	}
	
	@Test
	void testWdFacing() {
		Handler handler = new Handler();
		handler.createLevel();
						
		WaddleDee wd = new WaddleDee(800, 440, 64, 64, 0, 1800, true, Id.waddleDee, handler);
		
		wd.update();
		
		assertTrue(wd.facing ==0);
	}
	
	@Test
	void testWdFalling() {
		Handler handler = new Handler();
		handler.createLevel();
						
		WaddleDee wd = new WaddleDee(800, 440, 64, 64, 0, 1800, true, Id.waddleDee, handler);
		
		wd.update();
		
		assertTrue(wd.falling);
	}
	
	@Test
	void testWdGravity() {
		Handler handler = new Handler();
		handler.createLevel();
						
		WaddleDee wd = new WaddleDee(800, 440, 64, 64, 0, 1800, true, Id.waddleDee, handler);
		
		wd.update();
		
		assertTrue(wd.gravity !=0);
	}

}
