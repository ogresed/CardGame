package game;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

class GameTest {
    GamePrototype prototype = new GamePrototype();

    @Test
    void constructors() {
        for (int i = prototype.getFirstLevel(); i < prototype.getLastLevel(); i++) {
            try {
                new Game(i);
            } catch (RuntimeException e) {
                assertThat("this is ", equalTo("wrong case"));
            }
            assertThat("true test", equalTo("true test"));
        }
    }

    @Test
    void lastFirstLevels() {
        assertThat(prototype.getLastLevel(), equalTo(new Game(1).getLastLevel()));
        assertThat(prototype.getFirstLevel(), equalTo(new Game(1).getFirstLevel()));
    }
}