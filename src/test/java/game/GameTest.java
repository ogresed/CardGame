package game;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

class GameTest {
    private GamePrototype prototype = new GamePrototype();

    @Test
    void constructors() {
        String wrongThrowingTest = "wrong";
        String trueThrowingTest = "true";
        String expected = trueThrowingTest;
        try {
            for (int i = prototype.getFirstLevel(); i < prototype.getLastLevel(); i++) {
                new Game(i);
            }
        } catch (Exception e) {
            expected = wrongThrowingTest;
        }
        finally {
            assertThat(expected, equalTo(trueThrowingTest));
        }
    }

    @Test
    void lastFirstLevels() {
        assertThat(prototype.getLastLevel(), equalTo(new Game(1).getLastLevel()));
        assertThat(prototype.getFirstLevel(), equalTo(new Game(1).getFirstLevel()));
    }

    @Test
    void globalGameTest() {
        Game game = new Game(1);
        while (game.getLevel() <= game.getLastLevel() && !game.gameIsOver()) {
            pointsValues(game, true, game.getLevel() == game.getFirstLevel());
            cellsAccess(game);
            nextLevel(game);
        }
    }

    void pointsValues(Game game, boolean currentIsNull, boolean globalIsNull) {
        if (currentIsNull) {
            assertThat(game.getCurrentLevelPoints(), equalTo(0));
        } else {
            assertThat(game.getCurrentLevelPoints(), not(0));
        }
        if (globalIsNull) {
            assertThat(game.getGlobalPoints(), equalTo(0));
        } else {
            assertThat(game.getGlobalPoints(), not(0));
        }

    }

    void cellsAccess (Game game) {
        Config config = game.getConfig();
        for (int i = 0; i < config.getVertical(); i++) {
            for(int j = 0; j < config.getHorizontal(); j++) {
                assertThat(game.getCell(i, j), greaterThan(-1));
            }
        }
    }

    private void nextLevel(Game game) {
        assertThat(game.levelIsOver(), equalTo(false));
        Config config = game.getConfig();
        for (int i = 0; i < config.getVertical(); i++) {
            for(int j = 0; j < config.getHorizontal(); j++) {
                checkWithSecondCell(i, j, game);
            }
        }

        pointsValues(game, false, game.getLevel() == game.getFirstLevel());
        assertThat(game.levelIsOver(), equalTo(true));
        game.nextLevel();
        if(game.getLevel() != game.getLastLevel()) {
            pointsValues(game, true, false);
        }
        if(game.levelIsOver()) {
            assertThat(game.getLevel(), equalTo( game.lastLevel));
        }
    }

    private void checkWithSecondCell(int y, int x, Game game) {
        Config config = game.getConfig();
        assertThat(game.toAddPoints(y, x, y, x), equalTo(false));
        for (int i = 0; i < config.getVertical(); i++) {
            for(int j = 0; j < config.getHorizontal(); j++) {
               game.toAddPoints(y, x, i, j);
            }
        }
    }
}