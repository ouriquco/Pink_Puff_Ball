package cs151Project.models;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class KirbySpriteSheet {
	
	private BufferedImage[] kirbySheet;
	
	public File[] kirby = {new File("resources/KirbyStand1.PNG"), new File("resources/KirbyStand2.PNG"),
					new File("resources/KirbyStand3.PNG"), new File("resources/KirbyStand4.PNG"),
					new File("resources/KirbyWalk1.PNG"), new File("resources/KirbyWalk2.PNG"),
					new File("resources/KirbyWalk3.PNG"), new File("resources/KirbyWalk4.PNG"),
					new File("resources/KirbyWalk5.PNG"), new File("resources/KirbyWalk6.PNG"),
					new File("resources/KirbyWalk7.PNG"), new File("resources/KirbyWalk8.PNG"),
					new File("resources/KirbyJump1.PNG"), new File("resources/KirbyJump5.PNG"),
					new File("resources/KirbyJump6.PNG"), new File("resources/KirbyJump10.PNG"),
					new File("resources/KirbyWin.PNG")};
	
	public KirbySpriteSheet() {
			kirbySheet = new BufferedImage[17];
		
		try {
			for(int i = 0; i < kirby.length; i++) {
				kirbySheet[i] = ImageIO.read(kirby[i]);
			}
		}
		catch(IOException e){
		
		}	

}
	public BufferedImage[] getKirbySprite() {
		return kirbySheet;
	}
	

}


