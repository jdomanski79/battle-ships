package pl.jdomanski.bgames;

public enum Directions {
	N (new Vector( 0, 1)),
	NE(new Vector( 1, 1)),
	E (new Vector( 1, 0)),
	SE(new Vector( 1,-1)),
	S (new Vector( 0,-1)),
	SW(new Vector(-1,-1)),
	W (new Vector(-1, 0)),
	NW(new Vector(-1, 1));
	
	private Vector vector;
	
	Directions(Vector vector) {
		this.vector = vector;
	}
	
	public Vector getVector() {
		return this.vector;
	}
}
