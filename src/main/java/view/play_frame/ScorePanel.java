package view.play_frame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

class ScorePanel extends JPanel {

    static JLabel getPoints() {
        return points;
    }

    private static JLabel points;

    ScorePanel(){
        JLabel score = new JLabel("Score");
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
