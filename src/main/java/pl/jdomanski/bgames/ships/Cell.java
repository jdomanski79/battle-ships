package pl.jdomanski.bgames.ships;

public class Cell {
	
	// == fields ==
	private boolean hit;
	private Ship ship;



	private Message message;
	// == constructors ==
	public Cell() {

	    this.ship = null;
	    this.hit = false;

	}
	

	public boolean isEmpty() {
		return this.ship == null;
	}
	
	public boolean isHit() {
		return hit;
	}

	public void hit() {
		this.hit = true;
		
		if (ship != null) {
			ship.hit();
		}

		setMessage();
	}

	public Message getMessage() {
		return message;
	}

	private void setMessage() {
		if (ship == null) {
			message = Message.MISSED;
			return;
		}
		if (ship != null && ship.isSunk())
			message = Message.SUNK;
		else
			message = Message.HIT;

	}

	public boolean isMissed() {
		return !this.hit;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	public String toString() {
		if (ship == null) {
			if (hit) {
				return "*";
			} else return " ";
		}
		else {
			if (ship.isSunk()) {
				return "#";
			} else if (hit) {
				return "X";
			} else return "S";
		}
	}
	
}
