package pl.jdomanski.battle_ships.player;

import java.util.ArrayList;
import java.util.Random;

import pl.jdomanski.battle_ships.Cell;
import pl.jdomanski.battle_ships.Directions;
import pl.jdomanski.battle_ships.Message;
import pl.jdomanski.battle_ships.ShipsBoard;
import pl.jdomanski.battle_ships.Vector;

public class ComputerPlayer extends Player {

	// == fields ==
	private Vector lastShotVector;
	private Message lastMessage;
	private Directions lastShotDirection;
	private final Directions[] mainDirections = 
		{Directions.N, Directions.S, Directions.E, Directions.W};
	private Random random = new Random();
	
	// == constructor ==
	public ComputerPlayer(String name, ShipsBoard ownBoard, ShipsBoard enemyBoard) {
		super(name, ownBoard, enemyBoard);
		// TODO Auto-generated constructor stub
		lastShotVector = null;
		lastMessage = Message.MISSED;
	}
	
	// == public methods ==
	@Override
	public void shoot() {
		if (lastMessage == Message.HIT) {
			
		}
		else if (lastMessage == Message.MISSED || lastMessage == Message.SUNK){
			Vector randomVector = getEnemyBoard().getRandomValidVector();
			lastMessage = getEnemyBoard().shootAt(randomVector);
		}
	}
	
	private Vector randomPossibleVector() {
		ArrayList<Vector> possibleVectors = new ArrayList<>();
		Vector positionOfNearShipPart = positionOfNearShipPart(lastShotVector);
		
		if (positionOfNearShipPart == null) {
			
			for (Directions direction: mainDirections) {
				Vector possibleVector = lastShotVector.add(direction.getVector());
				if (getEnemyBoard().isValidMove(possibleVector)){
					possibleVectors.add(possibleVector);
				}
			}
		} else {
			if (positionOfNearShipPart.getX() == lastShotVector.getX()) {
				
			}
		}
		
		return possibleVectors.get(random.nextInt(possibleVectors.size()));
	}
	
	private Vector getPossibleVectorInDirection(Vector start, Directions direction) {
		Vector possibleVector = start.add(direction.getVector());
		
		if (getEnemyBoard().getCellForEnemy(possibleVector).isShip()) 
			return getPossibleVectorInDirection(possibleVector, direction);
		
		if (getEnemyBoard().isValidMove(possibleVector)) 
			return possibleVector;
		else return null;
	}
	
	private Directions randomMainDirection() {
		return mainDirections[random.nextInt(mainDirections.length)];
	}
	
	private Vector positionOfNearShipPart(Vector vector) {
		for (Directions direction: mainDirections) {
			Cell checkedCell = getEnemyBoard().getCellForEnemy(vector.add(direction.getVector()));
			if (checkedCell != null && checkedCell.isShip()) {
				return vector.add(direction.getVector());
			}
		}
		
		return null;
	}
}
