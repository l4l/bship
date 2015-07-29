package org.inno.game;

/**
 * Created by kitsu.
 * This file is part of BattleShip in package org.inno.
 */
public class Ship {

    private final ShipType type;

    private final int x;
    private final int y;

    /**
     * Type of placement of the ship.<br>
     * True means from up-to-down placement<br>
     * False means from left-to-right placement
     */
    private final boolean isDown;

    /**
     * @param type of the ship
     * @param x start coordinate
     * @param y start coordinate
     * @param isDown if true it placed from (x0, y0) to (x0, y0+size)<br>
     *               else placed from (x0, y0) to (x0+size, y0)
     */
    public Ship(ShipType type, int x, int y, boolean isDown) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.isDown = isDown;
    }

//    public boolean isHere(int x, int y) {
//        if (isDown) {
//            return this.x == x && Math.abs(this.y - y) < type.getSize();
//        } else {
//            return this.y == y && Math.abs(this.x - x) < type.getSize();
//        }
//    }

    public ShipType getType() {
        return type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isDown() {
        return isDown;
    }
}
