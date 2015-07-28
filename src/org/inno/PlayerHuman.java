package org.inno;

/**
 * Created by kitsu.
 * This file is part of BattleShip in package org.inno.
 */
public class PlayerHuman extends Player {


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