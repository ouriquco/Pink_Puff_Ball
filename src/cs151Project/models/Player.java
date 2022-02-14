package cs151Project.models;

import cs151Project.controllers.*;
import cs151Project.PinkPuffball.*;
import cs151Project.views.*;
import java.awt.Graphics;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Player extends Entity {
	
	public boolean standing = true;
	private boolean walking = false;
	
	//make a message Q to store action
	//BlockingQueue<Message> queue;
	

	

	public Player(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
		super(x, y, width, height, solid, id, handler);
		setVelX(0);


	}

	@Override
	public void render(Graphics g) {
		if(facing == 0) {
			if(velY > 0)
				g.drawImage(World.ks[13], x, y, width, height, null);
			else if(velY < 0)
				g.drawImage(World.ks[12], x, y, width, height, null);
			else if(standing)
				g.drawImage(World.ks[frames], x, y, width, height, null);
			else if(walking)
				g.drawImage(World.ks[frames + 3], x, y, width, height, null);
			
		}
			
		else if(facing == 1) {
			if(velY > 0)
				g.drawImage(World.ks[15], x, y, width, height, null);
			else if(velY < 0)
				g.drawImage(World.ks[14], x, y, width, height, null);
			else if(standing)
				g.drawImage(World.ks[frames + 2], x, y, width, height, null);
			else if(walking)
				g.drawImage(World.ks[frames + 7], x, y, width, height, null);
		}

	}

	@Override
	public void update() {
		x += velX;
		y += velY;
		if(x <= 0)
			x = 0;
		
		if(x + width >= 5200)
			x = 5200 - width;
		if(y + height > 800)
			y = 800 - height;
		
		if(x >= 4900) {
			World.win = true;
			die();
		}
		if(y >= 720)
			die();
		
		if(velX != 0 && velY == 0) {
			standing = false;
			walking = true;
			standTime.stop();
		}
		if(velX == 0 && velY == 0) {
			standing = true;
			walking = false;
			walkTime.stop();
		}
		
		for(Tile t:handler.tile) {
			if(!t.solid)break;
			if(t.getId() == Id.platform) {
				if(getBoundsTop().intersects(t.getBounds())) {
					setVelY(0);
					if(jumping) {
						jumping = false;
						gravity = 0.0;
						falling = true;
					}
				}
				if(getBoundsBottom().intersects(t.getBounds())) {
					setVelY(0);
					if(falling) {
						falling = false;
					}
				}
				else if(!falling && !jumping) {
					gravity = 0.0;
					falling = true;
				}
			}
				if(getBoundsLeft().intersects(t.getBounds())) {
					setVelX(0);
					x = t.getX() + t.width;
				}
				
				if(getBoundsRight().intersects(t.getBounds())) {
					setVelX(0);
					x = t.getX() - t.width;
				}
		}
		
		
		for(int i = 0; i < handler.entity.size(); i++) {
			Entity e = handler.entity.get(i);
			
			if(e.getId() == Id.waddleDee) {
				if(getBounds().intersects(e.getBounds())) {
					die();
				}
			}
			
			if(e.getId() == Id.waddleDoo) {
				if(getBounds().intersects(e.getBounds())) {
					die();
				}
			}
		}
		
		if(jumping) {
			gravity -= 0.1;
			setVelY((int) -gravity);
			if(gravity <= 0.0) {
				jumping = false;
				falling = true;
			}
		}
		
		if(falling) {
			gravity += 0.1;
			setVelY((int) gravity);
		}
				
		if(standing) {
			standTime.start();
		}
		
		if(walking) {
			walkTime.start();
		}
		
	}
	
}

