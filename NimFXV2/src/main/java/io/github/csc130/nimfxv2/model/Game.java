/**
 * @author Xander
 * @createdOn 1/22/2023 at 8:53 PM
 * @projectName NimFXV2
 * @packageName io.github.csc130.nimfxv2.model;
 */
package io.github.csc130.nimfxv2.model;

public class Game {
    Player playerOne, playerTwo;
    GameType gameType;
    int gameDifficultyType;

    public Game() {
    }

    public Game(String firstPlayerName, String secondPlayerName, String typeOfGame, String gameDifficulty) {
        switch (typeOfGame) {
            case "Player Versus Player" -> {
                playerOne = new PlayerHuman(firstPlayerName);
                playerTwo = new PlayerHuman(secondPlayerName);
                gameType = GameType.PVP;

            }
            case "Player Versus Computer" -> {
                playerOne = new PlayerHuman(firstPlayerName);
                playerTwo = new PlayerAI(secondPlayerName);
                gameType = GameType.PVC;
            }
            case "Computer Versus Computer" -> {
                playerOne = new PlayerAI(firstPlayerName);
                playerTwo = new PlayerAI(secondPlayerName);
                gameType = GameType.CVC;
            }
        }
        switch(gameDifficulty) {
            case "Easy" -> gameDifficultyType = 3;
            case "Medium" -> gameDifficultyType = 5;
            case "Hard" -> gameDifficultyType = 8;
        }
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public int getGameDifficultyType() {
        return gameDifficultyType;
    }

    public void setGameDifficultyType(int gameDifficultyType) {
        this.gameDifficultyType = gameDifficultyType;
    }

    @Override
    public String toString() {
        return "Game{" + "playerOne=" + playerOne + ", playerTwo=" + playerTwo + ", gameType=" + gameType + ", gameDifficultyType=" + gameDifficultyType + '}';
    }

    enum GameType {
        PVP, PVC, CVC
    }

    enum GameDifficulty {
        EASY, MEDIUM, HARD
    }
}
