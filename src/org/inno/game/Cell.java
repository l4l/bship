package org.inno.game;

/**
 * Created by kitsu.
 * This file is part of BattleShip in package org.inno.
 */

public enum Cell {
    EMPTY('.'),
    SHIP('@'),
    /**
     * Destroyed ship [part]
     */
    BURN('^'),
    /**
     * Missed cell
     */
    SHOT('*');

    /**
     * Symbol for outputting
     */
    @Deprecated
    public final char sym;

    Cell(char sym) {
        this.sym = sym;
    }
}
