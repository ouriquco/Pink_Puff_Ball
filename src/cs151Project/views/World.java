package cs151Project.views;

import cs151Project.controllers.*;
import cs151Project.models.*;
import cs151Project.PinkPuffball.*;
import cs151Project.PinkPuffball.Message;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class World extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 300;
	public static final int HEIGHT = WIDTH/15*10;
	public static final int SCALE = 4;
	
	public static final String TITLE = "Kirby Game";
	
	private Thread thread;
	private boolean running = false;
	
	public static int lives = 2;
	public static int deathScreenTime = 0;
	
	public static boolean showDeathScreen = true;
	public static boolean gameOver = false;
	public static boolean win = false;
	
	public static Handler handler;
	
	public static Camera cam;

	public static KirbySpriteSheet kirbySheet;
	public static DeeSpriteSheet waddleDeeSheet;
	
	public static Sprite back;
	public static Sprite block;
	public static Sprite player;
	public static Sprite waddleDee;

	public static BufferedImage[] ks;
	public static BufferedImage[] wd;
	
	public static BufferedImage platform; 
	public static BufferedImage background;
	
	public World() {
		Dimension size = new Dimension(WIDTH*SCALE, HEIGHT*SCALE);
		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);		
	}
	
	
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this, "Thread");
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		}catch(InterruptedException ex) {
			
		}
		
	}
	
	public void init() {
		handler = new Handler();
		
		cam = new Camera();
		
		back = new Sprite(1);
		background = back.getBackgroundImage();
		
		block = new Sprite(2);
		platform = block.getPlatImage();
		
		kirbySheet = new KirbySpriteSheet();
		player = new Sprite(kirbySheet);
		ks = player.getKirbyImage();
		
		waddleDeeSheet = new DeeSpriteSheet();
		waddleDee = new Sprite(waddleDeeSheet);
		wd = waddleDee.getWaddleDeeImage();
				
		addKeyListener(new KeyInput());
		
	}
	
	public void run() {
		init();
		requestFocus();

		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double delta = 0.0;
		double ns = 1000000000.0/60.0;
		
		while(running) {
			long now = System.nanoTime();			
			delta +=(now -lastTime)/ns;
			lastTime=now;
			while(delta >=1) {
				update();
				delta--;
			}
			render();
			if(System.currentTimeMillis()-timer>1000) {
				timer+=1000;
			}
			
		}
		stop();
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs ==null) {
			createBufferStrategy(3);
		return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        
		if(showDeathScreen) {
			if(win) {
				g.setColor(Color.WHITE);
				g.setFont(new Font("Courier", Font.BOLD, 50));
				g.drawImage(World.ks[16], 570, 370, 160, 200, null);
				g.drawString("YOU WIN!", 520, 220);
			}
			else if(!gameOver) {
				g.setColor(Color.WHITE);
				g.setFont(new Font("Courier", Font.BOLD, 50));
				g.drawImage(World.ks[0], 550, 300, 100, 100, null);
				g.drawString("x" + lives, 660, 370);
			}
			else {
				g.setColor(Color.WHITE);
				g.setFont(new Font("Courier", Font.BOLD, 50));
				g.drawString("GAME OVER!", 490, 370);
			}
		}
		else {		
			g.translate(cam.getX(), cam.getY());
			handler.render(g);
		}

		g.dispose();
		bs.show();
		
	}
	
	public void update() {
		handler.update();
		
		for(Entity en: handler.entity) {
			if (en.getId() == Id.player)
				cam.update(en);
		}
		
		if(showDeathScreen && !gameOver && !win)
			deathScreenTime++;
		if(deathScreenTime >= 180) {
			showDeathScreen = false;
			deathScreenTime = 0;
			handler.clearLevel();
			handler.createLevel();
		}
	}
	
	public static int getFrameWidth() {
		return WIDTH * SCALE;
	}
}


