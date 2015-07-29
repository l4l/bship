package org.inno.util;

import org.inno.game.*;
import org.inno.players.Player;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by kitsu.
 * This file is part of BattleShip in package org.inno.
 */
public final class Console {

    private final static PrintStream out = System.out;
    private final static Scanner in = new Scanner(System.in);

    private static void printBorder(int size) {
        for (int i = 0; i < size; i++)
            printBorderSym();
        out.println();
    }

    private static void printBorderSym() {
        out.print('#');
    }

    public static void printMaps(Cellable<Integer, Cell> p1, Cellable<Integer, Cell> p2) {
        out.println("Playing map is:\n");
        final String space = " || ";
        printBorder(2*Sea.SEA_DEFAULT_SIZE + space.length() + 2);
        for (int i = 0; i < Sea.SEA_DEFAULT_SIZE; i++) {
            printBorderSym();
            printLine(p1, i);
            out.print(space);
            printLine(p2, i);
            printBorderSym();
            out.println();
        }
        printBorder(2*Sea.SEA_DEFAULT_SIZE + 6);
    }

    public static void printMap(Cellable<Integer, Cell> f) {
        out.println("Current map is:\n");
        printBorder(Sea.SEA_DEFAULT_SIZE + 2);
        for (int i = 0; i < Sea.SEA_DEFAULT_SIZE; i++) {
            printBorderSym();
            printLine(f, i);
            printBorderSym();
            out.println();
        }
        printBorder(Sea.SEA_DEFAULT_SIZE + 2);
        out.println('\n');
    }

    private static void printLine(Cellable<Integer, Cell> f, int i) {
        for (int j = 0; j < Sea.SEA_DEFAULT_SIZE; j++) {
            out.print(f.getCell(i, j).sym);
        }
    }

    public static void greetingToPlaceShip(ShipType ship) {
        out.println("Place ship " + ship.name());
    }

    public static Coord readCoord() {
        out.println("Print coordinates x and y");
        return new Coord(in.nextInt(), in.nextInt());
    }

    public static boolean readPlacement() {
        out.println("Should your ship placed up-to-down or left-to-right? U/L");
        return in.next().toUpperCase().equals("U");
    }

    public static void printMove(Coord c, boolean b) {
        out.println("Move is:");
        out.println("X: " + c.x + " Y: " + c.y);
        out.println("Result is: " + (b ? "success" : "missed"));
    }

    public static boolean readMissed() {
        out.println("Am I right? Y/N");
        return in.next().toUpperCase().equals("Y");
    }

    public static void notifyErrorPlacement() {
        out.print("Your input is wrong, dammit user!");
    }

    public static void notifyGoodPlacement(Cellable<Integer, Cell> f) {
        out.println("Well done!\n\n");
        printMap(f);
    }

    public static void notifyWinner(boolean isFirstWinner) {
        String w = "Player 1", l = "Player 2";
        if (!isFirstWinner) {
            String t = w;
            w = l;
            l = t;
        }

        out.println(w + " is a winner!\nAnd loser one is " + l);
    }
}
