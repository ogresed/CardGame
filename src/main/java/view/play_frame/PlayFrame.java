package view.play_frame;

import view.MainFrame;

public class PlayFrame extends MainFrame {


    public PlayFrame(){
        super();
        setSize(600, 700);
        PlayPanel fieldPanel = new PlayPanel();
        setContentPane(fieldPanel);

        setVisible(false);
    }

    public void Play()
    {
        setVisible(true);
    }


}


