package org.inno;

/**
 * Created by kitsu.
 * This file is part of BattleShip in package org.inno.
 */
public class Main {
    static Player player1 = new PlayerHuman();
    static Player player2 = new PlayerAIStupid();

    static {
        Player.init(player1);
        Player.init(player2);
    }

    public static void main(String[] args) {

        do {
            if (move(player1, player2))
                break;
            else if (move(player2, player1))
                break;
        } while (true);

        Console.notifyWinner(player1.isLoosed());
    }

    public static boolean move(Player p1, Player p2) {
        Coord c = p1.move();
        return p2.destroy(c);
    }
}