package game;

import game.field.*;

public class Game extends GamePrototype {
    private Field field;
    private int level;
    private Config config;
    private int globalPoints = 0;
    private int currentLevelPoints = 0;

    public int getGlobalPoints() {
        return globalPoints;
    }

    public int getCurrentLevelPoints() {
        return currentLevelPoints;
    }

    @Override
    public int getLastLevel() {
        return lastLevel;
    }

    public Config getConfig() {
        return config;
    }

    public int getCell(int x, int y) {
        return field.getCell(x, y);
    }

    public boolean levelIsOver() {
        return field.getFieldSize() == field.getNumberOfDeleted();
    }

    public void nextLevel() {
        globalPoints += currentLevelPoints;
        level++;
        field = new Field(fromLevelToConfig(level));
    }

    public boolean setDeletedIfCellsIsEqualAndNotDeleted(int firstX,
                                                         int firstY,
                                                         int secondX,
                                                         int secondY) {
        boolean addPoints =  field.setDeletedIfCellsIsEqualAndNotDeleted(
                firstX,
                firstY,
                secondX,
                secondY
        );
        if(addPoints) {
            currentLevelPoints += addPoints();
        }
        return addPoints;
    }

    public boolean gameIsOver() {
        return levelIsOver() && level == lastLevel;
    }

    private int addPoints() {
        return level;
    }

    public Game() {
        super();
        level = FIRST_LEVEL;
        config = fromLevelToConfig(level);
        field = new Field();
    }

    public Game(int level) {
        super();
        this.level = level;
        config = fromLevelToConfig(level);
        field = new Field(config);
    }

    public Game(Config config) {
        super();
        this.level = fromConfigToLevel(config);
        this.config = config;
        field = new Field(config);
    }

    public Game(int horizontal, int vertical, int differentCards) {
        super();
        config = new Config(horizontal, vertical, differentCards);
        level = fromConfigToLevel(config);
        field = new Field(config);
    }
}
