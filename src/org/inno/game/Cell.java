package org.inno.game;

/**
 * Created by kitsu.
 * This file is part of BattleShip in package org.inno.
 */

public enum Cell implements java.io.Serializable {
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
    public final char sym;

    Cell(char sym) {
        this.sym = sym;
    }
}
