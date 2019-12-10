package game;

import static game.field.FieldConstants.*;

class GamePrototype {
    int numberOfLevels;
    private int shift;
    private int maxDifficult;
    private int minDifficult;

    GamePrototype()  {
        maxDifficult = MAXIMAL_HORIZONTAL_SIZE * MAXIMAL_VERTICAL_SIZE * MAXIMAL_DIFFERENT_NUMBER;
        minDifficult = MINIMAL_HORIZONTAL_SIZE * MINIMAL_VERTICAL_SIZE * MINIMAL_DIFFERENT_NUMBER;
        shift = shiftCount();
        numberOfLevels = countNumberOfLevels();
    }

    private int shiftCount() {
        int minimalNumberOfPairs = MINIMAL_HORIZONTAL_SIZE * MINIMAL_VERTICAL_SIZE / 2;
        int shift = MINIMAL_HORIZONTAL_SIZE * MINIMAL_VERTICAL_SIZE *(MAXIMAL_DIFFERENT_NUMBER - minimalNumberOfPairs);
        System.out.println(shift);
        return shift;
    }

    private int countNumberOfLevels() {
        int levels = 0;
        levels = (maxDifficult - minDifficult) /
        //_____________________________________________
                                shift;
        System.out.println(levels );
        System.out.println(maxDifficult);
        System.out.println(minDifficult);
        return levels;
    }

    private int fromConfigToLevel(int horizontal, int vertical, int differentCards) {
        return horizontal * vertical * differentCards / shift;
    }

    int fromConfigToLevel(Config config) {
        return fromConfigToLevel(config.getHorizontal(), config.getVertical(), config.getDifferentCards());
    }

    public Config fromLevelToConfig(int level) {
        double gameDifficult = level * 1.0 * shift;
        double levelWeight = (maxDifficult) / gameDifficult;

        int horizontal = createValue(MAXIMAL_HORIZONTAL_SIZE, MINIMAL_HORIZONTAL_SIZE, levelWeight);
        int vertical = createValue(MAXIMAL_VERTICAL_SIZE, MINIMAL_VERTICAL_SIZE, levelWeight);
        int differentCards = createValue(MAXIMAL_DIFFERENT_NUMBER, MINIMAL_DIFFERENT_NUMBER, levelWeight);
        return new Config(horizontal, vertical, differentCards);
    }

    private int createValue(int maxVal, int minVal, double levelWeight) {
        return  (int) ((maxVal - minVal) / levelWeight) + minVal;
    }

    public int getNumberOfLevels() {
        return numberOfLevels;
    }
}
