package render;

import java.util.ArrayList;

import controller.Controller;
import loaders.ImageLoader;
import loaders.Texture;
import loaders.TextureLoader;
import objects.Entity;
import tools.Frame;
import tools.Triangle;
import tools.Vector;

public class Engine extends Render {

	public static ArrayList<Entity> entities = new ArrayList<Entity>();
	public static Vector frameOfReference = new Vector();
	public TextureLoader textureloader;
	public Frame frame;
	
	public Engine(int width, int height) {
		super(width, height);
		textureloader = new TextureLoader();
		frame = new Frame(0, 0, width, height);
	}
	
	public void run() {
		clear();
		for(int i = 0; i < entities.size(); i++) {
			if(frame.inFrame(entities.get(i))) {
				update(entities.get(i));
				render(entities.get(i));						
			}
		}
	}
	
	public void update(Entity e) {				
		e.update();
	}
	
	public void render(Entity e) {
		if(!e.getTransparency()) {
			this.renderTexture(e.getX(), e.getY(), textureloader.getTexture(e.getID()));			
		}
	}
	
	public static void translateFrame(Vector frame) {
		Vector translate = Vector.add(Vector.scale(1, frameOfReference), Vector.scale(-1, frame));
		frameOfReference = Vector.add(frameOfReference, Vector.scale(-1, translate));
		for(Entity e: entities) {
			if(e.getTag() != 1) {
				e.addVector(translate);
			}
		}
	}
	
}
