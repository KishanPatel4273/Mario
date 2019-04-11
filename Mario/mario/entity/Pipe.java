package entity;

import java.util.ArrayList;

import loaders.TextureLoader;
import objects.Entity;
import render.Engine;

public class Pipe extends Entity{
	
	public Pipe(int x, int y, int height) {
		super(x, y, 128, 64, TextureLoader.pipeTopLeft);
		Engine.entities.add(new Tile(x + 64, y, 64, 64, TextureLoader.pipeTopRight));
		int j = 1;
		for(int i = 0; i < 2*height-2; i++) {
			if(i%2==0) {
				Engine.entities.add(new Tile(x, y + 64*j, 64, 64, TextureLoader.pipeBodyLeft));
			} else {
				Engine.entities.add(new Tile(x+64, y + 64 * j, 64, 64, TextureLoader.pipeBodyRight));
				j++;
			}
		}
	}
	
	
	
}  
