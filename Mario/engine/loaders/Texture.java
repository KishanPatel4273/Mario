package loaders;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;

public class Texture {

	private int pixels[];
	private int width, height, id;

	public Texture(int[] pixels, int width, int height, int id) {
		this.pixels = pixels;
		this.width = width;
		this.height = height;
		this.id = id;
	}

	public Texture(BufferedImage image, int id) {
		pixels = getPixels(image);
		width = image.getWidth();
		height = image.getHeight();
		this.id = id;
	}
	
	public Texture(BufferedImage image, int scale, int id) {
		pixels = scale(scale, image);
		width = image.getWidth() * scale;
		height = image.getHeight() * scale;
		this.id = id;
	}

	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

	public int[] getPixels() {
		return pixels;
	}

	public int getID() {
		return id;
	}
	
	public static int[] getPixels(BufferedImage im) {
		int[] pixels = new int[im.getHeight() * im.getWidth()];
		for (int x = 0; x < im.getWidth(); x++) {
			for (int y = 0; y < im.getHeight(); y++) {
					pixels[x + y * im.getWidth()] = im.getRGB(x, y);
			}
		}
		return pixels;
	}

	public static int[] scale(int scale, BufferedImage img) {
		int[] pixels = new int[scale * img.getWidth() * scale * img.getHeight()]; 
		for(int x = 0; x < scale*img.getWidth(); x++) {
			for(int y = 0; y < scale*img.getHeight(); y++) {
				pixels[(x) + (y) * (scale*img.getWidth())] = img.getRGB(x/scale, y/scale);
			 }
		 }
		 return pixels;
	}
}
