package pl.jdomanski.bgames.player;

import java.util.Scanner;

import pl.jdomanski.bgames.Vector;
import pl.jdomanski.bgames.board.Connect4Board;
import pl.jdomanski.bgames.board.GameBoard;
import pl.jdomanski.bgames.board.TicTacToeBoard;

public class HumanPlayer implements Player {

	// == fields ==
	private Scanner input = new Scanner(System.in);
	
	private String name;
	
	private String mark;
	
	// == constructor ==
	public HumanPlayer(String name, String mark) {
		this.name = name;
		this.mark = mark;
	}

	@Override
	public Vector doMove(GameBoard board) {
		
		if (board instanceof TicTacToeBoard) {
			System.out.println("Podaj ruch (x,y): ");
				
			String[] in = input.nextLine().trim().split(",");
		
			return new Vector(Integer.valueOf(in[0]), Integer.valueOf(in[1]));
		} 
		else if (board instanceof Connect4Board) {
			
			System.out.println("Podaj ruch (x): ");
			
			String in = input.nextLine().trim();
		
			return new Vector(Integer.valueOf(in));
		}
		
		return null;
	}
	
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
		
	}

	@Override
	public String getMark() {
		return this.mark;
	}

	@Override
	public void setMark(String mark) {
		this.mark = mark;
		
	}
	
	// main method
	
		public static void main(String[] args) {
			Player player = new HumanPlayer("J", "X");
			TicTacToeBoard board = new TicTacToeBoard();
			
			System.out.println(player.doMove(board));
		}


}
