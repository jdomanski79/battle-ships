package pl.jdomanski.bgames.player;

import pl.jdomanski.bgames.Vector;
import pl.jdomanski.bgames.board.GameBoard;

public interface Player {

	public Vector doMove(GameBoard board);

	public String getName();

	public void setName(String name);

	public String getMark(); 

	public void setMark(String mark);
	
}
