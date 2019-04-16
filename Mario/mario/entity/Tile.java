package entity;

import objects.Entity;

public class Tile extends Entity{

	public Tile(int x, int y, int width, int height, int id) {
		super(x, y, width, height, id);
	}
	
	public Tile(int x, int y, int width, int height, int id, boolean transparency) {
		super(x, y, width, height, id);
		setTransparency(transparency);
	}

}
