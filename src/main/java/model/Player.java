package model;

public class Player {
    Integer id;
    String playerName;
    String playerDesc;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerDesc() {
        return this.playerDesc;
    }

    public void setPlayerDesc(String playerDesc) {
        this.playerDesc = playerDesc;
    }

}