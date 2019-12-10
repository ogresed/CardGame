package game;

import java.util.HashMap;

import static game.field.FieldConstants.*;

class GamePrototype {
    static final int FIRST_LEVEL = 1;
    private final int numberOfLevels;
    private final int shift;
    private final int maxDifficult;
    private final int minDifficult;
    final int lastLevel;
    private HashMap<Integer, Config> levelsMap;

    GamePrototype()  {
        maxDifficult = MAXIMAL_HORIZONTAL_SIZE * MAXIMAL_VERTICAL_SIZE * MAXIMAL_DIFFERENT_NUMBER;
        minDifficult = MINIMAL_HORIZONTAL_SIZE * MINIMAL_VERTICAL_SIZE * MINIMAL_DIFFERENT_NUMBER;
        shift = shiftCount();
        numberOfLevels = countNumberOfLevels();
        lastLevel = numberOfLevels + 1;
        levelsMap = createLevelsMap();
    }

    private HashMap<Integer, Config> createLevelsMap() {
        HashMap<Integer, Config> map = new HashMap<>();

        Config previous = new Config(0,0,0);
        for(int level = FIRST_LEVEL; level <= lastLevel; level++) {
            double gameDifficult = level * 1.0 * shift;
            double levelWeight = (maxDifficult) / gameDifficult;

            int horizontal = createValue(MAXIMAL_HORIZONTAL_SIZE, MINIMAL_HORIZONTAL_SIZE, levelWeight);
            int vertical = createValue(MAXIMAL_VERTICAL_SIZE, MINIMAL_VERTICAL_SIZE, levelWeight);
            int differentCards = createValue(MAXIMAL_DIFFERENT_NUMBER, MINIMAL_DIFFERENT_NUMBER, levelWeight);

            if((horizontal * vertical) % 2 == 1) {
                horizontal--;
            }
            Config current = new Config(horizontal, vertical, differentCards);

            if(previous.equals(current)) {
                if(current.getDifferentCards() < MAXIMAL_DIFFERENT_NUMBER) {
                    current.setDifferentCards(current.getDifferentCards() + 1);
                }
            }
            map.put(level, current);
            previous = current;
        }
        return map;
    }

    private int shiftCount() {
        int minimalNumberOfPairs = MINIMAL_HORIZONTAL_SIZE * MINIMAL_VERTICAL_SIZE / 2;
        int shift = MINIMAL_HORIZONTAL_SIZE * MINIMAL_VERTICAL_SIZE *(MAXIMAL_DIFFERENT_NUMBER - minimalNumberOfPairs);
        //System.out.println(shift);
        return shift;
    }

    private int countNumberOfLevels() {
        int levels = 0;
        levels = (maxDifficult - minDifficult) /
        //_____________________________________________
                                shift;
        /*System.out.println(levels );
        System.out.println(maxDifficult);
        System.out.println(minDifficult);*/
        return levels;
    }

    private int fromConfigToLevel(int horizontal, int vertical, int differentCards) {
        int ret = horizontal * vertical * differentCards / shift;
        return ret <= 0 ? FIRST_LEVEL : ret;
    }

    int fromConfigToLevel(Config config) {
        return fromConfigToLevel(config.getHorizontal(), config.getVertical(), config.getDifferentCards());
    }

    Config fromLevelToConfig(int level) {
        if(level > numberOfLevels) {
            level = numberOfLevels;
        }
        if(level < FIRST_LEVEL) {
            level = FIRST_LEVEL;
        }
        return levelsMap.get(level);
    }

    private int createValue(int maxVal, int minVal, double levelWeight) {
        return  (int) ((maxVal - minVal) / levelWeight) + minVal;
    }

    public int getFirstLevel() {
        return FIRST_LEVEL;
    }

    public int getLastLevel() {
        return lastLevel;
    }
}
