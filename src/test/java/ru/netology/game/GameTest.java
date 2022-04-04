package ru.netology.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;
import ru.netology.exeptions.NotRegisteredException;

import java.util.*;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Player player1 = new Player(1, "Андрей", 1);
    Player player2 = new Player(2, "Иван", 2);
    Player player3 = new Player(3, "Василий", 3);
    Player player4 = new Player(4, "Николай", 4);
    Player player5 = new Player(5, "Илья", 4);
    Player player6 = new Player(6, "Дмитрий", 3);
    Player player7 = new Player(7, "Петр", 7);
    public Map<String, Player> playersTest = new HashMap<>();
    Game game = new Game(playersTest);

    @BeforeEach
    public void initEach() {
        playersTest.put(player1.getName(), player1);
        playersTest.put(player2.getName(), player2);
        playersTest.put(player3.getName(), player3);
        playersTest.put(player4.getName(), player4);
        playersTest.put(player5.getName(), player5);
        playersTest.put(player6.getName(), player6);
        playersTest.put(player7.getName(), player7);
    }


    @Test
    void shouldAddOnePlayer() {
        Map<String, Player> playersTest = new HashMap<>();
        Game gameEmpty = new Game(playersTest);
        gameEmpty.register(player1);
        assertEquals(1, playersTest.size());
    }

    @Test
    void shouldAddSamePlayer() {
        Map<String, Player> playersTest = new HashMap<>();
        Game gameEmpty = new Game(playersTest);
        gameEmpty.register(player1);
        gameEmpty.register(player2);
        assertEquals(2, playersTest.size());
    }

    @Test
    void shouldExeptionPlayer1() {
        assertThrows(NotRegisteredException.class, () -> {
            game.round("Феофан", "Илья");
        });
    }

    @Test
    void shouldExeptionPlayer2() {
        assertThrows(NotRegisteredException.class, () -> {
            game.round("Илья", "Феофан");
        });
    }

    @Test
    void shouldDraw() {
        assertEquals(0, game.round("Николай", "Илья"));
    }

    @Test
    void shouldWinPlayer1() {
        assertEquals(1, game.round("Петр", "Илья"));
    }

    @Test
    void shouldWinPlayer2() {
        ;
        assertEquals(2, game.round("Василий", "Николай"));
    }


}