package view.play_frame;

import game.Game;
import game.Config;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GridPanel extends JPanel {

    private int numButtons;
    private static String[] pics = {
            "resources/card_images/6d76bca8aa50fe6b50776d76c5259a22.jpg",
            "resources/card_images/18-187597_koala-bearsteddy-bearscute-cliparttatty-panda-bear-cartoon-cute.jpg",
            "resources/card_images/281b3d600f48ab1a98a5f47c3feed338.jpg",
            "resources/card_images/animal-1297724_1280.jpg",
            "resources/card_images/d8d93e3c0a33f24f40e9524f8efd8281.jpg",
            "resources/card_images/f9c3c8885e3eb067aaca6fc4eb5001fd.jpg",
            "resources/card_images/kisspng-domestic-rabbit-easter-bunny-hare-illustration-5ca5b50ea7f860.270122221554363662688.jpg",
            "resources/card_images/kisspng-raccoon-cartoon-clip-art-raccoons-and-hammered-dulcimer-5b031de19dd766.8376373915269309136465.jpg",
            "resources/card_images/kisspng-tiger-cartoon-clip-art-enfant-5ac9d2ca81c289.3685579815231761385315.jpg",
            "resources/card_images/s1200.jpg"};

    private static JButton[] buttons;
    private ImageIcon cardBack = new ImageIcon("resources/backgrounds/375666.jpg");
    private ImageIcon[] icons;

    private int openImages;
    private int currentIndex;
    private int oddClickIndex;

    private Timer myTimer;
    private transient Game game;
    private transient Config config;
    private int sizeX;
    private ScorePanel scorePanel;

    private static void createButtons(int numButtons, int sizeX, int sizeY) {
        buttons = new JButton[numButtons];
        for(int i = 0; i < sizeY; i++)
            for(int j = 0; j < sizeX; j++){
                int index = i*sizeX + j;
                buttons[index] = new JButton();
            }
    }

    GridPanel(int startLevel, ScorePanel scorePanel)
    {
        this.scorePanel = scorePanel;
        //вызвать конструктор game
        game = new Game(startLevel);
        setVisible(true);
        //получить размеры поля
        config = game.getConfig();
        setBorder(new EmptyBorder(0,0,0,0));
        addButtons();
    }

    private void addButtons()
    {
        int sizeY = config.getVertical();
        sizeX = config.getHorizontal();
        setLayout(new GridLayout(sizeY, sizeX));
        numButtons = sizeX * sizeY;
        createButtons(numButtons, sizeX, sizeY);
        icons = new ImageIcon[numButtons];

        for(int i = 0; i < sizeY; i++)
            for(int j = 0; j < sizeX; j++){
                int cellValue = game.getCell(j, i);
                int index = i*sizeX + j;
                icons[index] = new ImageIcon(pics[cellValue]);
                buttons[index].addActionListener(new ImageButtonListener());
                buttons[index].setIcon(cardBack);
                add(buttons[index]);
        }

        myTimer = new Timer(1000, new TimerListener());
    }

    private class ImageButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(myTimer.isRunning())
                return;
            openImages++;
            for(int i = 0; i < numButtons; i++){
                if(e.getSource() == buttons[i]){
                    buttons[i].setIcon(icons[i]);
                    currentIndex = i;
                    break;
                }
            }

            if(openImages % 2 == 0){
                if(currentIndex == oddClickIndex){
                    return;
                }
                int fx = currentIndex % sizeX;
                int fy = currentIndex / sizeX;
                int sx = oddClickIndex % sizeX;
                int sy = oddClickIndex / sizeX;
                if(!game.toAddPoints(fx, fy, sx, sy)) {
                    myTimer.start();
                } else {
                    //метод из game в случае двух клеток с одинаковыми картинками
                    //прибавить текущий счетчик очков
                    // вернуть текущий счетчик очков из game
                    scorePanel.getPoints().setText(Integer.toString(
                            game.getGlobalPoints() + game.getCurrentLevelPoints()));
                    //проверка на gameOver
                    if(game.levelIsOver()) {
                        game.nextLevel();
                        config = game.getConfig();
                        removeButtons();
                        addButtons();
                        repaint();
                    }
                }
            } else {
                oddClickIndex = currentIndex;
            }
        }
    }

    private void removeButtons() {
        removeAll();
    }

    private class TimerListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            buttons[currentIndex].setIcon(cardBack);
            buttons[oddClickIndex].setIcon(cardBack);
            myTimer.stop();
        }
    }
}
