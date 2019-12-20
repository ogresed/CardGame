package view;

import view.play_frame.PlayFrame;

import javax.swing.*;
import java.awt.*;

public class AuthorizationFrame extends MainFrame{

    private PlayFrame playFrame = new PlayFrame();
    private  JButton ok;
    private JPanel panel;
    private JTextField textField;
    private JLabel label = new JLabel("                Hello, please, enter your name");
    private String name;

    AuthorizationFrame(){
        super();
        setLayout(new BorderLayout(3,3));
        setSize(400, 200);
        addButton();

        add(panel, BorderLayout.SOUTH);createTextArea();
        add(textField, BorderLayout.CENTER);
        add(label, BorderLayout.NORTH);

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
}
