package game;

import game.field.*;

public class Game extends GamePrototype {
    private Field field;
    private int level;
    private Config config;
    private int globalPoints = 0;
    private int currentLevelPoints = 0;

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

    public int getLevel() {
        return level;
    }

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

    public int getCell(int y, int x) {
        return field.getCell(y, x);
    }

    public int [] getVariants() {
        int[] variants = new int[config.getDifferentCards()];
        for(int i = 0; i < config.getDifferentCards(); i++) {
            variants[i] = i;
        }
        return variants;
    }

    public boolean levelIsOver() {
        return field.getFieldSize() == field.getNumberOfDeleted();
    }

    public boolean gameIsOver() {
        return levelIsOver() && level == lastLevel;
    }

    /**
     * if cells in same position return false
     * if cells is deleted return false
     * is cells is in different position but have a same values return true
     * */
    public boolean toAddPoints(int firstX, int firstY, int secondX, int secondY) {
        boolean retValue =  field.setDeletedIfCellsIsEqualAndNotDeleted (
                firstX,
                firstY,
                secondX,
                secondY
        );
        if(retValue) {
            currentLevelPoints += additionPoints();
        }
        return retValue;
    }

    private int additionPoints() {
        return level;
    }

    /**
     * if level is last nothing to change
     * */
    public void nextLevel() {
        if(level != lastLevel) {
            globalPoints += currentLevelPoints;
            level++;
            field = new Field(fromLevelToConfig(level));
        }
    }
}
