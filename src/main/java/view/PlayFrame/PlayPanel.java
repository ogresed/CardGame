package view.PlayFrame;

import javax.swing.*;
import java.awt.*;

public class PlayPanel extends JPanel {
    private GridPanel gridPanel;
    private WinPanel winPanel;

    public  PlayPanel(){
        setLayout(new BorderLayout(0,0));
        gridPanel = new GridPanel();
        add(gridPanel, BorderLayout.NORTH);

    }
}
