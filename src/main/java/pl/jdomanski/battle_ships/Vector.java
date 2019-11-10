package pl.jdomanski.battle_ships;

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
	public void plus(Vector vector) {
		this.x = vector.getX() + this.x;
		this.y = vector.getY() + this.y;
	}
	
	public Vector copyOf() {
		return new Vector(this.getX(), this.getY());
	}
	
	public Vector add (Vector vector) {
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
