package view.PlayFrame;

import game.Game;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GridPanel extends JPanel {

    int numButtons;
    static String pics[] = {"resources/card_images/6d76bca8aa50fe6b50776d76c5259a22.jpg",
            "resources/card_images/18-187597_koala-bearsteddy-bearscute-cliparttatty-panda-bear-cartoon-cute.jpg",
            "resources/card_images/281b3d600f48ab1a98a5f47c3feed338.jpg",
            "resources/card_images/animal-1297724_1280.jpg",
            "resources/card_images/d8d93e3c0a33f24f40e9524f8efd8281.jpg",
            "resources/card_images/f9c3c8885e3eb067aaca6fc4eb5001fd.jpg",
            "resources/card_images/kisspng-domestic-rabbit-easter-bunny-hare-illustration-5ca5b50ea7f860.270122221554363662688.jpg",
            "resources/card_images/kisspng-raccoon-cartoon-clip-art-raccoons-and-hammered-dulcimer-5b031de19dd766.8376373915269309136465.jpg",
            "resources/card_images/kisspng-tiger-cartoon-clip-art-enfant-5ac9d2ca81c289.3685579815231761385315.jpg",
            "resources/card_images/s1200.jpg"};

    static JButton[] buttons;
    ImageIcon cardBack = new ImageIcon("resources/backgrounds/375666.jpg");
    ImageIcon[] icons;
    private ImageIcon temp;
    private boolean gameOver;
    int openImages;
    public int currentIndex;
    public int oddClickIndex;
    Timer myTimer;
    Game game;

    public GridPanel()
    {
        //вызвать конструктор game
        setVisible(true);
        //получить размеры поля
        setBorder(new EmptyBorder(0,0,0,0));
        setLayout(new GridLayout(4,4,0,0));//записать вместо 4 длину и ширину поля
        addButtons();
    }

    private void addButtons()
    {
        numButtons = 16;//вместо 16 длина поля*ширина поля
        int sizeY = 4;//вместо 4 получить высоту поля
        int sizeX = 3;//вместо 4 получить ширину поля
        buttons = new JButton[numButtons];
        icons = new ImageIcon[numButtons];

        for(int i = 0; i < sizeY; i++)
            for(int j = 0; j < sizeX; j++){
            icons[i*sizeY + j] = new ImageIcon(pics[i]);//вместо i получить номер картинки для клетки с координатами j,i в pics[i]
            buttons[i*sizeY + j] = new JButton();
            buttons[i*sizeY + j].addActionListener(new ImageButtonListener());
            buttons[i*sizeY + j].setIcon(cardBack);
            add(buttons[i*sizeY + j]);
        }

        myTimer = new Timer(1000, new TimerListener());
    }

    private class ImageButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(myTimer.isRunning())
                return;
            openImages++;
            for(int i = 0; i < numButtons; i++){
                if(e.getSource() == buttons[i]){
                    buttons[i].setIcon(icons[i]);
                    currentIndex = i;
                }
            }
        }
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
