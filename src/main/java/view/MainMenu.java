package view;

import javax.swing.*;
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
        exitButton = new JButton("Exit" );
        exitButton.addActionListener(e -> onExit());
    }

    void CreatePanels(){
        menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(6, 1));
    }

    void AddPanels(){
        CreatePanels();
        AddButtons();
        add(menuPanel);
    }

    private void onExit() {
        System.exit(0);
    }

    private JButton exitButton;
    private JPanel menuPanel;
    private JPanel mainPanel;//меню + фон
}
