package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cs151Project.views.World;


class testWorld {

	@Test
	void testInit() {
		//if init function works, kirby will have his image on the view
		World testWorld = new World();
		
		testWorld.init();
		
		assertNotNull(testWorld.ks);
		
		
	}
	
	@Test
	//if function works, handler should not be null
	void testRender() {
		//test world render function 
		World testWorld = new World();
		
		testWorld.render();
		
		assertNotNull(testWorld.handler);
		
		
	}
	
	@Test
	//if function works, deathScreenTime should not be null
	void testUpdate() {
		//test world render function 
		World testWorld = new World();
					
		assertNotNull(testWorld.deathScreenTime);
		
		
	}

}
