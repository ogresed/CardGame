package view.play_frame;

import game.field.WrongParametersException;
import main.Main;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static view.play_frame.PlayPanel.startLevel;

public class PlayPanelTest {
    @Test
    public void mainFrameTesting() {
        startLevel = -1;
        String wrongThrowingTest = "wrong";
        String trueThrowingTest = "true";
        String expected = wrongThrowingTest;
        try {
            new Main();
        } catch (WrongParametersException e) {
            expected = trueThrowingTest;
        }
        finally {
            assertThat(expected, equalTo(trueThrowingTest));
        }
    }
}