package view.PlayFrame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ScorePanel extends JPanel {
    JLabel score;
    static JLabel points;

    ScorePanel(){
        score = new JLabel("Score");
        points = new JLabel("");
        setBorder(new EmptyBorder(0,0,0,0));
        setLayout(new GridLayout(0,1,0,0));
        setBackground(Color.CYAN);
        setVisible(true);

        add(score);
        validate();
        repaint();
    }
}
