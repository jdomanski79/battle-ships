package pl.jdomanski.battle_ships;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ship {

	// == fields ==
	private Map<Vector, Cell> parts = new HashMap<>();
	private boolean sunk;
	private ShipTypes type;
	
	// == constructor ==
	public Ship(ShipTypes type) {
		this.type = type;
	}
	
	public Ship(ArrayList<Vector> vectors, ShipTypes type ) {
		
		for (Vector vector : vectors) {
			Cell cell = new Cell(this);
			parts.put(vector, cell);
		}
		this.setType(type);
		this.sunk = false;
	}
	
	// == public methods ==
	public boolean isSunk() {
		return this.sunk;
	}
	
	public void hit() {
		
		for (Vector vector : parts.keySet()) {
			if (parts.get(vector).isNotHitted()) {
				sunk = false;
				break;
			}
		}
		sunk = true;
	}

	public ShipTypes getType() {
		return type;
	}

	public void setType(ShipTypes type) {
		this.type = type;
	}

	public Map<Vector, Cell> getParts() {
		return parts;
	}
}
