package view;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class MainMenu extends MainFrame{

    public MainMenu(){
        super();
        setSize(700, 600);
        setResizable(false);
        AddPanels();

        setVisible(true);
    }


    private void AddButtons(){
        CreateButtons();
        menuPanel.add(playButton);
        menuPanel.add(saveButton);
        menuPanel.add(loadButton);
        menuPanel.add(topButton);
        menuPanel.add(exitButton);
    }

    private void CreateButtons(){
        playButton = new JButton(new ImageIcon("resources/icons/play.jpg") );
        playButton.addActionListener(e -> Authorise());
        saveButton = new JButton(new ImageIcon("resources/icons/save.jpg") );
        saveButton.addActionListener(e -> saveFrame.showSaveFrame());
        loadButton = new JButton(new ImageIcon("resources/icons/load.jpg") );
        topButton = new JButton(new ImageIcon("resources/icons/top.jpg") );
        exitButton = new JButton(new ImageIcon("resources/icons/exit.jpg") );
        exitButton.addActionListener(e -> onExit());
    }

    private void CreatePanels(){
        menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(5, 1));
        AddBackground();
    }

    private void Authorise(){
        authorizationFrame.Authorise();
        setVisible(false);
    }

    private void AddPanels(){
        CreatePanels();
        AddButtons();
        add(menuPanel);
    }

    private void AddBackground(){
        int borderSize = 100;
        menuPanel.setBorder(new MatteBorder(borderSize, borderSize, borderSize, borderSize, new ImageIcon("resources/backgrounds/43MW.gif")));
    }

    private void onExit() {
        System.exit(0);
    }

    private JButton exitButton;
    private JButton saveButton;
    private JButton loadButton;
    private JButton playButton;
    private JButton topButton;
    private JPanel menuPanel;

    private AuthorizationFrame authorizationFrame = new AuthorizationFrame();
    private SaveFrame saveFrame = new SaveFrame();
}
