package org.inno;

import java.util.function.Consumer;

/**
 * Created by kitsu.
 * This file is part of BattleShip in package org.inno.
 */
public abstract class Player {

    protected Sea self;
    protected Sea enemy;

    {
        for (int i = 0; i < Ship.BATTLESHIP_NUM; i++)
            if (!self.addShip(this.placeShip(ShipType.BATTLESHIP)))
                i--;
        for (int i = 0; i < Ship.FRIGATE_NUM; i++)
            if (!self.addShip(this.placeShip(ShipType.FRIGATE)))
                i--;
        for (int i = 0; i < Ship.CRUISER_NUM; i++)
            if (!self.addShip(this.placeShip(ShipType.CRUISER)))
                i--;
        for (int i = 0; i < Ship.BOAT_NUM; i++)
            if (self.addShip(this.placeShip(ShipType.BOAT)))
                i--;
    }

    public abstract void move(Consumer consumer);

    public abstract Ship placeShip(ShipType ship);

}
