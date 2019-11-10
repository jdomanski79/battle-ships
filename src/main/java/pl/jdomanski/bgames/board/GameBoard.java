package pl.jdomanski.bgames.board;

import java.util.ArrayList;

import pl.jdomanski.bgames.Vector;

public abstract class GameBoard {
	// == fields ==
	protected boolean gameWon = false;
	
	protected boolean gameTied = false;
	
	// == constructor ==
//	public GameBoard() {
//		reset();
//	}
	
	// == abstract methods ==
	abstract public void reset();

	abstract public boolean isValidMove(Vector vector);

	abstract public void submitMove(Vector vector, String mark);
	
	abstract public void undo(Vector vector);

	abstract public ArrayList<Vector> getAvailableMoves();

	abstract public boolean isGameEnded();
	
	abstract public String toString();
	
	// == methods ==
	public boolean isGameWon() {
		return gameWon;
	}

	public boolean isGameTied() {
		return gameTied;
	}

	

}