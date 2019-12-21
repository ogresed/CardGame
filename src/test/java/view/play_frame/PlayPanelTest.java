package view.play_frame;

import game.field.WrongParametersException;
import main.Main;
import org.junit.Test;
import view.AuthorizationFrame;
import view.MainMenu;
import view.SaveFrame;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static view.play_frame.PlayPanel.setStartLevel;

public class PlayPanelTest {
    @Test
    public void mainFrameTesting() {
        setStartLevel(-1);
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

    @Test
    public void mainMenuTesting() {
        String wrongThrowingTest = "wrong";
        String trueThrowingTest = "true";
        String expected = wrongThrowingTest;
        setStartLevel(-1);

        try {
            new MainMenu();
        } catch (Exception e) {
            expected = trueThrowingTest;
        }
        finally {
            assertThat(expected, equalTo(trueThrowingTest));
        }
    }

    @Test
    public void saveFrameTesting() {
        String wrongThrowingTest = "wrong";
        String trueThrowingTest = "true";
        String expected = trueThrowingTest;

        try {
            new SaveFrame();
        } catch (Exception e) {
            expected = wrongThrowingTest;
        }
        finally {
            assertThat(expected, equalTo(trueThrowingTest));
        }
    }

    @Test
    public void authorizationFrameTesting() {
        String wrongThrowingTest = "wrong";
        String trueThrowingTest = "true";
        String expected = wrongThrowingTest;
        try {
            new AuthorizationFrame();
        } catch (Exception e) {
            expected = trueThrowingTest;
        }
        finally {
            assertThat(expected, equalTo(trueThrowingTest));
        }
    }

}