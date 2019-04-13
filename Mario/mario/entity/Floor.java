package entity;

import loaders.TextureLoader;
import objects.Entity;

public class Floor extends Entity{

	public Floor(int x, int y, int width, int height, String color) {
		super(x, y, width, height, TextureLoader.brownFloor);
		if(color.indexOf("blueFloor") > -1) {
			setID(TextureLoader.blueFloor);
		}
	}

}
