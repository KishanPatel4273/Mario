package tools;

import objects.Entity;
import render.Engine;

public class Ray {
	
	private int x, y;
	private Vector a, b;
	
	public Ray(int x, int y, Vector v) {
		this.a = new Vector(x, y);
		this.b = Vector.add(a, v);
	}
	
	public float cast() {
		float l = Integer.MAX_VALUE;
		for(Entity e: Engine.entities) {
			if(e.getTag() == 0) {
				float tempL = segmentIntersection(a, b, new Vector(e.getX(), e.getY()), new Vector(e.getX() + e.getWidth(), e.getY()));
				if(tempL != -1 && tempL < l) {
					l = tempL;	
				}
			}
		}
		return l;
	}

	public float segmentIntersection(Vector a, Vector b, Vector c, Vector d) {
		Vector r = Vector.subtract(b, a);
		Vector s = Vector.subtract(d, c);
		float sxr = Vector.crossPoduct(s, r);
		float u = Vector.crossPoduct(Vector.subtract(a, c), r) / sxr;
		if(!(0 <= u && u <= 1)) {
			return -1;
		}
		float t = Vector.crossPoduct(Vector.subtract(c, a), s) / -sxr;
		if(0 <= t && t <= 1) {
			return Vector.scale(t, r).getMagnitude();
		} 
		return -1;
	}
	
}