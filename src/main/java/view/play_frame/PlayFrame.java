package view.play_frame;

import view.MainFrame;

public class PlayFrame extends MainFrame {


    private PlayPanel fieldPanel;

    public PlayFrame(){
        super();
        setSize(600, 700);
        fieldPanel = new PlayPanel();
        setContentPane(fieldPanel);

        setVisible(false);
    }

    public void Play()
    {
        setVisible(true);
    }


}


