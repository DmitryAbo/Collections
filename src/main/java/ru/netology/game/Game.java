package ru.netology.game;

import lombok.NoArgsConstructor;
import ru.netology.domain.Player;
import ru.netology.exeptions.NotRegisteredException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class Game {
    private Map<String, Player> players = new HashMap<>();

    public Game(Map<String, Player> players) {
        this.players = players;
    }

    public void register(Player player) {
        this.players.put(player.getName(), player);
    }

    public int round(String playerName1, String playerName2) {                          //Принимаю за условие что имя должно быть уникальным

        if (players.get(playerName1) == null) {
            throw new NotRegisteredException("Невозможно провести соревнование,ирок с именем " + playerName1 + " не зарегистрирован");
        }
        if (players.get(playerName2) == null) {
            throw new NotRegisteredException("Невозможно провести соревнование,ирок с именем " + playerName2 + " не зарегистрирован");
        }


        if (players.get(playerName1).getStrenght() == (players.get(playerName2).getStrenght())) {
            return 0;
        } else if (players.get(playerName1).getStrenght() > (players.get(playerName2).getStrenght())) {
            return 1;
        } else {
            return 2;
        }
    }


}
