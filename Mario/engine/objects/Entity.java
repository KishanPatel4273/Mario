package objects;

import tools.Collider;
import tools.Vector;

public class Entity {
	
	protected int x, y, width, height, id, tag;
	protected boolean transparency, collidable;
	
	public Entity(int x, int y, int width, int height, int id) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.id = id;
		this.tag = 0;
		transparency = false;
		collidable = true;
	}
	
	public void update() {

	}
	
	public int render() {
		return id;
	}
	
	public void collide(String direction) {
		
	}
	
	public int getID() {
		return id;
	}
	
	public void setID(int id) {
		this.id = id;
	}


	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public void addX(int x) {
		this.x += x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void addY(int y) {
		this.y += y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void addVector(Vector v) {
		x += v.getX();
		y += v.getY();
	}
	
	public Vector getCenter() {
		return new Vector(x + width/2, y + height/2);
	}
	
	public int getTag() {
		return tag;
	}
	
	public void setTag(int tag) {
		this.tag = tag;
	}
	
	public Collider getCollider() {
		return new Collider(x, y, width, height);
	}
	
	public void setTransparency(boolean transparency) {
		this.transparency = transparency;
	}
	
	public boolean getTransparency() {
		return transparency;
	}
	
	public boolean isCollidable() {
		return collidable;
	}

	public void setCollidable(boolean collidable) {
		this.collidable = collidable;
	}

	public String toString() {
		return "(" + x + " ," + y + " ," + width + " ," + height + ")" + " " + tag;
	}
}
