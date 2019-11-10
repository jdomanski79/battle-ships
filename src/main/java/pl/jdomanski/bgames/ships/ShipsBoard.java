package pl.jdomanski.bgames.ships;

import java.util.ArrayList;
import java.util.List;

import pl.jdomanski.bgames.Vector;

public class ShipsBoard {
	// == fields ==
	private int WIDTH = 10;
	private int HEIGHT = 10;
	private Message message;
    private Grid grid;

	public ShipsBoard(Grid grid) {
	    this.grid = grid;
	}
	
	public boolean isValidShot(Vector vector) {
		return grid.isInside(vector) &&
			   !grid.getCell(vector).isHit();
	}

	public void saveShot(Vector shot ) {
		Cell cell = grid.getCell(shot);
		cell.hit();
		message = cell.getMessage();
	}

	public Message getMessage(){
		return message;
	}

	public ArrayList<Vector> getAvailableShots() {
		ArrayList<Vector> availableShots = new ArrayList<>();
		for (Vector vector: allVectorsInGrid()) {
            if (!grid.getCell(vector).isHit()) {
                availableShots.add(vector);
            }
        }
		return availableShots;
	}

    private List<Vector> allVectorsInGrid(){
	    List<Vector> vectors = new ArrayList<>();
    	for (int y = 0; y < HEIGHT; y++){
            for(int x=0;x<WIDTH; x++){
               vectors.add(new Vector (x,y));
            }
        }
        return vectors;
    }

	@Override
	public String toString() {
		String result = "    1   2   3   4   5   6   7   8   9   10 \n";
		for (int y = 0; y < HEIGHT; y++) {
			result += Character.toString((char) (y + 97)).toUpperCase() + " ";
			for (int x = 0; x < WIDTH; x++) {
				result += "| " + grid.getCell(new Vector(x,y)) + " ";
			}
			
			result += "|\n";
		}
		result +="\n\n\n";
		return result;
	}

}
