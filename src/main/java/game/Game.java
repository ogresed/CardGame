package game;

import game.field.*;

public class Game extends GamePrototype {
    private static final int FIRST_LEVEL = 1;
    private Field field;
    private int level;

    public int fromConfigToLevel () {

    }

    public Config fromLevelToConfig() {

    }

    public int getNumberOFLevels() {

    }

    Game() {
        level = FIRST_LEVEL;
        field = new Field();
    }

    Game(int level) {

    }

    Game(Config config) {

    }

    Game(int horizontal, int vertical, int differentCards) {

    }
}
