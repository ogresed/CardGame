package main;

import view.MainFrame;

import javax.swing.*;
import java.awt.*;

public class Main extends MainFrame {

    public static void main(String[] args) {
        new Main();
    }

    Main(){
        super();
        setSize(600, 600);
        AddPanels();

        setVisible(true);
    }

    void AddButtons(){
        CreateButtons();
        exitPanel.add(exitButton, BorderLayout.NORTH);
    }

    void CreateButtons(){
        exitButton = new JButton("Exit" );
        exitButton.setBackground(Color.BLACK);
    }

    void CreatePanels(){
        exitPanel = new JPanel();
    }

    void AddPanels(){
        CreatePanels();
        this.add(exitPanel);
        AddButtons();
    }

    public void onExit() {
        System.exit(0);
    }

    private JButton exitButton;
    private JPanel exitPanel;
}
