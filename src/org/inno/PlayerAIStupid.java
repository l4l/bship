package org.inno;

import java.util.Random;

/**
 * Created by kitsu.
 * This file is part of BattleShip in package org.inno.
 */
public class PlayerAIStupid extends Player {
    @Override
    public Coord move() {
        Coord c;
        Random r = new Random();
        do {
            c = new Coord(r.nextInt() % SEA_SIZE, r.nextInt() % SEA_SIZE);
        } while (enemy.getCell(c.x, c.y) != Cell.EMPTY);
        return c;
    }

    @Override
    protected Ship placeShip(ShipType ship) {
        Ship p;
        Random r = new Random();
        do {
            p = new Ship(ship, r.nextInt() % SEA_SIZE, r.nextInt() % SEA_SIZE, r.nextBoolean());
        } while (self.placeable(p));
        return p;
    }
}
