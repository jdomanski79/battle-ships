package pl.jdomanski.bgames.ships;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import pl.jdomanski.bgames.Directions;
import pl.jdomanski.bgames.Vector;

public class HumanBattleShipPlayer extends BattleShipPlayer {


	private Scanner input = new Scanner(System.in);
	
	// == constructor ==
	public HumanBattleShipPlayer(String name, ShipsBoard ownBoard, ShipsBoard enemyBoard) {
		super(name, ownBoard, enemyBoard);
	}

	// == public methods ==
	@Override
	public void shoot() {
		System.out.println("Podaj ruch:");

		String[] in = input.nextLine().trim().toLowerCase().split("");
		// TODO validation of input

		int y = in[0].charAt(0) - 97;
		int x = Integer.valueOf(in[1]) - 1;

		//enemyBoard.submitMove(new Vector(x,y));
	}

	@Override
	public void placeShipsManualy(){
		System.out.println("Podaj pozycje statków:");
		for (ShipTypes type: ShipTypes.values()){
			System.out.println("Podaj pozycję statku " + type.getName() + ".");
			System.out.println("Długość statku to: " + type.getSize());

			String in = input.nextLine().trim().toLowerCase();

			int y  = in.substring(0,1).charAt(0) - 'a';
			int x = Integer.valueOf(in.substring(1)) - 1;

			Vector shipFirstPart = new Vector(x,y);
			Set<Cell> cells = new HashSet<>();

			//TODO zaimplementuj wybór kierunku
			//cells = ownBoard.getCellsForShip(shipFirstPart, type, Directions.N);

			Ship ship = new Ship(type, cells);
			fleet.add(ship);
			System.out.println(ownBoard);

		}
	}


}
