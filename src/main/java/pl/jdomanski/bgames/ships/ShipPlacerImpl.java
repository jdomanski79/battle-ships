package pl.jdomanski.bgames.ships;

import pl.jdomanski.bgames.Directions;
import pl.jdomanski.bgames.Vector;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ShipPlacerImpl implements ShipPlacer{
    // == fields ==
    private Grid grid;

    // == constructor ==
    public ShipPlacerImpl() {
    }

    @Override
    public Set<Ship> createAndPlaceFleetAt(Grid grid){
        this.grid = grid;

        Set<Ship> fleet = new HashSet<>();
        Random random = new Random();
        Directions randomDirection = Directions.N;
        Vector firstPart = null;

        for (ShipTypes type: ShipTypes.values()){
            boolean placeFound  = false;

            while (!placeFound) {
                randomDirection = (random.nextBoolean()) ? Directions.N : Directions.E;
                firstPart = new Vector(random.nextInt(grid.WIDTH - 1), random.nextInt(grid.HEIGHT - 1));

                if (numberOfPlacesForShip(firstPart, randomDirection) >= type.getSize()) {
                    placeFound = true;
                }
            }

            Set<Cell> cells = getCellsForShip(firstPart,type,randomDirection);

            Ship ship = new Ship(type, cells);
            fleet.add(ship);
        }
        return fleet;

       // System.out.println(ownBoard);
    }

    private int numberOfPlacesForShip(Vector start, Directions direction) {
		Vector nextPlace = start;
		Vector directionVector = direction.getVector();
		int count = 0;

		while (grid.isInside(nextPlace) && isValidPlaceForShipPart(nextPlace)) {
		    nextPlace = nextPlace.plus(directionVector);
		    count++;
        }

        return count;
	}

	public Set<Cell> getCellsForShip(Vector start, ShipTypes type, Directions direction) {
		Set<Cell> parts = new HashSet<>();

		Vector nextVector = start;

		for (int i = 0; i < type.getSize(); i++){
			//parts.add(getCell(nextVector));
			nextVector = nextVector.plus(direction.getVector());
		}

		return parts;
	}

	// == private methods ==
	private boolean isValidPlaceForShipPart(Vector vector) {
		if (!grid.isInside(vector)) return false;

		for (Directions direction : Directions.values()) {
			Vector neighbour = vector.plus(direction.getVector());
			if (grid.isInside(neighbour)
                    && !grid.getCell(neighbour).isEmpty()) {
				return false;
			}

		}
		return true;
	}
}
