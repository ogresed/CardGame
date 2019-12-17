package view;

import javax.swing.*;
import java.awt.*;

public class PlayFrame extends MainFrame{


    private JPanel fieldPanel;

    public PlayFrame(){
        super();
        setSize(700, 600);
        setResizable(false);
        AddPanels();

        setVisible(false);
    }

    public void Play()
    {
        setVisible(true);
    }

    void CreatePanels(int y, int x){
        fieldPanel = new JPanel();
        fieldPanel.setLayout(new GridLayout(x, y));
    }

    void AddPanels(){
        CreatePanels(10, 10);
        FillField();
        add(fieldPanel);
    }

    void FillField()
    {

    }
}


