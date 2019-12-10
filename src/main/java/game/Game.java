package game;

import game.field.*;

public class Game extends GamePrototype {
    private Field field;
    private int level;

    public int getLastLevel() {
        return lastLevel;
    }

    public Game() {
        super();
        level = FIRST_LEVEL;
        field = new Field();
    }

    public Game(int level) {
        super();
        this.level = level;
        Config config = fromLevelToConfig(level);
        field = new Field(config);
    }

    public Game(Config config) {
        super();
        this.level = fromConfigToLevel(config);
        field = new Field(config);
    }

    public Game(int horizontal, int vertical, int differentCards) {
        super();
        Config config = new Config(horizontal, vertical, differentCards);
        level = fromConfigToLevel(config);
        field = new Field(config);
    }

    public static void main(String[] args) {
        new Game(11);
    }
}
