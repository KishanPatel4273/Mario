package loaders;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import window.Screen;

public class ImageLoader {
	
	private BufferedImage image;
	private int[] pixels;
	private int width, height;
	private String pathFix = System.getProperty("user.dir");
	public ImageLoader(String path) {
		path = pathFix + path;
		try {
			if(ResourceLoader.load(path) == null) {
				image = ImageIO.read(new File(path));
			} else {
				image = ImageIO.read(ResourceLoader.load(path));
			}
			//System.out.println(path + " loaded");
		} catch (IOException e) {
			e.printStackTrace();
		}	
		width = image.getWidth();
		height = image.getHeight();
		pixels = Texture.getPixels(image);
	}
	
	public BufferedImage getPart(int x, int y, int w, int h) {
		return image.getSubimage(x, y, w, h);
	}

	public int[] getPixels() {
		return pixels;
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}

