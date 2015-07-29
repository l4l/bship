package org.inno.players;

import org.inno.util.Console;
import org.inno.game.Coord;
import org.inno.game.Ship;
import org.inno.game.ShipType;

/**
 * Created by kitsu.
 * This file is part of BattleShip in package org.inno.
 */
public class PlayerHuman extends Player {

    public PlayerHuman() {
        init(this, true);
    }

    protected PlayerHuman(int i) {}

    @Override
    public Coord move() {
        return Console.readCoord();
    }

    @Override
    protected Ship placeShip(ShipType ship) {
        Console.greetingToPlaceShip(ship);
        Coord s = Console.readCoord();
        return new Ship(ship, s.x, s.y, Console.readPlacement());
    }

}
