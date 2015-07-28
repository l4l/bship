package org.inno;

/**
 * Created by kitsu.
 * This file is part of BattleShip in package org.inno.
 */
public abstract class Player {

    public static final int SEA_SIZE = 10;
    
    protected Sea self = new Sea(SEA_SIZE);

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
                    Console.notifyGoodPlacement(p.self::getCell, SEA_SIZE);
                }
    }

    public abstract Coord move();

    public final boolean destroy(Coord c) {
        boolean f = self.shoot(c.x, c.y);
        if (f)
            left--;
        return isLoosed();
    }

    public boolean isLoosed() {
        return left <= 0;
    }

    protected abstract Ship placeShip(ShipType ship);

}
