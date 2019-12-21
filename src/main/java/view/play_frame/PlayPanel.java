package view.play_frame;

import javax.swing.*;
import java.awt.*;

class PlayPanel extends JPanel {
    static void setStartLevel(int startLevel) {
        PlayPanel.startLevel = startLevel;
    }

    private static int startLevel = 3;

    PlayPanel(){
        setLayout(new BorderLayout(2,2));
        GridPanel gridPanel = new GridPanel(startLevel);
        add(gridPanel, BorderLayout.CENTER);

        ScorePanel scorePanel = new ScorePanel();
        add(scorePanel, BorderLayout.SOUTH);
    }
}
