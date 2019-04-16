package entity;

import objects.Entity;

public class Goomba extends Entity{
	private int direction;
	private int speed;

	public Goomba(int x, int y, int width, int height, int id) {
		super(x, y, width, height, id);
		direction=-1;
		speed=1;
	}

	public void collide(String direction) {
		if(direction.equals("-1")) {
			this.direction=1;
		}
		if(direction.equals("1")) {
			this.direction=-1;
		}
	}
	
	public void update() {
		if(direction==1) {
			addX(speed);
		}
		if(direction==-1) {
			addX(-speed);
		}
	}
	
	
}
