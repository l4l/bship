package org.inno;

/**
 * Created by kitsu.
 * This file is part of BattleShip in package org.inno.
 */
public enum ShipType {

    BATTLESHIP(4, 1),
    FRIGATE(3, 2),
    CRUISER(2, 3),
    BOAT(1, 4);

    private final int size;
    private final int num;

    private ShipType(int size, int num) {
        this.size = size;
        this.num = num;
    }

    public int getSize() {
        return size;
    }

    public int getNum() {
        return num;
    }
}
