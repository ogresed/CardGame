package game;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static game.field.FieldConstants.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class GamePrototypeTest {
    private int sizeOfConfigs = 10;
    private GamePrototype prototype = new GamePrototype();
    private Config[] configs = new  Config[sizeOfConfigs];
    private Random random = new Random();

    @Before
    public void setUp() {
        for (int i= 0; i < sizeOfConfigs; i++) {
            configs[i] = new Config (
                  random.nextInt() % (MAXIMAL_HORIZONTAL_SIZE - MINIMAL_HORIZONTAL_SIZE) + MINIMAL_HORIZONTAL_SIZE,
                    random.nextInt() % (MAXIMAL_VERTICAL_SIZE - MINIMAL_VERTICAL_SIZE) + MINIMAL_VERTICAL_SIZE,
                    random.nextInt() % (MAXIMAL_DIFFERENT_NUMBER - MINIMAL_DIFFERENT_NUMBER) + MINIMAL_DIFFERENT_NUMBER
            );
        }
    }

    @Test
    public void fromConfigToLevel() {
        for (Config config : configs) {
            assertThat(prototype.fromConfigToLevel(config), lessThan(prototype.getLastLevel() + 1));
            assertThat(prototype.fromConfigToLevel(config), greaterThan(prototype.getFirstLevel() - 1));
        }
    }

    @Test
    public void fromLevelToConfig() {
        for (int i = prototype.getFirstLevel(); i < prototype.getLastLevel(); i++) {
            assertThat(prototype.fromLevelToConfig(i), notNullValue());
        }
    }
}