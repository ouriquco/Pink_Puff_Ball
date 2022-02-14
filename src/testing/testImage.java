package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.Test;

import cs151Project.models.KirbySpriteSheet;
import cs151Project.models.Sprite;

class testImage {

	@Test
	//test background image
	void testBackgroundImage() throws IOException {
		
		Sprite backgroundSprite = new Sprite(1);
		BufferedImage BackgroundImage = backgroundSprite.getBackgroundImage();
		
		//BufferedImage background;
		File backgroundFile = new File("resources/LevelBackground.GIF");
		
		BufferedImage background = ImageIO.read(backgroundFile);

		assertSame(BackgroundImage, background);
		
		
	}
	
	@Test
	//test kirby image
	void testKirbyImage() throws IOException {
		KirbySpriteSheet kirbySheet = null;
		Sprite kirbySprite = new Sprite(kirbySheet);
				
		assertNotNull(kirbySprite.getKirbyImage());
	}
	
	

}
