package pl.jdomanski.bgames.ships;

import java.util.Set;

public interface ShipPlacer {
    Set<Ship> createAndPlaceFleetAt(Grid grid);
}
