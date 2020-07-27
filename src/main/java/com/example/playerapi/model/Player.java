package com.example.playerapi.model;

import java.util.Objects;

public class Player {
    private String playerId;
    private String playerName;
    private String playerEmail;

    public Player(String playerId, String playerName, String playerEmail) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerEmail = playerEmail;
    }

    public String getPlayerId() {
        return this.playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerEmail() {
        return this.playerEmail;
    }

    public void setPlayerEmail(String playerEmail) {
        this.playerEmail = playerEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Player)) {
            return false;
        }
        Player player = (Player) o;
        return Objects.equals(playerId, player.playerId) && Objects.equals(playerName, player.playerName) && Objects.equals(playerEmail, player.playerEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, playerName, playerEmail);
    }

    @Override
    public String toString() {
        return "{" +
            " playerId='" + getPlayerId() + "'" +
            ", playerName='" + getPlayerName() + "'" +
            ", playerEmail='" + getPlayerEmail() + "'" +
            "}";
    }

}