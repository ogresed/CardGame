package view;

public class PlayFrame extends MainFrame{

    public PlayFrame(){
        super();
        setSize(700, 600);
        setResizable(false);

        setVisible(false);
    }

    public void Play()
    {
        setVisible(true);
    }
}
