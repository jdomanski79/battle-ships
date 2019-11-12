package pl.jdomanski.battle_ships;

import java.util.ArrayList;
import java.util.Random;

public class ShipsBoard {
	// == fields ==
	private int WIDTH = 10;
	private int HEIGHT = 10;
	private Cell[] grid = new Cell[WIDTH * HEIGHT];
	private ArrayList<Ship> fleet;
	
	// == consturctors ==
	public ShipsBoard() {
		reset();
	}
	// == methods ==
	public void reset() {
		fleet = new ArrayList<>();

		for (int i = 0; i < WIDTH * HEIGHT; i++) {
			grid[i] = new Cell();
		}

	}
	
	public ArrayList<Ship> getFleet() {
		return fleet;
	}
	
	public boolean isValidMove(Vector vector) {
		return isInBoard(vector) && this.getCell(vector).isNotHitted();
	}

	public void submitMove(Vector vector, String mark) {
		this.getCell(vector).setHitted(true);

	}
	
	public Vector getRandomValidVector() {
		Random random = new Random();
		
		int randomInt = random.nextInt(getAvailableMoves().size());
		
		return getAvailableMoves().get(randomInt);

	}
	
	public ArrayList<Vector> getAvailableMoves() {

		ArrayList<Vector> list = new ArrayList<Vector>();

		for (int y = 0; y < HEIGHT; y++) {
			for (int x = 0; x < WIDTH; x++) {
				Vector vector = new Vector(x, y);
				if (getCell(vector).isNotHitted()) {
					list.add(vector);
				}
			}
		}
		return list;
	}

	public boolean isGameEnded() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		String result = "";
		for (int y = HEIGHT - 1; y >= 0; y--) {
			result += y;
			for (int x = 0; x < WIDTH; x++) {
				result += "| " + getCell(new Vector(x, y)) + " ";
			}

			result += "|\n";
		}
		return result;
	}
	
	public void placeShipsRandomly() {
		Random random = new Random();
		
		for (ShipTypes type:  ShipTypes.values()) {
			
			Vector randomVector;
			Directions randomDirection;
			Directions[] mainDirections = {Directions.N, Directions.S, Directions.E, Directions.W};
			
			do {
				int randomInt = random.nextInt(getAvailableMoves().size());
				randomVector = getAvailableMoves().get(randomInt);
							
				randomDirection = mainDirections[random.nextInt(mainDirections.length)];	
			} 
			while (!isThereAvailablePlaceForShip(randomVector, type, randomDirection));
						
			Ship ship = new Ship(type);
			placeShip(ship, randomVector, randomDirection);
			fleet.add(ship);
		}
	}
	
	public boolean isThereAvailablePlaceForShip(Vector start, ShipTypes shipType, Directions direction) {
		Vector nextVector = start.copyOf();

		for (int i = 0; i < shipType.getSize(); i++) {

			if (!isValidPlaceForShipPart(nextVector)) {
				return false;
			}

			nextVector.plus(direction.getVector());
		}

		return true;

	}

	public void placeShip(Ship ship, Vector start, Directions direction) {

		Vector currentVector = start.copyOf();

		for (int i = 0; i < ship.getType().getSize(); i++) {
			//System.out.println("Adding new part of ship..");
			//System.out.println(currentVector);

			getCell(currentVector).setShip(ship);
			ship.getParts().put(currentVector, getCell(currentVector));
			currentVector.plus(direction.getVector());

		}

	}

	// == private methods ==
	private boolean isValidPlaceForShipPart(Vector vector) {
		if (!isInBoard(vector) || !getCell(vector).isEmpty())
			return false;

		for (Directions direction : Directions.values()) {
			Vector neighbour = vector.add(direction.getVector());

			if (isInBoard(neighbour) && !getCell(neighbour).isEmpty()) {
				return false;
			}

		}
		return true;
	}

	private Cell getCell(Vector vector) {
		return grid[vector.getX() + vector.getY() * WIDTH];
	}

	private boolean isInBoard(Vector vector) {
		return vector.getX() >= 0 && vector.getX() < WIDTH && vector.getY() >= 0 && vector.getY() < HEIGHT;
	}

	// == main method ==
	public static void main(String[] args) {
		ShipsBoard board = new ShipsBoard();
		System.out.println(board.getAvailableMoves());
		board.placeShipsRandomly();
		System.out.println(board.toString());
		/*
		 * Ship ship1 = new Ship(ShipTypes.BATTLESHIP); Ship ship2 = new
		 * Ship(ShipTypes.CARRIER);
		 * 
		 * board.placeShip(ship1, new Vector(5, 5), Directions.N);
		 * board.placeShip(ship2, new Vector(0, 0), Directions.E);
		 * System.out.println(board.toString());
		 * 
		 * board.submitMove(new Vector(5, 5), "x"); board.submitMove(new Vector(1, 1),
		 * ""); System.out.println(board.toString());
		 */	}

}
