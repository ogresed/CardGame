package game;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GameNoParametersTest {
    @Test
    public void gameNoParameters() {
        String wrongThrowingTest = "wrong";
        String trueThrowingTest = "true";
        String expected = trueThrowingTest;
        try {
            new Game();
        } catch (Exception e) {
            expected = wrongThrowingTest;
        }
        finally {
            assertThat(expected, equalTo(trueThrowingTest));
        }
    }
}
