package ru.netology.game;

import ru.netology.domain.Player;
import ru.netology.exeptions.NotRegisteredException;

import java.util.ArrayList;
import java.util.Collection;


public class Game {
    private Collection<Player> players = new ArrayList<>();

    public Game(Collection<Player> players) {
        this.players = players;
    }

    public void register(Player player) {
        this.players.add(player);
    }

    public int round(String playerName1, String playerName2) {                          //Принимаю за условие что имя должно быть уникальным
        Player player1 = new Player();
        Player player2 = new Player();
        int result;

        for (Player roundPlayers : players.toArray(new Player[0])) {
            if (roundPlayers.getName().equals(playerName1)) {
                player1 = roundPlayers;
            }
            if (roundPlayers.getName().equals(playerName2)) {
                player2 = roundPlayers;
            }
        }

        if (player1.getName() == null) {
            throw new NotRegisteredException("Невозможно провести соревнование,ирок с именем " + playerName1 + " не зарегистрирован");
        }
        if (player2.getName() == null) {
            throw new NotRegisteredException("Невозможно провести соревнование,ирок с именем " + playerName2 + " не зарегистрирован");
        }


        if (player1.getStrenght() == player2.getStrenght()) {
            result = 0;
        } else if (player1.getStrenght() > player2.getStrenght()) {
            result = 1;
        } else {
            result = 2;
        }
        return result;
    }


}
