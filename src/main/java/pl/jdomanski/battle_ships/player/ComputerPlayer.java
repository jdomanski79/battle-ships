package pl.jdomanski.battle_ships.player;

import pl.jdomanski.battle_ships.ShipsBoard;
import pl.jdomanski.battle_ships.Vector;

public class ComputerPlayer extends Player {

	// == fields ==
	private Vector lastShotVector;
	private boolean lastShotHit;
	
	// == constructor ==
	public ComputerPlayer(String name, ShipsBoard ownBoard, ShipsBoard enemyBoard) {
		super(name, ownBoard, enemyBoard);
		// TODO Auto-generated constructor stub
		lastShotVector = null;
		lastShotHit = false;
	}
	
	// == public methods ==
	@Override
	public void shoot() {
		Vector randomVector = getEnemyBoard().getRandomValidVector();
		getEnemyBoard().shootAt(randomVector);
	}
	
}
