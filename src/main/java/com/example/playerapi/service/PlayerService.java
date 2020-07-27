package com.example.playerapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.example.playerapi.model.Player;

import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    // initially the playerList is empty and as values are added it gets filled
    List<Player> playerList = new ArrayList<>();

    private Player filterPlayers(Predicate<Player> strategy) {
        return playerList.stream().filter(strategy).findFirst().orElse(null);
    }

    public List<Player> getAllPlayers() {
        return playerList;
    }

    public Player getPlayerDetailsById(String pId) {
        Predicate<Player> byId = p -> p.getPlayerId().equals(pId);
        return filterPlayers(byId);
    }

    public Player addPlayer(Player player) {
        playerList.add(player);
        return player;
    }

    public Player updatePlayerById(String pId, Player updatedPlayerDetails) {
        Predicate<Player> byId = p -> p.getPlayerId().equals(pId);
        Player oldPlayer = filterPlayers(byId);

        oldPlayer.setPlayerId(updatedPlayerDetails.getPlayerId());
        oldPlayer.setPlayerName(updatedPlayerDetails.getPlayerName());
        oldPlayer.setPlayerEmail(updatedPlayerDetails.getPlayerEmail());

        return oldPlayer;
    }

    public void deletePlayer(String pId) {
        Predicate<Player> byId = p -> p.getPlayerId().equals(pId);
        Player playerToDelete = filterPlayers(byId);

        playerList.remove(playerToDelete);
    }
}