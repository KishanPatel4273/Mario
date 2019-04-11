package loaders;

import java.util.ArrayList;

public class TextureLoader {
	
	public ImageLoader objectSpriteSheet = new ImageLoader("res/ObjectSpriteSheet.png");
	public ImageLoader characterSpriteSheet = new ImageLoader("res/CharacterSpriteSheet.png");
	public ArrayList<Texture> sprites;
	
	public static int marioTallRight0 = 2;
	public static int brownBrick = 3;
	public static int brownSmoothBrick = 16;
	public static int blueBrick = 4;
	public static int brownFloor = 5;
	
	public static int questionBlock0 = 6;
	public static int questionBlock1 = 7;
	public static int questionBlock2 = 8;
	public static int questionBlock3 = 9;
	public static int questionBlock4 = 10;
	public static int[] questionBlockBuffer = {questionBlock0, questionBlock1, questionBlock2, questionBlock3, questionBlock4};

	public static int coin0 = 11;
	public static int coin1 = 12;
	public static int coin2 = 13;
	public static int coin3 = 14;
	public static int coin4 = 15;
	public static int[] coinBuffer = {coin0, coin1, coin2, coin3, coin4};
	
	public static int pipeTopLeft = 17;
	public static int pipeTopRight = 18;
	public static int pipeBodyLeft = 19;
	public static int pipeBodyRight = 20;

	
	public TextureLoader() {
		 sprites = new ArrayList<Texture>();
		 sprites.add(new Texture(objectSpriteSheet.getPart(321, 259, 16, 16), 4, brownFloor));//brown floor
		 sprites.add(new Texture(characterSpriteSheet.getPart(80, 1, 16, 32), 4, marioTallRight0));// mario
		 sprites.add(new Texture(objectSpriteSheet.getPart(253, 429, 16, 16), 4, brownBrick));// blown brick
		 sprites.add(new Texture(objectSpriteSheet.getPart(253, 463, 16, 16), 4, blueBrick));// blue brick
		 sprites.add(new Texture(objectSpriteSheet.getPart(338, 259, 16, 16), 4, brownSmoothBrick));// brown smooth brick

		 
		 sprites.add(new Texture(objectSpriteSheet.getPart(321, 310, 16, 16), 4, questionBlock0));// question block 0
		 sprites.add(new Texture(objectSpriteSheet.getPart(253, 12, 16, 23), 4, questionBlock1));// question block 1
		 sprites.add(new Texture(objectSpriteSheet.getPart(287, 12, 16, 23), 4, questionBlock2));// question block 2
		 sprites.add(new Texture(objectSpriteSheet.getPart(304, 12, 16, 23), 4, questionBlock3));// question block 2
		 sprites.add(new Texture(objectSpriteSheet.getPart(321, 327, 16, 16), 4, questionBlock4));// question block 4

		 sprites.add(new Texture(objectSpriteSheet.getPart(253, 225, 16, 16), 4, coin0));// coin 0
		 sprites.add(new Texture(objectSpriteSheet.getPart(270, 225, 16, 16), 4, coin1));// coin 1
		 sprites.add(new Texture(objectSpriteSheet.getPart(287, 225, 16, 16), 4, coin2));// coin 2
		 sprites.add(new Texture(objectSpriteSheet.getPart(304, 225, 16, 16), 4, coin3));// coin 3
		 sprites.add(new Texture(objectSpriteSheet.getPart(253, 242, 16, 16), 4, coin4));// coin 4

		 sprites.add(new Texture(objectSpriteSheet.getPart(338, 344, 16, 16), 4, pipeTopLeft));// pipe top left
		 sprites.add(new Texture(objectSpriteSheet.getPart(355, 344, 16, 16), 4, pipeTopRight));// pipe top right 
		 sprites.add(new Texture(objectSpriteSheet.getPart(338, 361, 16, 16), 4, pipeBodyLeft));// pipe body left 
		 sprites.add(new Texture(objectSpriteSheet.getPart(355, 361, 16, 16), 4, pipeBodyRight));// pipe body right 

		 
	}
	
	public Texture getTexture(int id) {
		for(int i = 0; i < sprites.size(); i++) {
			if(sprites.get(i).getID() == id) {
				return sprites.get(i);
			}
		}
		return null;
	}
}
