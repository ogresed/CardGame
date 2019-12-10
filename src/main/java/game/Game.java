package game;

import game.field.*;

public class Game extends GamePrototype {
    private static final int FIRST_LEVEL = 1;
    private Field field;
    private int level;

    public int fromConfigToLevel () {
        return 0;
    }

    public Config fromLevelToConfig() {
        return null;
    }

    public int getNumberOFLevels() {
        return numberOfLevels;
    }

    Game() {
        super();
        level = FIRST_LEVEL;
        field = new Field();
    }

    Game(int level) {
        super();
    }

    Game(Config config) {
        super();
    }

    Game(int horizontal, int vertical, int differentCards) {
        super();
    }

    public static void main(String[] args) {
        new Game();
    }
}
