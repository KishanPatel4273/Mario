package tools;

public class Vector {

	private float x, y;
	
	public Vector() {
		this.x = 0;
		this.y = 0;
	}
	
	public Vector(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public float getX() {
		return x;
	}
	
	public void addX(float x) {
		this.x += x;
	}
	
	public void addY(float y) {
		this.y += y;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void add(Vector v) {
		this.x += v.getX();
		this.y += v.getY();
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public float getY() {
		return y;
	}
	
	public float getMagnitude() {
		return (float) Math.sqrt(x*x + y*y);
	}
	
	public void clear() {
		x = 0;
		y = 0;
	}
	
	public String toString() {
		return "(" + x + " ," + y + ")";
	}
	
	public static Vector add(Vector v, Vector u) {
		return new Vector(v.getX() + u.getX(), v.getY() + u.getY());
	}
	
	public static Vector subtract(Vector v, Vector u) {
		return new Vector(v.getX() - u.getX(), v.getY() - u.getY());
	}
	
	public static float dotProcuct(Vector v, Vector u) {
		return v.getX() * u.getX() + v.getY() * u.getY();
	}
	
	public static Vector normalize(Vector v) {
		return new Vector(v.getX()/v.getMagnitude(), v.getY()/v.getMagnitude());
	}
	
	public static Vector scale(float s, Vector v) {
		return new Vector(s * v.getX(), s*v.getY());
	}
	
	public static float crossPoduct(Vector v, Vector u) {
		return v.getX() * u.getY() - v.getY() * u.getX();
	}
	
}
