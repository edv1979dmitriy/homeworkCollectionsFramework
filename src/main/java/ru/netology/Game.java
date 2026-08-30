package ru.netology;

import java.util.HashMap;

public class Game {

//    public List<Player> players = new ArrayList<>();
    public HashMap<String, Player> players = new HashMap<>();

    public void registered(String name, Player player) {
        players.put(name, player);
    }

    public void checkRegistered(String name) {
        String noname = null;
        for (String player : players.keySet()) {
            if (player.equals(name)) {
                noname = name;
            }
        }
        if (noname == null) {
            throw new NotRegisteredException(" Игрок " + name + " не зарегистрирован");
        }
    }

    public int getStrengthPlayer(String name) {
        int strength = 0;
        for (String map : players.keySet()) {
            if (map.equals(name)) {
                Player player = players.get(name);
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
