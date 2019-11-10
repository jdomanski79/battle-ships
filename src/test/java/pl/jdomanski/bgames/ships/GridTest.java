package pl.jdomanski.bgames.ships;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.jdomanski.bgames.Vector;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class GridTest {
    private Grid grid;
    private int HEIGHT = 2;
    private int WIDTH = 2;

    @BeforeEach
    void init(){
        this.grid = new Grid(WIDTH,HEIGHT);
    }
    @Test
    void create(){
        assertThat(grid).isNotNull();
    }
    @Test
    void getCell(){
        Cell cell = grid.getCell(new Vector(0,0));

        assertThat(cell).isNotNull();
        assertThat(cell).isInstanceOf(Cell.class);
    }
    @Test
    void isInside_vector_Inside() {
        Vector vector = new Vector( 0, 0);

        assertThat(grid.isInside(vector)).isTrue();
    }

    @Test
    void isInside_vector_outside(){
        Vector vectorNegativeCoords = new Vector (-1, -1);
        Vector vectorHighCoords = new Vector (WIDTH, HEIGHT);

        assertThat(grid.isInside(vectorNegativeCoords)).isFalse();
        assertThat(grid.isInside(vectorHighCoords)).isFalse();
    }
}