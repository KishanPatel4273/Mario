package entity;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import controller.InputHandler;
import loaders.TextureLoader;
import objects.Entity;
import render.Engine;
import tools.Vector;

public class Pipe extends Entity{
	
	private boolean open;
	private int frameX, frameY;
	private String direction;
	
	public Pipe(int x, int y, int height, String direction) {
		super(x, y, 128, 64, 0);
		this.open = false;
		this.direction = direction;
		addPipe(direction, height);
	}
	
	public Pipe(int x, int y, int height, String direction, int frameX, int frameY) {
		super(x, y, 128, 64, 0);
		this.frameX = frameX;
		this.frameY = frameY;
		this.open = true;
		this.direction = direction;
		addPipe(direction, height);
	}
	
	public void addPipe(String direction, int height) {
		if(direction.equals("i")) {
			setID(TextureLoader.pipeTopLefti);
			Engine.entities.add(new Tile(x + 64, y, 64, 64, TextureLoader.pipeTopRighti));
			int j = 1;
			for(int i = 0; i < 2*height-2; i++) {
				if(i%2==0) {
					Engine.entities.add(new Tile(x, y + 64*j, 64, 64, TextureLoader.pipeBodyLefti));
				} else {
					Engine.entities.add(new Tile(x+64, y + 64 * j, 64, 64, TextureLoader.pipeBodyRighti));
					j++;
				}
			}
		}
		if(direction.equals("-1")) {
			height = 128;
			width = 64;
			setID(TextureLoader.pipeTopTopneg1);
			Engine.entities.add(new Tile(x, y + 64, 64, 64, TextureLoader.pipeTopBottomneg1));
			Engine.entities.add(new Tile(x+64, y, 64, 64, TextureLoader.pipeBodyTopLeftCorner));
			Engine.entities.add(new Tile(x+64, y+64, 64, 64, TextureLoader.pipeBodyBottomLeftCorner));

		}
	}
	
	boolean latch = false;
	Entity player;
	
	public void update() {
		if(!latch){
			for(Entity e:Engine.entities) {
				if(e.getTag() == 1) {
					player = e;
					latch = true;
				}
			}
		}
		if(open) {
			if(direction.equals("i")) {
				if(InputHandler.key[KeyEvent.VK_S] && distanceFrom(player) < 10 + height/2 + player.getHeight()/2) {
					Engine.translateFrame(new Vector(frameX, frameY));
					player.setY(0);
				}
			}
			if(direction.equals("-1")) {
				if(InputHandler.key[KeyEvent.VK_D] && distanceFrom(player) < 10 + width/2 + player.getWidth()/2) {
					Engine.translateFrame(new Vector(frameX, frameY));
					player.setY(500);
				}
			}
		}
	}	
	
	public void collide(String direction) {
		
	}

}  
