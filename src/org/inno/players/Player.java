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

    /**
     * Number of {@link Cell}s at the {@link Sea} that represent ships
     */
    public static final int LEFT;
    static {
        int t = 0;
        for (ShipType type : ShipType.values())
            t += type.getNum() * type.getSize();
        LEFT = t;
    }

    /**
     * Number of ship {@link Cell}s thats left on the {@link Sea}
     */
    private int left = LEFT;

    /**
     * Initialization of the player. Especially ship placement
     * @param p player for init
     * @param print is need to print or not
     */
    protected static void init(Player p, boolean print) {
        for (ShipType type : ShipType.values()) {
            for (int i = 0; i < type.getNum(); i++) {
                if (!p.self.addShip(p.placeShip(type))) {
                    i--;
                    if (print) Console.notifyErrorPlacement();
                } else {
                    if (print) Console.notifyGoodPlacement(p.self::getCell, Sea.SEA_DEFAULT_SIZE);
                }
            }
        }
    }

    /**
     * Perform a movement
     *
     * @return {@link Coord}inates of result
     */
    public abstract Coord move();

    /**
     * Place ship at the {@link Sea}
     *
     * @param ship type of the ship for placing
     * @return ship that should be placed
     */
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

    /**
     * @param c coordinate where enemy shoot
     * @return true if current player have no more ships left
     */
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
