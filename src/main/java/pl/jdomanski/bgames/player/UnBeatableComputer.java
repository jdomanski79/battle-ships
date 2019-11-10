package pl.jdomanski.bgames.player;

import java.util.ArrayList;
import java.util.Random;

import pl.jdomanski.bgames.Vector;
import pl.jdomanski.bgames.board.GameBoard;

public class UnBeatableComputer implements Player {

	// == fields ==
	
	private String oponnent;
	private int maxDepth = 6;
	private String name;
	private String mark;
	
	// == constructor ==
	public UnBeatableComputer(String name, String mark) {
		this.name = name;
		this.mark = mark;
		oponnent = (mark.equals("X")) ? "O" : "X";
	}

	@Override
	public Vector doMove(GameBoard board) {
		// TODO Auto-generated method stub
		return bestMove(board);
	}
	
	public void setMaxDepth(int depth) {
		this.maxDepth = depth;
	}
	// == private methdos ==
	
	private Vector bestMove(GameBoard board) {
		Vector bestMove = null;
		ArrayList<Vector> bestMoves = new ArrayList<Vector>();
 		int bestMoveValue = Integer.MIN_VALUE;
		
		for (Vector vector : board.getAvailableMoves() ) {
			
			board.submitMove(vector, mark);
			//System.out.println("testing vector START" + vector);
			//System.out.println(board);
			int moveValue = minmax( board,0, false);
			//System.out.println("Main vector " + vector + " value: " + moveValue);
			//System.out.println(board);
			//System.out.println("------------------------------------");
			board.undo(vector);
			
			if (moveValue > bestMoveValue) {
				bestMoves.clear();
				bestMoves.add(vector);
				bestMoveValue = moveValue;
			} else if (moveValue == bestMoveValue) {
				bestMoves.add(vector);
			}
		}
		//System.out.println("board after minmax: ");
		//System.out.println(board);
		Random rnd = new Random();
		bestMove = bestMoves.get(rnd.nextInt(bestMoves.size()));
		
		return bestMove;
	}
	
	private int minmax(GameBoard board, int depth, boolean isMaximazingPlayer) {
		//System.out.println("minmax board");
		//System.out.println(board);
		if (depth > maxDepth) {
			//System.out.println("to deep..");
			return 0;
		}
		if (board.isGameEnded()) {
			int val = 0; // tied
			
			if (board.isGameWon()) {
				val = (isMaximazingPlayer) ? -10 : 10;
			}
			return val;
		}
		int bestVal;
		String result = "";
		for (int i = 0; i<=depth; i++ ) {
			result += "   ";
		}
		if (isMaximazingPlayer) {
			bestVal = Integer.MIN_VALUE;
			for (Vector vector : board.getAvailableMoves()) {
				board.submitMove(vector, mark);
				//System.out.println(result + "submit " + vector + " " + depth);
				int val = minmax(board, depth + 1, false);
				bestVal = Math.max(val, bestVal);
				
//				if (depth == 1) {
//					System.out.println("       vector max " + vector + bestVal);
//				}
				//System.out.println(result + "undo   " + vector + " " + depth);
				board.undo(vector);
			}
		} else {
			bestVal = Integer.MAX_VALUE;
			for (Vector vector : board.getAvailableMoves()) {
				board.submitMove(vector, oponnent);
				//System.out.println(result + "submit " + vector + " " + depth);

				int val = minmax(board, depth + 1, true);
				bestVal = Math.min(val, bestVal);
				
//				if (depth == 1) {
//					System.out.println("       vector min" + vector + bestVal);
//				}
				//System.out.println(result + "undo   " + vector + " " + depth);

				board.undo(vector);
			}
			
		}
		//System.out.println("-----");
		return bestVal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}
	
	// == main method ==

}
