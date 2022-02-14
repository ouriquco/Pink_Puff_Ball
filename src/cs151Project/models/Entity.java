package cs151Project.models;

import cs151Project.controllers.Handler;
import cs151Project.controllers.Id;
import cs151Project.views.World;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.Timer;

public abstract class Entity {
	
	public int x, y;
	public int width, height;
	public int facing = 0;

	
	public boolean solid;
	public boolean jumping= false;
	public boolean falling = true;
	
	public int velX, velY;
	
	public Id id;
	
	public double gravity = 0.0;
	
	public Handler handler;
	
	public int frames = 0;
	
	public Timer standTime = new Timer(200, e -> {
		frames++;
		if(frames >= 2)
			frames = 0;
	});
	
	public Timer walkTime = new Timer(150, e -> {
		if(frames >= 4) 
			frames = 0;
		frames++;
	});

	public Timer enemyWalk = new Timer(300, e -> {
		frames++;
		if(frames >= 2)
			frames = 0;
	});
	
	public Entity(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
		this.x = x;
		this.y =y; 
		this.height = height;
		this.width = width;
		this.solid = solid;
		this.id = id;
		this.handler = handler;
	}
	
	public abstract void render(Graphics g);
	public abstract void update();

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}
	public void setVelY(int velY) {
		this.velY = velY;
	}
	
	public Id getId() {
		return id;
	}
	
	public void die() {
		handler.removeEntity(this);
		World.lives--;
		World.showDeathScreen = true;
		
		if(World.lives <= 0)
			World.gameOver = true;
		if(World.win == true)
			World.lives = 0;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(getX(), getY(), width, height);
	}
	
	public Rectangle getBoundsTop() {
		return new Rectangle(getX()+10, getY(), width-20, 5);
	}
	
	public Rectangle getBoundsBottom() {
		return new Rectangle(getX()+10, getY()+height-5, width-20, 5);
	}
	
	public Rectangle getBoundsLeft() {
		return new Rectangle(getX(), getY()+10, 5, height-20);
	}
	
	public Rectangle getBoundsRight() {
		return new Rectangle(getX()+width-5, getY()+10, 5, height-20);
	}
	
}
