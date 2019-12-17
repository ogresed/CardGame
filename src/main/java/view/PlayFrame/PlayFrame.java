package view.PlayFrame;

import view.MainFrame;

public class PlayFrame extends MainFrame {


    private PlayPanel fieldPanel;

    public PlayFrame(){
        super();
        setSize(700, 600);
        setResizable(false);
        fieldPanel = new PlayPanel();
        setContentPane(fieldPanel);

        setVisible(false);
    }

    public void Play()
    {
        setVisible(true);
    }


}


