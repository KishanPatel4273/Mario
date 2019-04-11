package entity;

import loaders.TextureLoader;
import objects.Entity;
import render.Engine;
import tools.AnimationBuffer;

public class QuestionBlock extends Entity{

	private AnimationBuffer animationBuffer;
	private boolean open, fix;
	private float time;
	
	public QuestionBlock(int x, int y, int width, int height) {
		super(x, y, width, height, TextureLoader.questionBlock0);
		open = false;
		fix = false;
		time = 1/20f;
		animationBuffer = new AnimationBuffer(TextureLoader.questionBlockBuffer, time);
	}

	public void update() {
		if(!fix && open && animationBuffer.getCycles() < 1) {
			setID(animationBuffer.update());
		}
		if(!fix && animationBuffer.getCycles() > 0) {
			fix = true;
			addY(7);
			setID(TextureLoader.questionBlock4);
			Engine.entities.add(new Coin(x, y - 64, 64, 64));
		}
	}
	
	public void collide(String direction) {
		if(!open && direction.equals("-i")) {
			addY(-7);
			open = true;
		}
	}
	
}
