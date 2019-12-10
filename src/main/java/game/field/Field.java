package game.field;

import java.util.*;

public class Field implements FieldConstants {
    private int horizontal;
    private int vertical;
    private int numberOfDifferentCards;
    private int [][]map;
    private Random random = new Random();


    public Field() {
        defaultInitialization();
        createMap();
    }

    public Field(int hor, int ver, int differentCards) {
        if(wrongParameters(hor, ver, differentCards)) {
            throw new WrongParametersException();
        } else {
            initializationWithAlignment(hor, ver);
            numberOfDifferentCards = differentCards;
        }
        createMap();
    }

    private void defaultInitialization() {
        initializationWithAlignment(MINIMAL_HORIZONTAL_SIZE, MINIMAL_VERTICAL_SIZE);
        numberOfDifferentCards = MINIMAL_DIFFERENT_NUMBER;
    }

    private void initializationWithAlignment(int horizontalSize, int verticalSize) {
        horizontal = horizontalSize + (horizontalSize % 2);
        vertical = verticalSize + (verticalSize % 2);
    }

    private void createMap() {
        map = new int[horizontal][vertical];
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
        if(cellsList.size() % 2 == 0) {
            System.out.println("Hoorhaa");
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
        boolean isEqual = map[firstX][firstY] == map[secondX][secondY];
        boolean result = cellsIsNotDeleted && isEqual;
        if (result) {
            map[firstX][firstY] = map[secondX][secondY] = DELETED;
        }
        return result;
    }
}
