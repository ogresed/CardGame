package game;

import game.field.Field;
import game.field.WrongParametersException;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ThrowWrongParamTest {
    @Test
    public void gameNoParameters() {

        String wrongThrowingTest = "wrong";
        String trueThrowingTest = "true";
        String expected = trueThrowingTest;
        try {
            Field field = new Field(new Config(-1, -1, -1));
        } catch (WrongParametersException e) {
            expected = trueThrowingTest;
        }
        finally {
            assertThat(expected, equalTo(trueThrowingTest));
        }
    }
}
