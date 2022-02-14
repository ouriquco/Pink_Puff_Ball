package cs151Project.models;

import cs151Project.controllers.Handler;
import cs151Project.controllers.Id;
import cs151Project.views.World;

import java.awt.Graphics;

public class WaddleDee extends Entity {

	private int walkBounds1;
	private int walkBounds2;

	public WaddleDee(int x, int y, int width, int height, int walkBounds1, int walkBounds2, boolean solid, Id id, Handler handler) {
		super(x, y, width, height, solid, id, handler);
		this.walkBounds1 = walkBounds1;
		this.walkBounds2 = walkBounds2;
		setVelX(-2);
	}

	@Override
	public void render(Graphics g) {
		if(facing == 0)
			g.drawImage(World.wd[frames], x, y, width, height, null);
		else if(facing == 1)
			g.drawImage(World.wd[frames + 2], x, y, width, height, null);
	}

	@Override
	public void update() {
		enemyWalk.start();
		x += velX;
		y += velY;

		for(Tile t:handler.tile) {
			if(!t.solid)break;
			if(t.getId() == Id.platform) {
				if(getBoundsBottom().intersects(t.getBounds())) {
					setVelY(0);
					if(falling) {
						falling = false;
					}
				}
				else if(!falling) {
					gravity = 0.0;
					falling = true;
				}
			}
				if(getBoundsLeft().intersects(t.getBounds()) || x == walkBounds1) {
					facing = 1;
					setVelX(2);
				}

				if(getBoundsRight().intersects(t.getBounds()) || x == walkBounds2) {
					facing = 0;
					setVelX(-2);
				}
		}

		if(falling) {
			gravity += 0.1;
			setVelY((int) gravity);
		}

	}



}