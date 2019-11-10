package pl.jdomanski.bgames.ships;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    private Set<Cell> cells = new HashSet<>();
    private Cell shipCell1;
    private Cell shipCell2;
    private Cell notShip;
    private Ship ship;

    @BeforeEach
    void init(){
        shipCell1 = new Cell();
        shipCell2 = new Cell();
        notShip = new Cell();

        cells.add(shipCell1);
        cells.add(shipCell2);

        ship = new Ship(ShipTypes.DESTROYER, cells);

    }

    @Test
    @DisplayName("Cell should be hit")
    void hit() {
        shipCell1.hit();

        assertThat(shipCell1.isHit()).isTrue();
    }

    @Test
    @DisplayName("Not ship shoudl be MISSED after hit")
    void getMessage_MISSED() {

        notShip.hit();
        assertThat(notShip.getMessage()).isEqualTo(Message.MISSED);
    }
    @Test
    @DisplayName("Ship should be HIT after hit")
    void getMessage_HIT() {

        shipCell1.hit();
        assertThat(shipCell1.getMessage()).isEqualTo(Message.HIT);
    }

    @Test
    @DisplayName("Ship should be SUNK after 2 hits")
    void getMessage_SUNK() {

        shipCell1.hit();
        shipCell2.hit();
        assertThat(shipCell2.getMessage()).isEqualTo(Message.SUNK);
    }
}