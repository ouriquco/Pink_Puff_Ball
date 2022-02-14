package cs151Project.controllers;

import cs151Project.PinkPuffball.Message;
import cs151Project.PinkPuffball.moveLeftMessage;
import cs151Project.models.Entity;
import cs151Project.views.World;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class KeyInput implements KeyListener{
	
	private static BlockingQueue<Message> queue = new LinkedBlockingQueue<Message>();

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		for(Entity en: World.handler.entity) {
			if(en.getId() == Id.player) {
				if(e.getKeyCode() == KeyEvent.VK_D) {
					en.setVelX(5);
					en.facing = 0;
					queue.add(new moveLeftMessage(en.getX()));
				}
				if(e.getKeyCode() == KeyEvent.VK_A) {
					en.setVelX(-5);
					en.facing = 1;
					queue.add(new moveLeftMessage(en.getX()));
				}
				if(e.getKeyCode() == KeyEvent.VK_W) {
					if(!en.jumping ) {
						en.jumping = true;
						en.gravity = 5.0;
						queue.add(new moveLeftMessage(en.getY()));
					}
					en.setVelY(-5);
				}
			}
		}	
	}

	@Override
	public void keyReleased(KeyEvent e) {	
		for(Entity en: World.handler.entity) {
			if(en.getId() == Id.player) {
				if(e.getKeyCode() == KeyEvent.VK_D) {
					en.setVelX(0);
				}
				if(e.getKeyCode() == KeyEvent.VK_A) {
					en.setVelX(0);	
				}
				if(e.getKeyCode() == KeyEvent.VK_W) {
					en.setVelY(0);
				}
			}
		}
	}

}

