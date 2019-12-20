package view.play_frame;

import javax.swing.*;
import java.awt.*;

public class PlayPanel extends JPanel {
    public static void setStartLevel(int startLevel) {
        PlayPanel.startLevel = startLevel;
    }

    private static int startLevel = 3;
    private GridPanel gridPanel;
    private WinPanel winPanel;
    private ScorePanel scorePanel;

    public  PlayPanel(){
        setLayout(new BorderLayout(2,2));
        gridPanel = new GridPanel(startLevel);
        add(gridPanel, BorderLayout.CENTER);

        scorePanel = new ScorePanel();
        add(scorePanel, BorderLayout.SOUTH);
    }
}
