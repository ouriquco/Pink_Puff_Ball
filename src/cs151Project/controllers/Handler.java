package cs151Project.controllers;

import cs151Project.models.*;
import cs151Project.views.World;
import cs151Project.PinkPuffball.Message;


import java.awt.Graphics;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;

public class Handler {
	
	public LinkedList<Entity> entity = new LinkedList<>();
	public LinkedList<Tile> tile = new LinkedList<>();
	
	public Handler() {

		createLevel();
	}
	
	public void render(Graphics g) {
		for(Tile ti:tile)
			ti.render(g);
		
		for(Entity en:entity)
			en.render(g);
	}
	public void update() {
		for(Entity en:entity)
			en.update();
		
		for(Tile ti:tile)
			ti.update();
		
	}
	
	
	public void addEntity(Entity en) {
		entity.add(en);
	}
	
	public void removeEntity(Entity en) {
		entity.remove(en);
	}
	
	public void addTile(Tile ti) {
		tile.add(ti);
	}
	
	public void removeTile(Tile ti) {
		tile.remove(ti);
	}
	
	public void createLevel() {
		for(int i = 0; i < 28; i++)
			addTile(new Platform(i*64, 532, 64, 64, true, Id.platform, this));
		addTile(new Platform(28*64 + 7, 467, 64, 64, true, Id.platform, this));
		for(int i = 0; i < 13; i++)
			addTile(new Platform((i + 29)*64, 467, 64, 64, true, Id.platform, this));
		addTile(new Platform(41*64 + 25, 398, 64, 64, true, Id.platform, this));
		for(int i = 0; i < 12; i++)
			addTile(new Platform((i + 42)*64, 400, 64, 64, true, Id.platform, this));
		addTile(new Platform(54*64 - 21, 400, 64, 64, true, Id.platform, this));
		addTile(new Platform(54*64 + 43, 534, 64, 64, true, Id.platform, this));
		for(int i = 0; i < 6; i++)
			addTile(new Platform((i + 55)*64, 534, 64, 64, true, Id.platform, this));
		addTile(new Platform(60*64 + 53, 534, 64, 64, true, Id.platform, this));
		addTile(new Platform(63*64 - 8, 468, 64, 64, true, Id.platform, this));
		for(int i = 0; i < 6; i++)
			addTile(new Platform((i + 63)*64, 468, 64, 64, true, Id.platform, this));
		addTile(new Platform(69*64, 468, 64, 64, true, Id.platform, this));
		addTile(new Platform(71*64 + 4, 532, 64, 64, true, Id.platform, this));
		for(int i = 0; i < 9; i++)
			addTile(new Platform((i + 72)*64, 532, 64, 64, true, Id.platform, this));
		
		this.addEntity(new WaddleDee(800, 440, 64, 64, 0, 1800, true, Id.waddleDee, this));
		
		this.addEntity(new WaddleDee(1200, 440, 64, 64, 0, 1800, true, Id.waddleDee, this));
		
		this.addEntity(new WaddleDee(1600, 440, 64, 64, 0, 1800, true, Id.waddleDee, this));
		
		this.addEntity(new WaddleDee(1900, 380, 64, 64, 1800, 2650, true, Id.waddleDee, this));
		
		this.addEntity(new WaddleDee(2400, 380, 64, 64, 1800, 2650, true, Id.waddleDee, this));
		
		this.addEntity(new WaddleDee(2700, 320, 64, 64, 2650, 3460, true, Id.waddleDee, this));
		
		this.addEntity(new WaddleDee(3300, 320, 64, 64, 2650, 3460, true, Id.waddleDee, this));
		
		this.addEntity(new WaddleDee(3800, 450, 64, 64, 3500, 3890, true, Id.waddleDee, this));
		
		this.addEntity(new WaddleDee(4300, 380, 64, 64, 4020, 4410, true, Id.waddleDee, this));

		//handler.addEntity(new WaddleDoo(1400, 440, 64, 64, 0, 1800, true, Id.waddleDoo, handler, handlerB));

		this.addEntity(new Player(300, 440, 64, 64, true, Id.player, this));
		
		this.addTile(new Background(0, 0, 5200, 700, false, Id.background, this));
	}
	
	public void clearLevel() {
		entity.clear();
		tile.clear();
	}
	
}