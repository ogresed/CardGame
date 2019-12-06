package view;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class MainMenu extends MainFrame{

    public MainMenu(){
        super();
        setSize(600, 600);
        AddPanels();

        setVisible(true);
    }


    void AddButtons(){
        CreateButtons();
        menuPanel.add(exitButton);
    }

    void CreateButtons(){
        exitButton = new JButton(new ImageIcon("resources/icons/exit.jpg") );
        exitButton.setBackground(Color.BLUE);
        exitButton.addActionListener(e -> onExit());
    }

    void CreatePanels(){
        menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(6, 1));
        AddBackground();
    }

    void AddPanels(){
        CreatePanels();
        AddButtons();
        add(menuPanel);
    }

    void AddBackground(){
        menuPanel.setBorder(new MatteBorder(borderSize,borderSize,borderSize,borderSize, new ImageIcon("resources/backgrounds/43MW.gif")));
    }

    private void onExit() {
        System.exit(0);
    }

    private JButton exitButton;
    private JPanel menuPanel;
    private int borderSize = 100;
}
