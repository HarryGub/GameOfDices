package GameOfDice;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void play() {
        Game game = new Game();
        game.Play(3, 4, 5);
        int n = Game.n;
        int k = Game.k;
        int m = Game.m;
        assertEquals(3, n);
        assertEquals(4, k);
        assertEquals(5, m);
    }

    @Test
    void END() {
        Game game = new Game();
        game.Play(3, 4, 5);
        for(int i =0; i < 1000000000; i++)
            i = i;
        assertEquals(true, Game.END());
    }
}