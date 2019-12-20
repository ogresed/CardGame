package game;

import java.util.Objects;

public class Config {
     private int horizontal;
    private int vertical;
    private int differentCards;

    public Config(int horizontal, int vertical, int differentCards) {
        this.horizontal = horizontal;
        this.vertical = vertical;
        this.differentCards = differentCards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Config config = (Config) o;
        return horizontal == config.horizontal &&
                vertical == config.vertical &&
                differentCards == config.differentCards;
    }

    @Override
    public int hashCode() {
        return Objects.hash(horizontal, vertical, differentCards);
    }

    public int getHorizontal() {
        return horizontal;
    }

    public int getVertical() {
        return vertical;
    }

    public int getDifferentCards() {
        return differentCards;
    }

    void setDifferentCards(int differentCards) {
        this.differentCards = differentCards;
    }
}
