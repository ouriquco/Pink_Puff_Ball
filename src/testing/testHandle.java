package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cs151Project.controllers.Handler;

class testHandle {

	@Test
	void testEntity() {
		Handler handler = new Handler();
		handler.createLevel();
		
		assertNotNull(handler.entity);
		
	}
	
	
	@Test
	void testTile() {
		Handler handler = new Handler();
		handler.createLevel();
		
		assertNotNull(handler.tile);
		
	}
	

}
