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

    private final static char[] LEFT_BORDER = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'K'};

    private static void printLeftBorder(int line) {
        out.print(LEFT_BORDER[line]);
    }

    private static void printBorderDouble(int delimSize) {
        printBorder();
        delimSize -= 2;
        while (delimSize-- > 0)
            printBorderSym();
        printBorder();
    }

    private static void printBorder() {
        printBorderSym();
        for (int i = 0; i < Sea.SEA_DEFAULT_SIZE; i++) {
            out.print(i);
        }
        printBorderSym();
    }

    private static void printBorderSym() {
        out.print('#');
    }

    public static void printMaps(Cellable<Integer, Cell> p1, Cellable<Integer, Cell> p2) {
        if (p1 == null || p2 == null)
            return;
        out.println("Playing map is:\n");
        final String space = " || ";
        printBorderDouble(space.length());
        out.println();
        for (int i = 0; i < Sea.SEA_DEFAULT_SIZE; i++) {
            printLeftBorder(i);
            printLine(p1, i);
            out.print(space);
            printLine(p2, i);
            printLeftBorder(i);
            out.println();
        }
        printBorderDouble(space.length());
        out.println();
    }

    public static void printMap(Cellable<Integer, Cell> f) {
        if (f == null)
            return;
        out.println("Current map is:\n");
        printBorder();
        out.println();
        for (int i = 0; i < Sea.SEA_DEFAULT_SIZE; i++) {
            printLeftBorder(i);
            printLine(f, i);
            printLeftBorder(i);
            out.println();
        }
        printBorder();
        out.println();
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
        out.println("Write down the coordinate");
        String s = in.next();
        if (s.charAt(0) == 's')
            return new Coord(-1, -1);
        else if(s.charAt(0) == 'l')
            return new Coord(-2, -2);
        int x, y;
        for (x = 0; x < LEFT_BORDER.length; x++) {
            if (LEFT_BORDER[x] == s.charAt(0))
                break;
        }
        x = x == LEFT_BORDER.length ? 0 : x;
        y = s.charAt(1) - '0';
        y = y < 0 || y >= Sea.SEA_DEFAULT_SIZE ? 0 : y;
        return new Coord(x, y);
    }

    public static boolean readPlacement() {
        out.println("Should your ship placed up-to-down or left-to-right? U/L");
        return in.next().toUpperCase().equals("U");
    }

    public static void printMove(Coord c, boolean b) {
        out.println("Move is:");
        out.println(LEFT_BORDER[c.x] + "" + c.y);
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
