package game;

public class Config {
     private int horizontal;
    private int vertical;
    private int differentCards;

    public Config(int horizontal, int vertical, int differentCards) {
        this.horizontal = horizontal;
        this.vertical = vertical;
        this.differentCards = differentCards;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(int horizontal) {
        this.horizontal = horizontal;
    }

    public int getVertical() {
        return vertical;
    }

    public void setVertical(int vertical) {
        this.vertical = vertical;
    }

    public int getDifferentCards() {
        return differentCards;
    }

    public void setDifferentCards(int differentCards) {
        this.differentCards = differentCards;
    }
}
