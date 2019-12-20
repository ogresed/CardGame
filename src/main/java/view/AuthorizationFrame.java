package view;

import view.play_frame.PlayFrame;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class AuthorizationFrame extends MainFrame{

    private PlayFrame playFrame = new PlayFrame();
    private  JButton ok;
    private JPanel panel;
    private JTextField textField;
    private JLabel label = new JLabel("                Hello, please, enter your name");
    private String name;
    private int borderSize = 30;

    AuthorizationFrame(){
        super();
        setLayout(new BorderLayout(3,3));
        setSize(400, 200);
        addButton();

        AddBackground();
        add(panel);

        setVisible(false);
    }

    public void Authorise() {
        setVisible(true);
    }

    private void addButton(){
        createPanel();
        ok = new JButton("ok");
        ok.addActionListener(event -> onPlay());
        panel.add(ok);
    }

    private void createPanel(){
        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        createTextArea();
        panel.add(label);
        panel.add(textField);
    }

    private void onPlay(){
        if(textField.getText().isEmpty())
            return;
        name = textField.getText();
        playFrame.Play();
        setVisible(false);
    }

    private void createTextArea(){
        textField = new JTextField();
    }

    void AddBackground(){
        panel.setBorder(new MatteBorder(borderSize,borderSize,borderSize,borderSize, new ImageIcon("resources/backgrounds/MXep.gif")));
    }
}
