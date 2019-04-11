package render;

import java.awt.Color;

import loaders.ImageLoader;
import loaders.Texture;
import tools.Triangle;
import tools.Vector;

public class Render {
	
	private int width, height, color;
	private int[] pixels;
	private int objectTransparency, characterTransparency;
	
	public Render(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		color = 0;
		objectTransparency = -5649467;
		characterTransparency = 9578383;
	}

	public void drawPoint(int x, int y, int color) {
		if (x >= 0 && x < width && y >= 0 && y < height && color != objectTransparency && color != characterTransparency) {
			pixels[x + y * width] = color;
		}
	}

	/**
	 * @return from (x1, y1) to (x2, y2) draws line
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		if (x1 != x2) {
			float slope = ((float) (y1 - y2) / (x1 - x2));
			for (int x = Math.min(x1, x2); x < Math.max(x1, x2); x++) {
				int y = (int) ((float) (slope * (x - x1) + y1));
				drawPoint(x, y, color);
			}			
			for (int y = Math.min(y1, y2); y < Math.max(y1, y2); y++) {					
				int x = (int) ((float) ((y - y1) / slope)) + x1;
				drawPoint(x, y, color);	
			}
		} else {
			for (int y = Math.min(y1, y2); y < Math.max(y1, y2); y++) {
				drawPoint(x1, y, color);
			}
		}
	}
	
	public void drawHorizontalLine(int x1, int x2, int y) {
		for (int x = Math.min(x1, x2); x < Math.max(x1, x2); x++) {
			drawPoint(x, y, color);
		}
	}
	
	/**
	 * @param a and c have same y value
	 */
	public void fillFlatTriangle(Vector a, Vector b, Vector c) {
		float ABdy = (a.getX() - b.getX()) / (a.getY() - b.getY());
		float CBdy = (c.getX() - b.getX()) / (c.getY() - b.getY());
		if(a.getY() > b.getY()) {
			for(int y = 0; y <= a.getY() - b.getY(); y++) {
				drawHorizontalLine((int) (b.getX()+y*ABdy),(int) (b.getX()+y*CBdy), (int) (b.getY() + y));
			}
		} else if(a.getY() < b.getY()) {
			for(int y = 0; y <= b.getY() - a.getY(); y++) {
				drawHorizontalLine((int) (a.getX()+y*ABdy),(int) (c.getX()+y*CBdy), (int) (a.getY() + y));
			}
		}
	}
	
	public void fillTriangle(Vector a, Vector b, Vector c) {
		//split
		if(Math.min(b.getY(), c.getY()) <= a.getY() && a.getY() <= Math.max(b.getY(), c.getY())) {// a is middle
			float BCdx = (c.getY() - b.getY()) / (c.getX() - b.getX());
			float x = (a.getY() - b.getY()) / BCdx + b.getX();
			Vector d = new Vector(x, a.getY());
			fillFlatTriangle(a, b, d);
			fillFlatTriangle(a, c, d);
		} else if(Math.min(a.getY(), c.getY()) <= c.getY() && c.getY() <= Math.max(b.getY(), a.getY())) {// c is middle
			float ABdx = (a.getY() - b.getY()) / (a.getX() - b.getX());
			float x = (c.getY() - b.getY()) / ABdx + b.getX();
			Vector d = new Vector(x, c.getY());
			fillFlatTriangle(c, a, d);
			fillFlatTriangle(c, b, d);
		} else if(Math.min(a.getY(), c.getY()) <= b.getY() && b.getY() <= Math.max(a.getY(), c.getY())) {// b is middle
			float ACdx = (a.getY() - c.getY()) / (a.getX() - c.getX());
			float x = (b.getY() - a.getY()) / ACdx + a.getX();
			Vector d = new Vector(x, b.getY());
			fillFlatTriangle(b, a, d);
			fillFlatTriangle(b, c, d);
		}
	}
	
	public void fillTriangle(Triangle t) {
		t.orderXLeftToRight();
		fillTriangle(t.getVertices()[0], t.getVertices()[1],t.getVertices()[2]);
	}
	
	public void drawTriangle(Vector a, Vector b, Vector c) {
		drawLine((int) a.getX(), (int)a.getY(), (int)b.getX(), (int)b.getY());
		drawLine((int) a.getX(), (int)a.getY(), (int)c.getX(), (int)c.getY());
		drawLine((int) c.getX(), (int)c.getY(), (int)b.getX(), (int)b.getY());
	}
	
	public void drawTriangle(Triangle t) {
		drawTriangle(t.getVertices()[0], t.getVertices()[1],t.getVertices()[2]);
	}
	
	public void renderTexture(int x, int y, Texture texture) {
		for(int i = x; i < x+texture.getWidth(); i++) {
			for(int j = y; j < y+texture.getHeight(); j++) {
				drawPoint(i, j, texture.getPixels()[(i-x) + (j-y) * texture.getWidth()]);
			}
		}
	}
	
	public static Color getINRGBTORGB(int intRGB) {
		int r = (intRGB >> 16) &  0xFF;
		int g = (intRGB >> 8) & 0xFF;
		int b = (intRGB >> 0) & 0xFF;
		return new Color(r,g,b);
	}
	
	public int[] getPixels() {
		return pixels;
	}
	
	public void setColor(int color) {
		this.color = color;
	}

	public void clear() {
		pixels = new int[width * height];
	}
}
