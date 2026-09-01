package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {

    Player player1 = new Player(1, "Альфа", 100);
    Player player2 = new Player(2, "Бета", 200);
    Player player3 = new Player(3, "Гамма", 100);
    Player player4 = new Player(4, "Дельта", 300);

    Game manager = new Game();

    @BeforeEach
    public void add() {
        manager.registered(player1);
        manager.registered(player2);
        manager.registered(player3);
    }

    @Test
    public void strengthPlayerTestRegisteredPlayer() {
        int expected = 200;
        int actual = manager.getStrengthPlayer("Бета");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void strengthPlayerTestNoRegisteredPlayer() {
        int expected = -1;
        int actual = manager.getStrengthPlayer("Дельта");
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void checkRegisteredTest() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            manager.checkRegistered("Дельта");
        });
    }

    @Test
    public void roundTestBigger() {
        int expected = 1;
        int actual = manager.round("Бета", "Гамма");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundTestLess() {
        int expected = 2;
        int actual = manager.round("Альфа","Бета");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundTestEquals() {
        int expected = 0;
        int actual = manager.round("Альфа","Гамма");
        Assertions.assertEquals(expected, actual);
    }
}