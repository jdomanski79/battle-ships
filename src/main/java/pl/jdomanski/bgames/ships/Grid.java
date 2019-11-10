package pl.jdomanski.bgames.ships;

import pl.jdomanski.bgames.Vector;

import java.util.Arrays;

public class Grid {
    private Cell[] grid;
    public final int HEIGHT;
    public final int WIDTH;

    public Grid(int width, int height) {
        this.HEIGHT = height;
        this.WIDTH = width;
        this.grid = new Cell[width * height];

        for (int i = 0; i < HEIGHT * WIDTH; i++){
            grid[i] = new Cell();
        }
    }

    public Cell getCell(Vector vector){
        return grid[vector.getX() + vector.getY() * WIDTH];
    }

    public boolean isInside(Vector v){
        return (v.getX() >= 0 && v.getX() < WIDTH &&
                v.getY() >= 0 && v.getY() < HEIGHT);
    }
}
