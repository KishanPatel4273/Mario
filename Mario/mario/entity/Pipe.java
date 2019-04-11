package entity;

import java.util.ArrayList;

import loaders.TextureLoader;
import objects.Entity;
import render.Engine;

public class Pipe extends Entity{

	private ArrayList<Entity> tiles = new ArrayList<Entity>();
	
	public Pipe(int x, int y, int height) {
		super(x, y, 128, 64*height, TextureLoader.pipeTopLeft);
		tiles.add(new Tile(x + 64, y, 64, 64, TextureLoader.pipeTopRight));
		tiles.get(0).setCollidable(false);
		int j = 1;
		for(int i = 0; i < 2*height-2; i++) {
			if(i%2==1) {
				tiles.add(new Tile(x+64, y + 64 * j, 64, 64, TextureLoader.pipeBodyRight));
				j++;
			} else {
				tiles.add(new Tile(x, y + 64*j, 64, 64, TextureLoader.pipeBodyLeft));
			}
			tiles.get(i+1).setCollidable(false);
		}
		Engine.entities.addAll(tiles);
	}
	
}  
