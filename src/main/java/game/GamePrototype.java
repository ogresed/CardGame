package game;

import java.util.ArrayList;

import static game.field.FieldConstants.*;

class GamePrototype {
    int numberOfLevels;

    GamePrototype()  {
        numberOfLevels = countNumberOfLevels();
    }

    private int countNumberOfLevels() {
        ArrayList<Integer> sizeList = new ArrayList<>();
        //filling list of size
        for(int x = MINIMAL_HORIZONTAL_SIZE; x <= MAXIMAL_HORIZONTAL_SIZE; x++) {
            for(int y = MINIMAL_VERTICAL_SIZE; y <= MAXIMAL_VERTICAL_SIZE; y++) {
                int multiply = x*y;
                if(!sizeList.contains(multiply)) {
                    sizeList.add(multiply);
                }
            }
        }
        System.out.println(sizeList);
        //count of levels
        int levelsCount = 0;
        for(Integer size : sizeList) {

        }
        return 0;
    }
}
