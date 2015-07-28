package org.inno;

/**
 * Created by kitsu.
 * This file is part of BattleShip in package org.inno.
 */
public class Sea {

    private final int size;
    private Cell[][] map;

    public Sea(int size) {
        this.size = size;
        map = new Cell[this.size][this.size];
    }

    /**
     * Perform check to ability to place ship to the current {@link Sea}
     *
     * @param ship to check
     * @return true if can place it
     */
    public boolean placeable(Ship ship) {
        int x = ship.getX();
        int y = ship.getY();
        ShipType type = ship.getType();
        if (ship.isDown()) {
            return placeable(x, y, x, y + type.getSize());
        } else {
            return placeable(x, y, x + type.getSize(), y);
        }
    }

    /**
     * @param x0 start coordinate
     * @param y0 start coordinate
     * @param x1 end coordinate
     * @param y1 end coordinate
     * @return true if can place it
     */
    private boolean placeable(int x0, int y0, int x1, int y1) {
        for (int i = x0; i <= x1; i++) {
            for (int j = y0; j < y1; j++) {
                if (!placeable(i, j))
                    return false;
            }
        }
        return true;
    }

    /**
     * @param x coordinate
     * @param y coordinate
     * @return true if can place a 1 tile ship to coordinate
     */
    private boolean placeable(int x, int y) {
        return (isShip(x, y) && isShip(x + 1, y) &&
                isShip(x - 1, y) && isShip(x, y + 1) && isShip(x, y - 1));
    }

    /**
     * @param x coordinate
     * @param y coordinate
     * @return true if at coordinate exist ship
     */
    private boolean isShip(int x, int y) {
        return !(isExist(x, y) || map[x][y] != Cell.SHIP);
    }

    private boolean isExist(int x, int y) {
        return !(x < 0 || y < 0 || x >= size || y >= size);
    }

    /**
     * Places ship at the {@link Sea}
     *
     * @param ship to place
     * @return true if placed
     */
    public boolean addShip(Ship ship) {

        int x = ship.getX();
        int y = ship.getY();
        if (!placeable(ship))
            return false;

        if (ship.isDown())
            for (int i = 0; i < ship.getType().getSize(); i++)
                map[x][y + i] = Cell.SHIP;
        else
            for (int i = 0; i < ship.getType().getSize(); i++)
                map[x + i][y] = Cell.SHIP;

        return true;
    }

    public Cell getCell(int x, int y) {
        if (isExist(x, y))
            return map[x][y];
        else
            return null;
    }

    public boolean shoot(int x, int y) {
        if (map[x][y] == Cell.SHIP) {
            map[x][y] = Cell.BURN;
            return true;
        } else {
            map[x][y] = Cell.SHOT;
            return false;
        }
    }
}
