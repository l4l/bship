package org.inno.game;

/**
 * Created by kitsu.
 * This file is part of BattleShip in package org.inno.
 */
public class Sea implements Cellable<Integer, Cell>, java.io.Serializable {

    private final int size;
    protected Cell[][] map;

    public static final int SEA_DEFAULT_SIZE = 10;

    public Sea() {
        this(SEA_DEFAULT_SIZE);
    }

    /**
     * @param size of the maps
     */
    protected Sea(int size) {
        this.size = size;
        map = new Cell[this.size][this.size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                map[i][j] = Cell.EMPTY;
    }

    /**
     * Perform check to ability to place ship to the current {@link Sea}
     *
     * @param ship to check
     * @return true if can place it
     */
    public final boolean placeable(Ship ship) {
        int x = ship.getX();
        int y = ship.getY();
        ShipType type = ship.getType();
        if (ship.isHorizontal()) {
            return placeable(x, y, x, y + type.getSize() - 1);
        } else {
            return placeable(x, y, x + type.getSize() - 1, y);
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
            for (int j = y0; j <= y1; j++) {
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
        return (isNotShip(x + 1, y) && isNotShip(x + 1, y - 1) && isNotShip(x + 1, y + 1) &&
                isNotShip(x, y) && isNotShip(x, y - 1) && isNotShip(x, y + 1) &&
                isNotShip(x - 1, y) && isNotShip(x - 1, y - 1) && isNotShip(x - 1, y + 1));
    }

    /**
     * @param x coordinate
     * @param y coordinate
     * @return true if at coordinate exist ship
     */
    private boolean isNotShip(int x, int y) {
        return !(isExist(x, y) && map[x][y] == Cell.SHIP);
    }

    protected boolean isExist(int x, int y) {
        return !(x < 0 || y < 0 || x >= size || y >= size);
    }

    /**
     * Places ship at the {@link Sea}
     *
     * @param ship to place
     * @return true if placed
     */
    public final boolean addShip(Ship ship) {

        int x = ship.getX();
        int y = ship.getY();
        if (!placeable(ship))
            return false;

        int xEnd = x;
        int yEnd = y;

        int size = ship.getType().getSize();
        if (ship.isHorizontal()) {
            yEnd += size - 1;
        } else {
            xEnd += size - 1;
        }

        if (!(isExist(xEnd, yEnd) && isExist(x, y)))
            return false;

        setShip(x, y, xEnd, yEnd);

        return true;
    }

    /**
     * @param x coordinate
     * @param y coordinate
     * @return {@link Cell} which is placed at specified coordinate
     */
    public final Cell getCell(Integer x, Integer y) {
        if (isExist(x, y))
            return map[x][y];
        else
            return null;
    }

    /**
     * Perform a shoot to specified cell
     *
     * @param x coordinate
     * @param y coordinate
     * @return true if shoot was successful
     */
    public final boolean shoot(int x, int y) {
        if (map[x][y] == Cell.SHIP) {
            map[x][y] = Cell.BURN;
            return true;
        } else {
            map[x][y] = Cell.SHOT;
            return false;
        }
    }

    private void setShip(int x0, int y0, int x1, int y1) {
        for (int i = x0; i <= x1; i++) {
            for (int j = y0; j <= y1; j++) {
                map[i][j] = Cell.SHIP;
            }
        }
    }

}
