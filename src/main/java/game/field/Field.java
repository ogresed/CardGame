package game.field;

import game.Config;

import java.util.*;

public class Field implements FieldConstants {
    private int horizontal;
    private int vertical;
    private int numberOfDifferentCards;
    private int [][]map;
    private Random random = new Random();
    private int numberOfDeleted;
    private int fieldSize;

    public int getCell(int y, int x) {
        return map[y][x];
    }

    public Field() {
        defaultInit();
        createMap();
    }

    private Field(int hor, int ver, int differentCards) {
        if(wrongParameters(hor, ver, differentCards)) {
            throw new WrongParametersException();
        } else {
            init(hor, ver, differentCards);
        }
        createMap();
    }

    public Field(Config config) {
        this(config.getHorizontal(), config.getVertical(), config.getDifferentCards());
    }

    private void init(int hor, int ver, int differentCards) {
        horizontal = hor;
        vertical = ver;
        numberOfDifferentCards = differentCards;
        fieldSize = horizontal * vertical;
        numberOfDeleted = 0;
    }

    private void defaultInit() {
        init(MINIMAL_HORIZONTAL_SIZE, MINIMAL_VERTICAL_SIZE, MINIMAL_DIFFERENT_NUMBER)
    }

    private void createMap() {
        map = new int[vertical][horizontal];
        int[] variants = new int[numberOfDifferentCards];
        for(int i = 0; i < numberOfDifferentCards; i++) {
            variants[i] = i;
        }
        //random filing
        ArrayList<Integer> cellsList = new ArrayList<>();
        //fill list
        for(int i = 0; i < vertical; i++) {
            for(int j = 0; j < horizontal; j++) {
                cellsList.add(i * horizontal + j);
            }
        }
        while (!cellsList.isEmpty()) {
            for (int i : variants) {
                if(cellsList.isEmpty()) {
                    break;
                }
                setCell(i, cellsList);
                setCell(i, cellsList);
            }
        }
    }

    private void setCell(int variant, ArrayList<Integer> cellsList) {
        int randomPosition = Math.abs(random.nextInt()) % cellsList.size();
        Integer twoIndexesInOneValue = cellsList.get(randomPosition);
        map[twoIndexesInOneValue / horizontal][twoIndexesInOneValue % horizontal] = variant;
        cellsList.remove(randomPosition);
    }

    private boolean wrongParameters(int hor, int ver, int differentCards) {
        return (hor < MINIMAL_HORIZONTAL_SIZE || hor > MAXIMAL_HORIZONTAL_SIZE) ||
                (ver <  MINIMAL_VERTICAL_SIZE || ver > MAXIMAL_VERTICAL_SIZE) ||
                (differentCards < MINIMAL_DIFFERENT_NUMBER || differentCards > MAXIMAL_DIFFERENT_NUMBER);
    }
    
    public boolean setDeletedIfCellsIsEqualAndNotDeleted(int firstX, int firstY, int secondX, int secondY) {
        boolean cellsIsNotDeleted = (map[firstX][firstY] != DELETED && map[secondX][secondY] != DELETED);
        boolean isEqualAndDifferent = map[firstX][firstY] == map[secondX][secondY] &&
                firstX != secondX && firstY != secondY;
        boolean result = cellsIsNotDeleted && isEqualAndDifferent;
        if (result) {
            map[firstX][firstY] = map[secondX][secondY] = DELETED;
            numberOfDeleted+=2;
        }
        return result;
    }

    public int getNumberOfDeleted() {
        return numberOfDeleted;
    }

    public int getFieldSize() {
        return fieldSize;
    }
}
