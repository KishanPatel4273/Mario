package map;

import java.awt.Color;
import java.util.ArrayList;

import entity.*;
import loaders.ImageLoader;
import loaders.LoadFile;
import loaders.TextureLoader;
import render.Engine;

public class MapLoader {
	
	private ImageLoader map;
	private ArrayList<String> txtMap;
	private int[] pixels;
	private int width, height;
	
	public MapLoader(String imagePath, String txtPath) {
		map = new ImageLoader(imagePath);
		txtMap = new LoadFile(txtPath).getFileText();
		pixels = map.getPixels();
		width = map.getWidth();
		height = map.getHeight();
	}
	
	public void load() {
		Engine.entities.add(new Mario(3*64, 3*64, 64, 128, TextureLoader.marioTallRight0));
		
		loadTxtMap();
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
	
	public void loadTxtMap() {
		String divider = "|";
		for(String str: txtMap) {
			if(str.indexOf("pipeClosed") == 0) {
				String s = str.substring(11);
				int x = Integer.valueOf(s.substring(0, s.indexOf(divider)));
				s = s.substring(s.indexOf(divider) + 1);
				int y = Integer.valueOf(s.substring(0, s.indexOf(divider)));
				s = s.substring(s.indexOf(divider) + 1);
				int h = Integer.valueOf(s.substring(0));
				Engine.entities.add(new Pipe(x*64, y*64, h));		
			}
		}
	}
}
