package entity;

import loaders.TextureLoader;
import objects.Entity;

public class Brick extends Entity {

	public Brick(int x, int y, int width, int height, String type) {
		super(x, y, width, height, TextureLoader.brownBrick);
		if(type.indexOf("blueBrick") > -1) {
			setID(TextureLoader.blueBrick);
		}
		if(type.indexOf("brownSmoothBrick") > -1) {
			setID(TextureLoader.brownSmoothBrick);
		}

	}
	
	
}
