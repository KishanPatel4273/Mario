package loaders;

import java.util.ArrayList;

public class TextureLoader {
	
	public ImageLoader objectSpriteSheet = new ImageLoader("/spritesheet/ObjectSpriteSheet.png");
	public ImageLoader characterSpriteSheet = new ImageLoader("/spritesheet/CharacterSpriteSheet.png");
	public ArrayList<Texture> sprites;
	
	public static int marioTallRight0 = 2;
	public static int brownBrick = 3;
	public static int brownSmoothBrick = 16;
	public static int blueBrick = 4;
	public static int brownFloor = 5;
	public static int blueFloor = 27;
	
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
	
	public static int pipeTopLefti = 17;
	public static int pipeTopRighti = 18;
	public static int pipeBodyLefti = 19;
	public static int pipeBodyRighti = 20;

	public static int pipeTopTopneg1 = 21;
	public static int pipeTopBottomneg1 = 22;
	
	public static int pipeBodyTopLeftCorner = 23;
	public static int pipeBodyTopRightCorner = 24;
	public static int pipeBodyBottomRightCorner = 25;
	public static int pipeBodyBottomLeftCorner = 26;

	public static int goomba = 28;
	
	public TextureLoader() {
		 sprites = new ArrayList<Texture>();
		 sprites.add(new Texture(objectSpriteSheet.getPart(321, 259, 16, 16), 4, brownFloor));//brown floor
		 sprites.add(new Texture(objectSpriteSheet.getPart(321, 276, 16, 16), 4, blueFloor));//blue floor
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

		 sprites.add(new Texture(objectSpriteSheet.getPart(338, 344, 16, 16), 4, pipeTopLefti));// pipe top left i
		 sprites.add(new Texture(objectSpriteSheet.getPart(355, 344, 16, 16), 4, pipeTopRighti));// pipe top right i
		 sprites.add(new Texture(objectSpriteSheet.getPart(338, 361, 16, 16), 4, pipeBodyLefti));// pipe body left i
		 sprites.add(new Texture(objectSpriteSheet.getPart(355, 361, 16, 16), 4, pipeBodyRighti));// pipe body right i 
		 sprites.add(new Texture(objectSpriteSheet.getPart(321, 378, 16, 16), 4, pipeTopTopneg1));// pipe top top -1 
		 sprites.add(new Texture(objectSpriteSheet.getPart(321, 395, 16, 16), 4, pipeTopBottomneg1));// pipe top bottom -1 
		 sprites.add(new Texture(objectSpriteSheet.getPart(338, 378, 16, 16), 4, pipeBodyTopLeftCorner));// pipe body top left corner
		 sprites.add(new Texture(objectSpriteSheet.getPart(355, 378, 16, 16), 4, pipeBodyTopRightCorner));// pipe body top right corner
		 sprites.add(new Texture(objectSpriteSheet.getPart(338, 395, 16, 16), 4, pipeBodyBottomLeftCorner));// pipe body bottom left corner
		 sprites.add(new Texture(objectSpriteSheet.getPart(355, 395, 16, 16), 4, pipeBodyBottomRightCorner));// pipe body bottom right corner
		 
		 sprites.add(new Texture(objectSpriteSheet.getPart(423, 12, 16, 16), 4, goomba));// pipe body bottom right corner
	}
	
	public Texture getTexture(int id) {
		for(int i = 0; i < sprites.size(); i++) {
			if(sprites.get(i).getID() == id) {
				return sprites.get(i);
			}
		}
		return sprites.get(0);
	}
}
