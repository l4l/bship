package org.inno.game;

/**
 * Created by kitsu.
 * This file is part of BattleShip in package org.inno.game.
 */
public class EnemySea extends Sea {

    public boolean setCell(int i, int j, Cell cell) {
        if (isExist(i, j)) {
            map[i][j] = cell;
            return true;
        }
        return false;
    }
}
