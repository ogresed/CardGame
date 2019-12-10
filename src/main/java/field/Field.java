package field;

import java.util.*;

public class Field implements FieldConstants {
    private int horizontal;
    private int vertical;
    private int numberOfDifferentCards;
    private int [][]map;

    private void defaultInitialization() {
        horizontal = MINIMAL_HORIZONTAL_SIZE;
        vertical = MINIMAL_VERTICAL_SIZE;
        numberOfDifferentCards = MINIMAL_DIFFERENT_NUMBER;
    }

    public static void main(String[] args) {
        new Field(4,4,5);
    }

    public Field() {
        defaultInitialization();
        createMap();
    }

    public Field(int hor, int ver, int differentCards) {
        if(wrongParameters(hor, ver, differentCards)) {
            throw new WrongParametersException();
        } else {
            horizontal = hor;
            vertical = ver;
            numberOfDifferentCards = differentCards;
        }
        createMap();
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
        Random random = new Random();
        while (!cellsList.isEmpty()) {
            for (int i : variants) {
                if(cellsList.isEmpty()) {
                    break;
                }
                int randomPosition = Math.abs(random.nextInt()) % cellsList.size();
                Integer twoIndexesInOneValue = cellsList.get(randomPosition);
                map[twoIndexesInOneValue / horizontal][twoIndexesInOneValue % horizontal] = i;
                cellsList.remove(randomPosition);
            }
        }
        System.out.println(Arrays.deepToString(map));
    }

    private boolean wrongParameters(int hor, int ver, int differentCards) {
        return (hor < MINIMAL_HORIZONTAL_SIZE || hor > MAXIMAL_HORIZONTAL_SIZE) ||
                (ver <  MINIMAL_VERTICAL_SIZE || ver > MAXIMAL_VERTICAL_SIZE) ||
                (differentCards < MINIMAL_DIFFERENT_NUMBER || differentCards > MAXIMAL_DIFFERENT_NUMBER);
    }
    
    public boolean setDeletedIfCellsIsEqualAndNotDeleted(int firstX, int firstY, int secondX, int secondY)
            throws ArrayIndexOutOfBoundsException {
        boolean cellsIsNotDeleted = (map[firstX][firstY] != DELETED && map[secondX][secondY] != DELETED);
        boolean isEqual = map[firstX][firstY] == map[secondX][secondY];
        boolean result = cellsIsNotDeleted && isEqual;
        if (result) {
            map[firstX][firstY] = map[secondX][secondY] = DELETED;
        }
        return result;
    }
}
