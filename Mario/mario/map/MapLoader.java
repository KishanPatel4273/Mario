package map;

import java.awt.Color;

import entity.*;
import loaders.ImageLoader;
import loaders.TextureLoader;
import render.Engine;

public class MapLoader {
	
	private ImageLoader map;
	private int[] pixels;
	private int width, height;
	
	public MapLoader(String path) {
		map = new ImageLoader(path);
		pixels = map.getPixels();
		width = map.getWidth();
		height = map.getHeight();
	}
	
	public void load() {
		Engine.entities.add(new Mario(3*64, 3*64, 64, 128, TextureLoader.marioTallRight0));
		Engine.entities.add(new Pipe(28*64, 11*64, 2));
		Engine.entities.add(new Pipe(33*64, 9*64, 4));

		
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				Color color = new Color(pixels[x + y * width]);
				if(color.getRed() == 185 && color.getGreen() == 122 && color.getBlue() == 87) {
					Engine.entities.add(new Floor(x*64, y*64, 64, 64, "brownFloor"));
				}
				if(color.getRed() == 136 && color.getGreen() == 0 && color.getBlue() == 21) {
					Engine.entities.add(new Brick(x*64, y*64, 64, 64, "brownBrick"));
				}
				if(color.getRed() == 237 && color.getGreen() == 28 && color.getBlue() == 36) {
					Engine.entities.add(new Brick(x*64, y*64, 64, 64, "brownSmoothBrick"));
				}
				if(color.getRed() == 255 && color.getGreen() == 201 && color.getBlue() == 14) {
					Engine.entities.add(new QuestionBlock(x*64, y*64, 64, 64));
				}
			}
		}
	}
	
}
