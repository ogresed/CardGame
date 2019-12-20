package view.PlayFrame;

import javax.swing.*;
import java.awt.*;

public class PlayPanel extends JPanel {
    private GridPanel gridPanel;
    private WinPanel winPanel;
    private ScorePanel scorePanel;

    public  PlayPanel(){
        setLayout(new BorderLayout(2,2));
        gridPanel = new GridPanel();
        add(gridPanel, BorderLayout.CENTER);

        scorePanel = new ScorePanel();
        add(scorePanel, BorderLayout.SOUTH);
    }
}
