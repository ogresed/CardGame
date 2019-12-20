package view.play_frame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ScorePanel extends JPanel {
    JLabel score;

    static public JLabel getPoints() {
        return points;
    }

    static JLabel points;

    ScorePanel(){
        score = new JLabel("Score");
        points = new JLabel(" 0 ");
        setBorder(new EmptyBorder(0,0,0,0));
        setLayout(new GridLayout(2,1,0,0));

        add(score);
        add(points);
        setVisible(true);

        validate();
        repaint();
    }
}
