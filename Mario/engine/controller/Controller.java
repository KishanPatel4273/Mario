package controller;

import java.awt.event.KeyEvent;

import objects.Entity;
import objects.Player;
import render.Engine;
import tools.Collider;
import tools.Ray;
import tools.Vector;
import window.Display;

public class Controller {
	
	private int currentSpeed, walkSpeed, runSpeed, jumpSpeed, gravity;
	public boolean canJump;
	public Vector jump;
	
	public Controller() {
		walkSpeed = 10;
		runSpeed = 15;
		jumpSpeed = (256 + 16)*2;
		gravity = 12;
		jump = new Vector();
		currentSpeed = walkSpeed;
		canJump = false;
	}
	
	public void update(Player player, boolean[] key) {
		Vector forceX = new Vector();
		
		int down = (int) new Ray((int) player.getCenter().getX(), (int) player.getY() + player.getHeight(), new Vector(0,Display.HEIGHT)).cast();
		
		if(key[KeyEvent.VK_D]) {
			forceX.addX(currentSpeed);
		}
		if(key[KeyEvent.VK_A]) {
			forceX.addX(-currentSpeed);
		}
		if(key[KeyEvent.VK_S]) {
			//player.addY(currentSpeed);
		}
		if((key[KeyEvent.VK_W] || key[KeyEvent.VK_SPACE]) && down <= 2) {
			jump.addY(-jumpSpeed);
		}
		
		if(down > 2) {
			player.addY(gravity);
		}
		
		if(jump.getY() < 0) {
			player.addY(-2*gravity);
			jump.addY(2*gravity);
		} else {
			jump.setY(0);
		}

		Vector collisionFix = collisionDetection(player.getCollider());	
		player.addY((int) collisionFix.getY());
		forceX.addX(collisionFix.getX());
		
		for(Entity e: Engine.entities) {
			if(e.getTag() == 0) {
				e.addVector(Vector.scale(-1, forceX));				
			}
		}
	}
	
	public Vector collisionDetection(Collider c) {
		Vector force = new Vector();
		for(Entity e: Engine.entities) {
			if(e.isCollidable() && e.getTag() == 0) {
				Collider bottom = new Collider(c.getX(), c.getY() + c.getHeight(), c.getWidth(), e.getHeight()/2);				
				Collider top = new Collider(c.getX(), c.getY() - e.getHeight()/2, c.getWidth(), e.getHeight()/2);				
				Collider right = new Collider(c.getX() + c.getWidth(), c.getY(), e.getWidth()/2, c.getHeight());				
				Collider left = new Collider(c.getX() - e.getWidth()/2, c.getY(), e.getWidth()/2, c.getHeight());				

				float x = Math.abs(c.getWidth()/2 + e.getWidth()/2 - Math.abs((c.getX() + c.getWidth()/2) - (e.getX() + e.getWidth()/2) + 1) + 1);
				float y = Math.abs(c.getHeight()/2 + e.getHeight()/2 - Math.abs((c.getY() + c.getHeight()/2) - (e.getY() + e.getHeight()/2)  + 1) + 1);
				
				if(bottom.contains(e.getCenter())) {
					force.addY(-y);
					e.collide("i");
				}
				if(top.contains(e.getCenter())) {
					force.addY(y);
					e.collide("-i");
					jump.clear();
				}
				if(right.contains(e.getCenter())) {
					force.addX(-x);
					e.collide("-1");
				}
				if(left.contains(e.getCenter())) {
					force.addX(x);
					e.collide("1");
				}
			}
		}
		return force;
	}
	
}
