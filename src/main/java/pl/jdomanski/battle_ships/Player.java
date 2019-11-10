package pl.jdomanski.battle_ships;

public class Player {

	// == fields ==
	private String name;
	private ShipsBoard ownBoard;
	private ShipsBoard enemyBoard;

	// == constructor ==
	public Player(String name, ShipsBoard ownBoard, ShipsBoard enemyBoard) {
		this.name = name;
		this.ownBoard = ownBoard;
		this.enemyBoard = enemyBoard;
	}

		// == public methods ==
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setName(String name) {
		// TODO Auto-generated method stub

	}

		public boolean isLost() {
		return ownBoard.getFleet().stream().
					allMatch(ship -> ship.isSunk());
	}

	public ShipsBoard getOwnBoard() {
		return ownBoard;
	}

	public void setOwnBoard(ShipsBoard ownBoard) {
		this.ownBoard = ownBoard;
	}

	public ShipsBoard getEnemyBoard() {
		return enemyBoard;
	}

	public void setEnemyBoard(ShipsBoard enemyBoard) {
		this.enemyBoard = enemyBoard;
	}
}
