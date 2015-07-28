package org.inno;

/**
 * Created by kitsu.
 * This file is part of BattleShip in package org.inno.
 */
@FunctionalInterface
public interface Cellable<Integer, Cell> {
    public Cell getCell(Integer i, Integer j);
}