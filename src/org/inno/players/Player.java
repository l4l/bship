package org.inno.players;

import org.inno.*;
import org.inno.game.*;

/**
 * Created by kitsu.
 * This file is part of BattleShip in package org.inno.
 */
public abstract class Player {
    
    protected Sea self = new Sea();
    protected EnemySea enemy = new EnemySea();

    public static final int LEFT;
    static {
        int t = 0;
        for (ShipType type : ShipType.values())
            t += type.getNum() * type.getSize();
        LEFT = t;
    }

    private int left = LEFT;

    protected static void init(Player p) {
        for (ShipType type : ShipType.values())
            for (int i = 0; i < type.getNum(); i++)
                if (!p.self.addShip(p.placeShip(type))) {
                    i--;
                    Console.notifyErrorPlacement();
                } else {
                    Console.notifyGoodPlacement(p.self::getCell, Sea.SEA_DEFAULT_SIZE);
                }
    }

    public abstract Coord move();

    protected abstract Ship placeShip(ShipType ship);

    public final void setEnemyCell(Coord c, Cell cell) {
        //TODO
    }

    public Cell getSelfCell(int i, int j) {
        return self.getCell(i, j);
    }

    public void setEnemyCell(int i, int j, Cell cell) {
        enemy.setCell(i, j, cell);
    }

    public final boolean destroy(Coord c) {
        boolean f = self.shoot(c.x, c.y);
        if (f)
            left--;
        return isLoosed();
    }

    public boolean isLoosed() {
        return left <= 0;
    }

}
