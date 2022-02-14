package cs151Project.models;

import cs151Project.views.World;

public class Camera {
	public int x, y;
	
	public void update(Entity player) {
		if(player.getX() <= 600)
			setX(-600 + World.getFrameWidth()/2);
		else
			setX(-player.getX() + World.getFrameWidth()/2);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
