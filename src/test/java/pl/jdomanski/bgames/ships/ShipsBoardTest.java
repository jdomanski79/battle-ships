package pl.jdomanski.bgames.ships;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.jdomanski.bgames.Directions;


@Disabled
class ShipsBoardTest {

    static ShipsBoard board;

//    @BeforeAll
//    static void init(){
//        board = new ShipsBoard();
//    }
    /*
    @Test
    void isThereAvailablePlaceForShip_shouldSuccess() {
        Vector move = new Vector(0,0);
        int size = 2;
        boolean horizontal = false;

        assertThat(board.isThereAvailablePlaceForShip(move, size, horizontal), is(true));
    }
    @Test
    void isThereAvailablePlaceForShip_shouldFail() {
        Vector move = new Vector(9,9);
        int size = 2;
        boolean horizontal = false;

        assertThat(board.isThereAvailablePlaceForShip(move, size, horizontal), is(false));
    }

    @Test
    void placeShip(){
        Vector start = new Vector(0,0);
        int size = 3;
        boolean horizontal = true;

        board.placeShip(start, size, horizontal);
//        assertThat("Is ship.", board.get);
    }
// */

}
