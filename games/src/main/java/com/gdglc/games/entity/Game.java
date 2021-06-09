package com.gdglc.games.entity;

public class Game {
    private Integer gameId;

    private String gameName;

    private String gameType;

    private String gameCompany;

    private Integer gameYear;

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName == null ? null : gameName.trim();
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType == null ? null : gameType.trim();
    }

    public String getGameCompany() {
        return gameCompany;
    }

    public void setGameCompany(String gameCompany) {
        this.gameCompany = gameCompany == null ? null : gameCompany.trim();
    }

    public Integer getGameYear() {
        return gameYear;
    }

    public void setGameYear(Integer gameYear) {
        this.gameYear = gameYear;
    }
}