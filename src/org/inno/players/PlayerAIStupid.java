package org.inno.players;

import org.inno.game.*;

import java.util.Random;

/**
 * Created by kitsu.
 * This file is part of BattleShip in package org.inno.
 */
public class PlayerAIStupid extends PlayerAI {

    @Override
    public Coord move() {
        Coord c;
        Random r = new Random();
        do {
            int x = r.nextInt() % Sea.SEA_DEFAULT_SIZE;
            int y = r.nextInt() % Sea.SEA_DEFAULT_SIZE;
            c = new Coord(x, y);
        } while (enemy.getCell(c.x, c.y) != Cell.EMPTY);
        return c;
    }

    @Override
    protected Ship placeShip(ShipType ship) {
        Ship p;
        Random r = new Random();
        do {
            int x = Math.abs(r.nextInt()) % Sea.SEA_DEFAULT_SIZE;
            int y = Math.abs(r.nextInt()) % Sea.SEA_DEFAULT_SIZE;
            p = new Ship(ship, x, y, r.nextBoolean());
        } while (!self.placeable(p));
        return p;
    }
}
