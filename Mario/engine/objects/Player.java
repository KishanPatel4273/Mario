package objects;

import controller.Controller;
import controller.InputHandler;
import tools.Vector;

public class Player extends Entity{

	private Controller controller;
	
	public Player(int x, int y, int width, int height, int id) {
		super(x, y, width, height, id);
		controller = new Controller();
		setTag(1);
	}
	
	public void update() {
		controller.update(this, InputHandler.key);
	}
	
}



