package tools;

public class Collider {

	private int x, y, width, height;

	public Collider(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public boolean contains(int x, int y) {
		return this.x <= x && x <= this.x + width && this.y <= y && y <= this.y + height;
	}

	public boolean contains(Vector v) {
		return contains((int) v.getX(), (int) v.getY());
	}

	public boolean intersect(Collider c) {
		return contains(c.getX(), c.getY()) || contains(c.getX() + c.getWidth(), c.getY())
				|| contains(c.getX(), c.getY() + c.getHeight())
				|| contains(c.getX() + c.getWidth(), c.getY() + c.getHeight())
				|| c.contains(x, y) || c.contains(x + width, y)||c.contains(x, y+height) ||c.contains(x+width, y+height);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
