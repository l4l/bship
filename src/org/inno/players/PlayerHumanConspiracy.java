package org.inno.players;

import org.inno.util.Console;
import org.inno.game.Cell;

/**
 * Created by kitsu.
 * This file is part of BattleShip in package org.inno.players.
 */
public class PlayerHumanConspiracy extends PlayerHuman {

    public PlayerHumanConspiracy() {
        super(0);
    }

    @Override
    public Cell getSelfCell(int i, int j) {
        return Console.readMissed() ? Cell.SHOT : Cell.BURN;
    }
}
