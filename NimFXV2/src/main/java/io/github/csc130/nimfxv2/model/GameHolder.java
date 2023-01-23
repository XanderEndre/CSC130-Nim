/**
 * @author Xander
 * @createdOn 1/22/2023 at 9:27 PM
 * @projectName NimFXV2
 * @packageName io.github.csc130.nimfxv2.model;
 */
package io.github.csc130.nimfxv2.model;

public class GameHolder {

    private final static GameHolder INSTANCE = new GameHolder();
    private Game game;

    public GameHolder() {
    }

    public static GameHolder getInstance() {
        return INSTANCE;
    }

    public Game getGame() {
        return this.game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

}
