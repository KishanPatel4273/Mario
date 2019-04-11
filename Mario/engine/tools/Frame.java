package tools;

import objects.Entity;

public class Frame extends Collider{

	public Frame(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	public boolean inFrame(Entity e) {
		return intersect(e.getCollider());
	}
	
}
