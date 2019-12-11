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
        String wrongThrowingTest = "wrong";
        String trueThrowingTest = "true";
        String expected = trueThrowingTest;
        try {
            for (int level = prototype.getFirstLevel(); level < prototype.getLastLevel(); level++) {
                Game game = new Game(level);
                pointsValues(game, true, true);
                cellsAccess(game);
                nextLevel(game);
            }
        } catch (Exception e) {
            expected = wrongThrowingTest;
        }
        finally {
            assertThat(expected, equalTo(trueThrowingTest));
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
        assertThat(game.levelIsOver(), equalTo(true));
        pointsValues(game, false, false);
        game.nextLevel();
        pointsValues(game, true, false);
        assertThat(game.gameIsOver(), equalTo(game.getLevel() == game.lastLevel));
    }

    private void checkWithSecondCell(int y, int x, Game game) {
        Config config = game.getConfig();
        assertThat(game.toAddPoints(x, y, x, y), equalTo(false));
        for (int i = y; i < config.getVertical(); i++) {
            for(int j = x; j < config.getHorizontal(); j++) {
                game.toAddPoints(x, y, i, j);
            }
        }
    }
}