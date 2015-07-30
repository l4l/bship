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
        return Console.getInstace().readCoord();
    }

    @Override
    protected Ship placeShip(ShipType ship) {
        Console.getInstace().greetingToPlaceShip(ship);
        Coord s = Console.getInstace().readCoord();

        boolean placement = ship == ShipType.BOAT || Console.getInstace().readPlacement();
        return new Ship(ship, s.x, s.y, placement);
    }

}
