package Physics;

import objects.Entity;
import render.Engine;
import tools.*;
import window.Display;
public class PhysicsEngine {
	
	public static Frame frame;
	public static float gravity = 10;
	
	public PhysicsEngine(Frame frame) {
		this.frame = frame;
	}
	
	//see if making the method static is better
	
	//if not static add to engine(class:Engine)(package:render) check if physics applies then call method with said entity
	//if static add to update method in said Entity type (example:brick, Goomba, etc) with this as parameter
		//and make interface(for physics)(add to objects if needed) that will have gravity Vector(to have a time component)
			//make parameter be able to access the interface implements
	
	//call on method if Entity is in frame and physics apply to it.(such as AI, later fire balls, etc)
	public static void checkPhysics(Entity e) {		
			//get distance from e and said entity(use ray casting or use colliders)
			int down = (int) new Ray((int) e.getCenter().getX(), (int) e.getY() + e.getHeight(), new Vector(0,Display.HEIGHT)).cast();
			//	apply gravity if applicable
				//if applicable apply gravity if distance(Cast ray down) is > 2
			if(down > 2) {
				e.addY((int)gravity);
			}
			//if:(distance==2 they touch, less collide, more nothing	
				//if d == 2 then tell e the side its being touched at. Note:might not need to do this, the might do the same function
				//if d < 2 they collide undo it and tell e(entity your checking) the direction of collision	
			Vector collisionFix = collisionDetection(e.getCollider());
			collisionFixCollisionUpadate(collisionFix, e);
			e.addVector(collisionFix);
	}
	
	public static void collisionFixCollisionUpadate(Vector collisionFix, Entity e) {
		//invert force to get side of surface. use complex plane for direction
		if(collisionFix.getX() > 0) {//1
			e.collide("-1");
		} else if(collisionFix.getX() < 0) {
			e.collide("1");
		}
		if(collisionFix.getY() > 0) {
			e.collide("-i");
		} else if(collisionFix.getY() < 0) {
			e.collide("i");
		}
	}
	
	public static Vector collisionDetection(Collider c) {
		Vector force = new Vector();
		for(Entity e: Engine.entities) {
			if(e.isCollidable()) {
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
