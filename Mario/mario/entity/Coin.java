package entity;

import loaders.TextureLoader;
import objects.Entity;
import tools.AnimationBuffer;

public class Coin extends Entity {

	private AnimationBuffer animationBuffer;
	private float time;
	
	public Coin(int x, int y, int width, int height) {
		super(x, y, width, height, TextureLoader.coin0);
		time = 1/10f;
		animationBuffer = new AnimationBuffer(TextureLoader.coinBuffer, time);
		setCollidable(false);
	}
	
	public void update() {
		setID(animationBuffer.update());
	}

	public void collide(String direction) {
		
	}
	
}
