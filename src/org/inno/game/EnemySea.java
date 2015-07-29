package org.inno.game;

/**
 * Created by kitsu.
 * This file is part of BattleShip in package org.inno.game.
 */
public class EnemySea extends Sea {

    /**
     * @param i coordinate(the same as x)
     * @param j coordinate(the same as y)
     * @param cell
     * @return true if placed
     */
    public boolean setCell(int i, int j, Cell cell) {
        if (isExist(i, j)) {
            map[i][j] = cell;
            return true;
        }
        return false;
    }
}
