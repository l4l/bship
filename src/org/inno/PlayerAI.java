package org.inno;

import java.util.function.Consumer;

/**
 * Created by kitsu.
 * This file is part of BattleShip in package org.inno.
 */
public class PlayerAI extends Player {


    @Override
    public void move(Consumer consumer) {

    }

    @Override
    public Ship placeShip(ShipType ship) {
        return null;
    }

    public static enum Complexity {
        EASY,
        NORMAL,
        HARD,
        IMPOSSIBLE;
    }
}
