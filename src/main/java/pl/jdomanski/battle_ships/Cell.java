package pl.jdomanski.battle_ships;

public class Cell {
	
	// == fields ==
	private boolean hitted = false;
	private Ship ship = null;
	
	// == constructors ==
	public Cell() {
		
	}
	
	public Cell(Ship ship) {
		this.ship = ship;
	}
	
	// == public methods ==
	
	public boolean isEmpty() {
		return this.ship == null;
	}
	
	public boolean isShip() {
		return !this.isEmpty();
	}

	public boolean isHitted() {
		return hitted;
	}

	public void setHitted(boolean hited) {
		this.hitted = hited;
		
		if (this.isShip()) {
			ship.hit();
		}
	}
	
	public boolean isNotHitted() {
		return !this.hitted;
	}

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	
	public String toString() {
		if (isEmpty()) {
			if (hitted) {
				return "*";
			} else return " ";
		}
		else {
			if (hitted) {
				return "X";
			} else return "S";
		}
	}
	
}
