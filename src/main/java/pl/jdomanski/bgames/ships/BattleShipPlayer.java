package pl.jdomanski.bgames.ships;

import pl.jdomanski.bgames.Directions;
import pl.jdomanski.bgames.Vector;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public abstract class BattleShipPlayer {
    protected final ShipsBoard ownBoard;
    protected final ShipsBoard enemyBoard;
    // == fields ==
    protected String name;
    protected Set<Ship> fleet = new HashSet<>();

    public BattleShipPlayer(String name, ShipsBoard ownBoard, ShipsBoard enemyBoard) {
        this.name = name;
        this.ownBoard = ownBoard;
        this.enemyBoard = enemyBoard;
    }

    // == public methods ==
    public abstract void shoot();

    public String getName() {
        return name;
    }

    public abstract void placeShipsManualy();

    public boolean isLost() {
        return fleet.stream().allMatch(ship -> ship.isSunk());
    }



    public Message answer(){
		return ownBoard.getMessage();
	}
}
