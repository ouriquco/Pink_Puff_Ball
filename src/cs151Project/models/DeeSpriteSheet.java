package cs151Project.models;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DeeSpriteSheet {
			
	private BufferedImage[] waddleDeeSheet;
		
	public File[] waddleDee = {new File("resources/WaddleDee1.PNG"), new File("resources/WaddleDee2.PNG"),
						new File("resources/WaddleDee3.PNG"), new File("resources/WaddleDee4.PNG")};
		
	public DeeSpriteSheet() {	
		waddleDeeSheet = new BufferedImage[4];
		try {
				for(int i=0; i<waddleDeeSheet.length; i++) {
					waddleDeeSheet[i] = ImageIO.read(waddleDee[i]);					
				}
			}
		catch(IOException e){
		
		}
	}
		
	public BufferedImage[] getWaddleDeeSprite() {			
			return waddleDeeSheet;
	}
}