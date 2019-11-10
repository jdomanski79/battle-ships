package pl.jdomanski.bgames.ships;

public enum ShipTypes {
    CARRIER("Carrier",5),
    BATTLESHIP("Battleship",4),
    CRUISER("Cruiser", 3),
    SUBMARINE("Submarine", 3),
    DESTROYER("Destroyer",2);

    private String name;
    private int size;

    ShipTypes(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }
}


