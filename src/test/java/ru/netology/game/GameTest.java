package ru.netology.game;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;
import ru.netology.exeptions.NotRegisteredException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Player player1 = new Player(1, "Андрей", 1);
    Player player2 = new Player(2, "Иван", 2);
    Player player3 = new Player(3, "Василий", 3);
    Player player4 = new Player(4, "Николай", 4);
    Player player5 = new Player(5, "Илья", 4);
    Player player6 = new Player(6, "Дмитрий", 3);
    Player player7 = new Player(7, "Петр", 7);
    Collection<Player> playersTest = new ArrayList<>();
    Game game = new Game(playersTest);


    @Test
    void shouldAddOnePlayer() {
        game.register(player1);
        assertEquals(1, playersTest.size());
    }

    @Test
    void shouldAddSamePlayer() {
        game.register(player1);
        game.register(player2);
        assertEquals(2, playersTest.size());
    }

    @Test
    void shouldExeptionPlayer1() {
        playersTest = List.of(player1, player2, player3, player4, player5, player6, player7);
        Game game = new Game(playersTest);
        assertThrows(NotRegisteredException.class, () -> {
            game.round("Феофан", "Илья");
        });
    }

    @Test
    void shouldExeptionPlayer2() {
        playersTest = List.of(player1, player2, player3, player4, player5, player6, player7);
        Game game = new Game(playersTest);
        assertThrows(NotRegisteredException.class, () -> {
            game.round("Илья", "Феофан");
        });
    }

    @Test
    void shouldDraw() {
        playersTest = List.of(player1, player2, player3, player4, player5, player6, player7);
        Game game = new Game(playersTest);
        int actual = game.round("Николай", "Илья");
        assertEquals(0, actual);
    }

    @Test
    void shouldWinPlayer1() {
        playersTest = List.of(player1, player2, player3, player4, player5, player6, player7);
        Game game = new Game(playersTest);
        int actual = game.round("Петр", "Илья");
        assertEquals(1, actual);
    }

    @Test
    void shouldWinPlayer2() {
        playersTest = List.of(player1, player2, player3, player4, player5, player6, player7);
        Game game = new Game(playersTest);
        int actual = game.round("Василий", "Николай");
        assertEquals(2, actual);
    }


}