package pl.jdomanski.bgames;

public class Vector {

	// == fields ==
	private Integer x;
	private Integer y;
	
	// == constructors ==
	public Vector(int x) {
		this.x = x;
	}
	
	

	public Vector(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// == public methods ==
	public Vector plus(Vector vector) {
		return new Vector(vector.getX() + this.x, vector.getY() + this.y);
	}
	
	public Integer getX() {
		return x;
	}

	public Integer getY() {
		return y;
	}

	@Override
	public String toString() {
		return "Vector [x=" + x + ", y=" + y + "]";
	}

}
