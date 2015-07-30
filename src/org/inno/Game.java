package org.inno;

import org.inno.game.Cell;
import org.inno.game.Coord;
import org.inno.players.Player;
import org.inno.players.PlayerAIStupid;
import org.inno.players.PlayerHuman;
import org.inno.util.Console;

/**
 * Created by kitsu.
 * This file is part of BattleShip in package org.inno.
 */
public class Game implements java.io.Serializable {
    Player player1;
    Player player2;

    public Game() {
        player1 = new PlayerHuman();
        player2 = new PlayerAIStupid();
    }

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public static void main(String[] args) {
        new Game().run();
    }

    public void run() {

        do {
            do Console.printMaps(player1::getSelfCell, player1::getEnemyCell);
//            do Console.printMap(player1::getEnemyCell);
            while (move(player1, player2));
            while (move(player2, player1));
        } while (!player1.isLoosed() && !player2.isLoosed());

        Console.notifyWinner(player1.isLoosed());
    }

    public boolean move(Player p1, Player p2) {
        Coord c = p1.move();
        Cell cell = p2.getSelfCell(c.x, c.y) == Cell.SHIP ? Cell.BURN : Cell.SHOT;
        p1.setEnemyCell(c, cell);
        boolean isMissed = p2.destroy(c);
        Console.printMove(c, isMissed);
        return isMissed;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
