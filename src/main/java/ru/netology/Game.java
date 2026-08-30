package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public List<Player> players = new ArrayList<>();

    public void registered(Player player) {
        players.add(player);
    }

    public void checkRegistered(String name) {
        String noname = null;
        for (Player player : players) {
            if (player.getName().equals(name)) {
                noname = name;
            }
        }
        if (noname == null) {
            throw new NotRegisteredException(" Игрок " + name + " не зарегистрирован");
        }
    }

    public int getStrengthPlayer(String name) {
        int strength = 0;
        for (Player player : players) {
            if (player.getName().equals(name)) {
                strength = player.getStrength();
            }
        }
        return strength;
    }

    public int round(String playerName1, String playerName2) {
        checkRegistered(playerName1);
        checkRegistered(playerName2);
        if (getStrengthPlayer(playerName1) > getStrengthPlayer(playerName2)) {
            return 1;
        } else {
            if (getStrengthPlayer(playerName1) < getStrengthPlayer(playerName2)) {
                return 2;
            } else {
                return 0;
            }
        }
    }
}
