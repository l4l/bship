package org.inno.players;

import org.inno.game.Cell;

/**
 * Created by kitsu.
 * This file is part of BattleShip in package org.inno.players.
 */
enum PlayerType {
    AIStupid(PlayerAIStupid.class),
    Human(PlayerHuman.class),
    HumanConspiracy(PlayerHumanConspiracy.class);

    final Class<? extends Player> instance;

    PlayerType(Class<? extends Player> instance) {
        this.instance = instance;
    }

    Player createPlayer(Cell[][] self, Cell[][] enemy) {
        if (enemy == null)
            return createPlayer(self);
        try {
            return this.instance.getDeclaredConstructor().newInstance(self, enemy);
        } catch (Exception e) {
            return null;
        }
    }

    Player createPlayer(Cell[][] self) {
        if (self == null)
            return createPlayer();
        try {
            return this.instance.getDeclaredConstructor().newInstance(self);
        } catch (Exception e) {
            return null;
        }
    }

    Player createPlayer() {
        try {
            return this.instance.newInstance();
        } catch (Exception e) {
            return null;
        }
    }
}
