package org.inno;

/**
 * Created by kitsu.
 * This file is part of BattleShip in package org.inno.
 */

public enum Cell {
    EMPTY,
    SHIP,
    /**
     * Destroyed ship [part]
     */
    BURN,
    /**
     * Missed cell
     */
    SHOT
}
