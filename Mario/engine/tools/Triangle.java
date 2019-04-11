package tools;

public class Triangle {
	
	private Vector[] vertices;
	
	public Triangle(Vector[] vertices) {
		this.vertices = vertices;
	}
	
	public Triangle(Vector a, Vector b, Vector c) {
		this.vertices = new Vector[] {a, b, c};
	}
	
	public Vector[] getVertices() {
		return vertices;
	}
	
	public void orderXLeftToRight() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(vertices[i].getX() > vertices[j].getX()) {
					Vector v = vertices[i];
					vertices[i] = vertices[j];
					vertices[j] = v;
				}
			}
		}
	}
	
	public int[] getSameYIndexLeft() {
		if(vertices[0].getY() == vertices[1].getY()) {
			return new int[] {0, 1, 2};
		}
		if(vertices[0].getY() == vertices[2].getY()) {
			return new int[] {0, 2, 1};
		}
		if(vertices[2].getY() == vertices[1].getY()) {
			return new int[] {1, 2, 0};
		}
		return null;
	}
}
