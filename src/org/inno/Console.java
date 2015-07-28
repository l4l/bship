package org.inno;

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
        System.out.println();
    }
    private static void printBorderSym() {
        System.out.print('#');
    }

    public static void printMap(Cellable<Integer, Cell> f, int size) {
        printBorder(size + 2);
        for (int i = 0; i < size; i++) {
            printBorderSym();
            for (int j = 0; j < size; j++) {
                System.out.print(f.getCell(j, i).sym);
            }
            printBorderSym();
            System.out.println();
        }
        printBorder(size + 2);
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

    public static void notifyErrorPlacement() {
        out.print("Your input is wrong, dammit user!");
    }

    public static void notifyGoodPlacement(Cellable<Integer, Cell> f, int size) {
        out.println("Well done!\n\nCurrent map is:\n");
        printMap(f, size);
    }

    public static void notifyWinner(boolean isFirstWinner) {
        String w = "Player 1", l = "Player 2";
        if (!isFirstWinner) {
            String t = w;
            w = l;
            l = t;
        }
        out.println(w + " is a winner!\n And loser on is " + l);
    }
}
