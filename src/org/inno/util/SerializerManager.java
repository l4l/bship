package org.inno.util;

import org.inno.Game;
import org.inno.game.Cell;
import org.inno.players.*;

import java.io.*;

/**
 * Created by kitsu.
 * This file is part of BattleShip in package org.inno.util.
 */
public class SerializerManager {

    public static void save(Game game, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(game.getPlayer1());
            out.writeObject(game.getPlayer2());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    public static Game restore(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))){
            Player p1 = (Player) in.readObject(), p2 = (Player) in.readObject();
            return new Game(p1, p2);
        } catch (Exception e) {
            return null;
        }
    }

}
