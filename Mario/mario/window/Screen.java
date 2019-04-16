package window;

import loaders.ImageLoader;
import loaders.Texture;
import loaders.TextureLoader;
import map.MapLoader;
import render.Engine;
import render.Render;
import tools.Ray;
import tools.Vector;

public class Screen{

	private Engine engine;
	private MapLoader map1;
	
	public Screen(int width, int height) {
		engine = new Engine(width, height);
		map1 = new MapLoader("C:\\Users\\kelli\\git\\Mario\\Mario\\res\\SMB 1-1.png", "C:\\Users\\kelli\\git\\Mario\\Mario\\res\\SMB 1-1.txt");
		map1.load();
		System.out.println(Engine.entities.size());
	}
	
	public void update() {
		engine.run();
	}

	public int[] getPixels() {
		return engine.getPixels();
	}


	
}
