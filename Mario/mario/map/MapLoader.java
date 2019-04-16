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
		loadTxtMap();
		Engine.entities.add(new Goomba(31*64, 12*64, 64, 64, TextureLoader.goomba));
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				Color color = new Color(pixels[x + y * width]);
				if(color.getRed() == 185 && color.getGreen() == 122 && color.getBlue() == 87) {
					Engine.entities.add(new Floor(x*64, y*64, 64, 64, "brownFloor"));
				}
				if(color.getRed() == 136 && color.getGreen() == 0 && color.getBlue() == 21) {
					Engine.entities.add(new Brick(x*64, y*64, 64, 64, "brownBrick"));
				}
				if(color.getRed() == 64 && color.getGreen() == 128 && color.getBlue() == 128) {
					Engine.entities.add(new Brick(x*64, y*64, 64, 64, "blueBrick"));
				}
				if(color.getRed() == 0 && color.getGreen() == 0 && color.getBlue() == 128) {
					Engine.entities.add(new Floor(x*64, y*64, 64, 64, "blueFloor"));
				}
				if(color.getRed() == 255 && color.getGreen() == 242  && color.getBlue() == 0) {
					Engine.entities.add(new Coin(x*64, y*64, 64, 64));
				}
				if(color.getRed() == 237 && color.getGreen() == 28 && color.getBlue() == 36) {
					Engine.entities.add(new Brick(x*64, y*64, 64, 64, "brownSmoothBrick"));
				}
				if(color.getRed() == 0 && color.getGreen() == 0 && color.getBlue() == 0) {
					Engine.entities.add(new Tile(x*64, y*64, 64, 64, 0, true));
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
				String s = str.substring(10);
				String dir = s.substring(0, s.indexOf(divider));
				s = s.substring(s.indexOf(divider) + 1);
				int x = Integer.valueOf(s.substring(0, s.indexOf(divider)));
				s = s.substring(s.indexOf(divider) + 1);
				int y = Integer.valueOf(s.substring(0, s.indexOf(divider)));
				s = s.substring(s.indexOf(divider) + 1);
				int h = Integer.valueOf(s.substring(0));
				Engine.entities.add(new Pipe(x*64, y*64, h, dir));		
			}
			if(str.indexOf("pipeIn") == 0) {
				String s = str.substring(6);
				String dir = s.substring(0, s.indexOf(divider));
				s = s.substring(s.indexOf(divider) + 1);
				int x = Integer.valueOf(s.substring(0, s.indexOf(divider)));
				s = s.substring(s.indexOf(divider) + 1);
				int y = Integer.valueOf(s.substring(0, s.indexOf(divider)));
				s = s.substring(s.indexOf(divider) + 1);
				int h = Integer.valueOf(s.substring(0, s.indexOf(divider)));
				s = s.substring(s.indexOf(divider) + 1);
				int newFrameX = Integer.valueOf(s.substring(0, s.indexOf(divider)));
				s = s.substring(s.indexOf(divider) + 1);
				int newFrameY = Integer.valueOf(s.substring(0));
				Engine.entities.add(new Pipe(x*64, y*64, h, dir, newFrameX*64, newFrameY*64));		
			}

			if(str.indexOf("pipeOut") == 0) {
				String s = str.substring(7);
				String dir = s.substring(0, s.indexOf(divider));
				s = s.substring(s.indexOf(divider) + 1);
				int x = Integer.valueOf(s.substring(0, s.indexOf(divider)));
				s = s.substring(s.indexOf(divider) + 1);
				int y = Integer.valueOf(s.substring(0, s.indexOf(divider)));
				s = s.substring(s.indexOf(divider) + 1);
				int h = Integer.valueOf(s.substring(0, s.indexOf(divider)));
				s = s.substring(s.indexOf(divider) + 1);
				int newFrameX = Integer.valueOf(s.substring(0, s.indexOf(divider)));
				s = s.substring(s.indexOf(divider) + 1);
				int newFrameY = Integer.valueOf(s.substring(0));
				Engine.entities.add(new Pipe(x*64, y*64, h, dir, newFrameX*64, newFrameY*64));		
			}
			
			if(str.indexOf("player") == 0) {
				String s = str.substring(7);
				int x = Integer.valueOf(s.substring(0, s.indexOf(divider)));
				s = s.substring(s.indexOf(divider) + 1);
				int y = Integer.valueOf(s.substring(0));
				Engine.entities.add(new Mario(x*64, y*64, 64, 128, TextureLoader.marioTallRight0));
			}
		}
	}
}
