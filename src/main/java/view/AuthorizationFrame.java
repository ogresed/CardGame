package view;

import view.play_frame.PlayFrame;

import javax.swing.*;
import java.awt.*;

public class AuthorizationFrame extends MainFrame{

    private PlayFrame playFrame = new PlayFrame();
    private  JButton ok;
    private JPanel panel;

    AuthorizationFrame(){
        super();
        setLayout(new BorderLayout(2,2));
        setSize(700, 200);
        addButton();

        add(panel, BorderLayout.SOUTH);

        setVisible(false);
    }

    public void Authorise() {
        setVisible(true);
    }

    private void addButton(){
        createPanel();
        ok = new JButton("ok");
        ok.addActionListener(event -> playFrame.Play());
        panel.add(ok);
    }

    private void createPanel(){

        panel = new JPanel();
    }
}
