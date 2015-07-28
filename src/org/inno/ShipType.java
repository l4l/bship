package org.inno;

/**
 * Created by kitsu.
 * This file is part of BattleShip in package org.inno.
 */
public enum ShipType {

    BATTLESHIP(4),
    FRIGATE(3),
    CRUISER(2),
    BOAT(1);

    private int size;

    private ShipType(int width) {
        this.size = width;
    }

    public int getSize() {
        return size;
    }
}
