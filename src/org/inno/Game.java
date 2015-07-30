package org.inno;

import org.inno.game.Cell;
import org.inno.game.Coord;
import org.inno.players.Player;
import org.inno.players.PlayerAIStupid;
import org.inno.players.PlayerHuman;
import org.inno.util.Console;
import org.inno.util.SerializerManager;

/**
 * Created by kitsu.
 * This file is part of BattleShip in package org.inno.
 */
public class Game implements java.io.Serializable {
    Player player1;
    Player player2;

    private static Game game;

    public Game() {
        player1 = new PlayerHuman();
        player2 = new PlayerAIStupid();
    }

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public static void main(String[] args) {
        game = new Game();
        boolean cont;
        do {
            cont = false;
            try {
                game.run();
            } catch (Exception e) {
                cont = true;
            }
        } while (cont);

    }

    public void run() throws Exception {

        do {
            do Console.getInstace().printMaps(player1::getSelfCell, player1::getEnemyCell);
//            do Console.printMap(player1::getEnemyCell);
            while (move(player1, player2));
            while (move(player2, player1));
        } while (!player1.isLoosed() && !player2.isLoosed());

        Console.getInstace().notifyWinner(player1.isLoosed());
    }

    public boolean move(Player p1, Player p2) throws Exception {
        Coord c = p1.move();
        if (c.x == -1 && c.y == -1)
            SerializerManager.save(this, "save.dat");
        else if (c.x == -2 && c.y == -1) {
            game = SerializerManager.restore("save.dat");
            throw new Exception("Restoring");
        }
        Cell cell = p2.getSelfCell(c.x, c.y) == Cell.SHIP ? Cell.BURN : Cell.SHOT;
        p1.setEnemyCell(c, cell);
        boolean isMissed = p2.destroy(c);
        Console.getInstace().printMove(c, isMissed);
        return isMissed;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
