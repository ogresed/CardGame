package main;

import game.Game;
import view.MainMenu;

public class Main extends MainMenu {

    public static void main(String[] args) {
        //new Main();
        Game game =  new Game(2);
        game.getCell(3, 4);
        /*for (int i = 1; i <= 20; i++) {
            new  Game(i);
        }*/
    }

    Main(){
        super();
    }
}
